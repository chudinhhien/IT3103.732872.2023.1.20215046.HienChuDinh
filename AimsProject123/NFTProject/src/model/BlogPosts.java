package model;

import java.sql.Date;
import java.util.List;

public class BlogPosts extends Articles {
	private String title;

	public BlogPosts(int id, String author, String content, Date timestamp, String link, String title) {
		super(id, author, content, timestamp, link);
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}