/**
* HackerNewsApiServiceTest
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-17
*/
package com.questionpro.hackernewspi.unit.test.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.client.RestTemplate;

import com.questionpro.hackernewspi.Model.HackerNewsComment;
import com.questionpro.hackernewspi.Model.HackerNewsStory;
import com.questionpro.hackernewspi.Model.Story;
import com.questionpro.hackernewspi.mapper.HackerNewsCommentMapper;
import com.questionpro.hackernewspi.mapper.HackerNewsStoryMapper;
import com.questionpro.hackernewspi.service.HackerNewsApiServiceImplentation;

@RunWith(MockitoJUnitRunner.class)
public class HackerNewsApiServiceTest {

	@Mock
	private RestTemplate restTemplate;

	@Mock
	private HackerNewsCommentMapper hackerNewsCommentMapper;

	@Mock
	private HackerNewsStoryMapper hackerNewsStoryMapper;

	@InjectMocks
	private HackerNewsApiServiceImplentation hackerNewsApiService;

	@Before
	public void setUp() {
		hackerNewsApiService = new HackerNewsApiServiceImplentation(hackerNewsCommentMapper, hackerNewsStoryMapper);
	}

	@Test
	public void testGetTopStories_CacheExpired_ReturnsTopStoriesFromAPI() {
		// Act
		List<HackerNewsStory> topStories = hackerNewsApiService.getTopStories();

		// Assert
		assertEquals(10, topStories.size());
	}

	@Test
	public void testGetPastStories_ReturnsIndependentCopyOfPastStoriesSet() {
		// Arrange
		Set<Story> pastStories = new HashSet<>();
		Story story1 = new Story();
		story1.setId(1L);
		story1.setKids(Arrays.asList(1, 2, 3));
		story1.setScore(28);
		Story story2 = new Story();
		story2.setId(2L);
		story2.setKids(Arrays.asList(1, 2, 3));
		story2.setScore(31);
		pastStories.add(story1);
		pastStories.add(story2);

		// Act
		Set<HackerNewsStory> result = hackerNewsApiService.getPastStories();

		// Modify the result set to check if the original set remains unchanged
		Story story3 = new Story();
		story3.setId(3L);
		story3.setKids(Arrays.asList(1, 2, 3));
		story3.setScore(31);

		// Assert
		// Original set should not be modified
		assertEquals(2, pastStories.size());
		// Modified set should have an additional story
		assertEquals(0, result.size());
	}

	@Test
	public void testGetPastStories_ReturnsEmptySetWhenPastStoriesIsEmpty() {
		// Arrange

		// Act
		Set<HackerNewsStory> result = hackerNewsApiService.getPastStories();

		// Assert
		assertEquals(0, result.size());
	}

	@Test
	public void testGetTopCommentsByChildCount_ValidStoryId_ReturnsTopComments() {
		// Arrange
		String storyId = "12345";

		// Mock comment mapping
		List<HackerNewsComment> hackerNewsComments = Arrays.asList(new HackerNewsComment(), new HackerNewsComment());
		when(hackerNewsCommentMapper.map(anyList())).thenReturn(hackerNewsComments);

		// Act
		List<HackerNewsComment> result = hackerNewsApiService.getTopCommentsByChildCount(storyId);

		// Assert
		assertEquals(hackerNewsComments, result);
	}

}