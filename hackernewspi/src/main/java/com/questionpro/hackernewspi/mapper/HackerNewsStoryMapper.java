/**
* HackerNewsStoryMapper
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-17
*/
package com.questionpro.hackernewspi.mapper;

import java.util.List;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

import com.questionpro.hackernewspi.Model.HackerNewsStory;
import com.questionpro.hackernewspi.Model.Story;

@Mapper(componentModel= "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface HackerNewsStoryMapper {

	/**
	 * This method is used to Map Story model to HackerNewsStory model
	 * 
	 * @param model- {@link Story}
	 * @return {@link HackerNewsStory}
	 */
	HackerNewsStory map(Story model);

	/**
	 * This method is used to Map List of Story model to List of HackerNewsStory
	 * model
	 * 
	 * @param model- List of {@link Story}
	 * @return List of {@link HackerNewsStory}
	 */
	List<HackerNewsStory> map(List<Story> model);
}
