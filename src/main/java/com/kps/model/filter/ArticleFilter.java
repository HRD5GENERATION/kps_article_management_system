package com.kps.model.filter;

public class ArticleFilter {
	
	private Integer categoryId;
	private String title;
	public Integer getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return "ArticleFilter [categoryId=" + categoryId + ", title=" + title + "]";
	}
}
