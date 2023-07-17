/**
* HackerNewsApiServiceImplentation
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-17
*/
package com.questionpro.hackernewspi.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.questionpro.hackernewspi.Model.Comment;
import com.questionpro.hackernewspi.Model.HackerNewsComment;
import com.questionpro.hackernewspi.Model.HackerNewsStory;
import com.questionpro.hackernewspi.Model.Story;
import com.questionpro.hackernewspi.mapper.HackerNewsCommentMapper;
import com.questionpro.hackernewspi.mapper.HackerNewsStoryMapper;

@Service
public class HackerNewsApiServiceImplentation implements HackerNewsApiService {

	private static final String API_BASE_URL = "https://hacker-news.firebaseio.com/v0/";
	private static final String TOP_STORIES_URL = API_BASE_URL + "topstories.json";
	private static final String ITEM_URL = API_BASE_URL + "item/%s.json";

	private RestTemplate restTemplate;
	private final Map<Long, Story> topStoriesCache = new ConcurrentHashMap<>();
	private LocalDateTime cacheExpiryTime;
	private Set<HackerNewsStory> pastStories;

	private HackerNewsCommentMapper hackerNewsCommentMapper;
	private HackerNewsStoryMapper hackerNewsStoryMapper;

	public HackerNewsApiServiceImplentation(HackerNewsCommentMapper hackerNewsCommentMapper, HackerNewsStoryMapper hackerNewsStoryMapper) {
		restTemplate = new RestTemplate();
		this.hackerNewsCommentMapper = hackerNewsCommentMapper;
		this.hackerNewsStoryMapper = hackerNewsStoryMapper;
		pastStories = new HashSet<>();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<HackerNewsStory> getTopStories() {
		if (cacheExpiryTime != null && LocalDateTime.now().isBefore(cacheExpiryTime)) {
			return hackerNewsStoryMapper.map(new ArrayList<>(topStoriesCache.values()));
		}

		ResponseEntity<Long[]> response = restTemplate.getForEntity(TOP_STORIES_URL, Long[].class);
		Long[] storyIds = response.getBody();

		if (storyIds == null) {
			throw new RuntimeException("Failed to fetch top story IDs from Hacker News API");
		}

		List<Story> topStories = Arrays.stream(storyIds).limit(10).map(this::getStoryById).collect(Collectors.toList());

		List<Story> sortedTopStories = topStories.stream().sorted(Comparator.comparingInt(Story::getScore).reversed())
				.collect(Collectors.toList());

		List<HackerNewsStory> hackerNewsSortedTopStories = hackerNewsStoryMapper.map(sortedTopStories);

		pastStories.addAll(hackerNewsSortedTopStories);
		cacheExpiryTime = LocalDateTime.now().plusMinutes(15);
		topStoriesCache.clear();
		topStories.forEach(story -> topStoriesCache.put(story.getId(), story));

		return hackerNewsSortedTopStories;
	}

	/**
	 * This method is used to fetch story by id
	 * 
	 * @param storyId - The story Id
	 * @return {@link Story}
	 */
	private Story getStoryById(Long storyId) {
		ResponseEntity<Story> response = restTemplate.getForEntity(String.format(ITEM_URL, storyId), Story.class);
		return response.getBody();
	}

	/**
	 * {@inheritDoc}
	 */
	public Set<HackerNewsStory> getPastStories() {
		return pastStories;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<HackerNewsComment> getTopCommentsByChildCount(String storyId) {
		String storyUrl = String.format(ITEM_URL, storyId);
		Comment story = restTemplate.getForObject(storyUrl, Comment.class);

		if (story == null || story.getKids() == null || story.getKids().length == 0) {
			return List.of(); // No comments available
		}
		List<Comment> commentList = Arrays.stream(story.getKids()).map(this::getComment)
				.sorted(Comparator.comparingInt(Comment::getKidsCount).reversed()).limit(10)
				.collect(Collectors.toList());

		List<HackerNewsComment> hackerNewsCommentList = hackerNewsCommentMapper.map(commentList);
		return hackerNewsCommentList;
	}

	/**
	 * This method is used to get comments
	 * 
	 * @param commentId
	 * @return {@link Comment}
	 */
	private Comment getComment(String commentId) {
		String storyUrl = String.format(ITEM_URL, commentId);
		return restTemplate.getForObject(storyUrl, Comment.class);
	}
}
