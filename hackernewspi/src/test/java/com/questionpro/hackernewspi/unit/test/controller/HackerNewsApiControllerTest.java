/**
* HackerNewsApiControllerTest
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-17
*/
package com.questionpro.hackernewspi.unit.test.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.questionpro.hackernewspi.Model.HackerNewsComment;
import com.questionpro.hackernewspi.Model.HackerNewsStory;
import com.questionpro.hackernewspi.Model.Story;
import com.questionpro.hackernewspi.controller.HackerNewsApiController;
import com.questionpro.hackernewspi.service.HackerNewsApiService;

@RunWith(MockitoJUnitRunner.class)
public class HackerNewsApiControllerTest {

	@Mock
	private HackerNewsApiService hackerNewsApiService;

	@InjectMocks
	private HackerNewsApiController hackerNewsApiController;

	@Before
	public void setUp() {
		// Setup any initial data or mock behavior here (if needed).
	}

	@Test
	public void testGetTopStories() {
		List<HackerNewsStory> mockTopStories = new ArrayList<>();
		// Add mock Story objects to the list.
		when(hackerNewsApiService.getTopStories()).thenReturn(mockTopStories);

		List<HackerNewsStory> topStories = hackerNewsApiController.getTopStories();
		assertEquals(mockTopStories, topStories);
	}

	@Test
	public void testGetPastStories() {
		Set<HackerNewsStory> mockPastStories = new HashSet<>();
		// Add mock Story objects to the set.
		when(hackerNewsApiService.getPastStories()).thenReturn(mockPastStories);

		Set<HackerNewsStory> pastStories = hackerNewsApiController.getPastStories();
		assertEquals(mockPastStories, pastStories);
	}

	@Test
	public void testGetComments() {
		String storyId = "123"; // Replace with a valid story ID.
		List<HackerNewsComment> mockComments = new ArrayList<>();
		// Add mock HackerNewsComment objects to the list.
		when(hackerNewsApiService.getTopCommentsByChildCount(storyId)).thenReturn(mockComments);

		List<HackerNewsComment> comments = hackerNewsApiController.getComments(storyId);
		assertEquals(mockComments, comments);
	}


}