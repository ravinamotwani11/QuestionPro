/**
* HackerNewsStory Model
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-17
*/
package com.questionpro.hackernewspi.Model;

public class HackerNewsStory {

	private String title;
	private String url;
	private int score;
	private String user;
	private long submissionTime;

	// Constructors

	public HackerNewsStory() {

	}

	public HackerNewsStory(String title, String url, int score, String user, long submissionTime) {
		super();
		this.title = title;
		this.url = url;
		this.score = score;
		this.user = user;
		this.submissionTime = submissionTime;
	}

	// Getters and Setters
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public long getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(long submissionTime) {
		this.submissionTime = submissionTime;
	}

}
