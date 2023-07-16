/**
* HackerNewsCommentMapper
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-17
*/
package com.questionpro.hackernewspi.mapper;

import java.util.List;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import com.questionpro.hackernewspi.Model.Comment;
import com.questionpro.hackernewspi.Model.HackerNewsComment;

@Mapper(componentModel= "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface HackerNewsCommentMapper {

	/**
	 * This method is used to Map Comment model to HackerNewsComment model
	 * 
	 * @param model- {@link Comment}
	 * @return {@link HackerNewsComment}
	 */
	HackerNewsComment map(Comment model);

	/**
	 * This method is used to Map List of Comment model to List of HackerNewsComment
	 * model
	 * 
	 * @param model- List of {@link Comment}
	 * @return List of {@link HackerNewsComment}
	 */
	List<HackerNewsComment> map(List<Comment> model);

}