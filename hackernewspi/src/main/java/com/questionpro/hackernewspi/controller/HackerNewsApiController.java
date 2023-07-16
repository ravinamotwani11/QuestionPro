/**
* HackerNewsApiController
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-17
*/
package com.questionpro.hackernewspi.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.questionpro.hackernewspi.Model.HackerNewsComment;
import com.questionpro.hackernewspi.Model.Story;
import com.questionpro.hackernewspi.service.HackerNewsApiService;

@RestController
public class HackerNewsApiController {

	private final HackerNewsApiService hackerNewsApiService;

	@Autowired
	public HackerNewsApiController(HackerNewsApiService hackerNewsApiService) {
		this.hackerNewsApiService = hackerNewsApiService;
	}

	/**
	 * This endpoint is used to get top 10 stories
	 * 
	 * @return List of {@link Story}
	 */
	@GetMapping("/top-stories")
	public List<Story> getTopStories() {
		return hackerNewsApiService.getTopStories();
	}

	/**
	 * This endpoint is used to get all the stories that were served previously from
	 * the /top-stories endpoint
	 * 
	 * @return List of {@link Story}
	 */
	@GetMapping("/past-stories")
	public Set<Story> getPastStories() {
		return hackerNewsApiService.getPastStories();
	}

	/**
	 * This endpoint is used to return 10 comments (max) on a given story sorted by
	 * a total number of child comments
	 * 
	 * @return List of {@link HackerNewsComment}
	 */
	@GetMapping("/comments/{storyId}")
	public List<HackerNewsComment> getComments(@PathVariable String storyId) {
		return hackerNewsApiService.getTopCommentsByChildCount(storyId);
	}
}
