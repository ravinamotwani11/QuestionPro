/**
* Comment Model
*
* @author  Ravina Motwani
* @version 1.0
* @since   2023-07-17
*/
package com.questionpro.hackernewspi.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comment {

    private String text;
    @JsonProperty("by")
    private String user;
    private String[] kids;

    public Comment() {
        // Default constructor required for JSON deserialization
    }

    public Comment(String text, String user, String[] kids) {
        this.text = text;
        this.user = user;
        this.kids = kids;
    }
    // Getters and setters

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

	public String[] getKids() {
		return kids;
	}

	public void setKids(String[] kids) {
		this.kids = kids;
	}
	
	public int getKidsCount() {
        return kids != null ? kids.length : 0;
    }
    
}
