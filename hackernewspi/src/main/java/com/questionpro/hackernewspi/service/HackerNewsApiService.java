/**
* HackerNewsApiService
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-17
*/
package com.questionpro.hackernewspi.service;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;
import com.questionpro.hackernewspi.Model.HackerNewsComment;
import com.questionpro.hackernewspi.Model.HackerNewsStory;

@Service
public interface HackerNewsApiService {

	/**
	 * This method is used to get the list of top stories
	 * 
	 * @return List of {@link HackerNewsStory}
	 */
	public List<HackerNewsStory> getTopStories();

	/**
	 * This method is used to get past stories
	 * 
	 * @return Set of {@link HackerNewsStory}
	 */
	public Set<HackerNewsStory> getPastStories();

	/**
	 * This method is used to get top comments by child count
	 * 
	 * @param storyId - The story id
	 * @return List of {@link HackerNewsComment}
	 * @throws IOException
	 */
	public List<HackerNewsComment> getTopCommentsByChildCount(String storyId);

}
