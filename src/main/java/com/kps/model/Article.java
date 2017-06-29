package com.kps.model;

import javax.validation.constraints.Size;

public class Article {
	
	private int id;
	
	@Size(min=3, max=10/*, message = "{0} must between {1} and {2} characters long."*/)
	private String title;
	
	private String description;
	private String thumbnail;
	private String author;

	public Article() {
		super();
	}
	public Article(int id, String title, String description, String thumbnail, String author) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.thumbnail = thumbnail;
		this.author = author;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", description=" + description + ", thumbnail=" + thumbnail
				+ ", author=" + author + "]";
	}
	
	
}
