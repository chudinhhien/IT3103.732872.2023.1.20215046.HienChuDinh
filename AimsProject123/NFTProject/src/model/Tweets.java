package model;

import java.security.Timestamp;
import java.sql.Date;

public class Tweets extends Articles {
	private int noOfComment;
	private int reTweet;
	private int quoteTweet;
	private int noOfLike;

	public Tweets(int id, String author, String content, Date timestamp, String link, int noOfComment, int reTweet,
			int quoteTweet, int noOfLike) {
		super(id, author, content, timestamp, link);
		this.noOfComment = noOfComment;
		this.reTweet = reTweet;
		this.quoteTweet = quoteTweet;
		this.noOfLike = noOfLike;
	}

	public int getNoOfComment() {
		return noOfComment;
	}

	public void setNoOfComment(int noOfComment) {
		this.noOfComment = noOfComment;
	}

	public int getReTweet() {
		return reTweet;
	}

	public void setReTweet(int reTweet) {
		this.reTweet = reTweet;
	}

	public int getQuoteTweet() {
		return quoteTweet;
	}

	public void setQuoteTweet(int quoteTweet) {
		this.quoteTweet = quoteTweet;
	}

	public int getNoOfLike() {
		return noOfLike;
	}

	public void setNoOfLike(int noOfLike) {
		this.noOfLike = noOfLike;
	}

	
	
}
