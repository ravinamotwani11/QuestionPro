/**
* HackerNewsComment Model
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-17
*/
package com.questionpro.hackernewspi.Model;

public class HackerNewsComment {

	private String text;
	private String user;

	// Constructors

	public HackerNewsComment() {

	}

	public HackerNewsComment(String text, String user) {
		super();
		this.text = text;
		this.user = user;
	}

	// Getters, and setters
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

}
