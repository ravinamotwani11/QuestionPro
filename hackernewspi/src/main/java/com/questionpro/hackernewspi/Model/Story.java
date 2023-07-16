/**
* Story Model
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-17
*/
package com.questionpro.hackernewspi.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Story {
	private Long id;
	private String title;
	private String url;
	private int score;
	@JsonProperty("by")
	private String user;
	@JsonProperty("time")
	private long submissionTime;
	// List of comment IDs
	private List<Integer> kids;

	// Constructors
	
	public Story() {
		
	}
	
	public Story(String title, String url, int score, String user, long submissionTime, List<Integer> kids, Long id) {
		super();
		this.id=id;
		this.title = title;
		this.url = url;
		this.score = score;
		this.user = user;
		this.submissionTime = submissionTime;
		this.kids = kids;
	}

	// Getters and setters

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

	public long getSubmissionTime() {
		return submissionTime;
	}

	public void setSubmissionTime(long submissionTime) {
		this.submissionTime = submissionTime;
	}

	public List<Integer> getKids() {
		return kids;
	}

	public void setKids(List<Integer> kids) {
		this.kids = kids;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Story [title=" + title + ", url=" + url + ", score=" + score + ", user=" + user + ", submissionTime="
				+ submissionTime + ", kids=" + kids + "]";
	}
}