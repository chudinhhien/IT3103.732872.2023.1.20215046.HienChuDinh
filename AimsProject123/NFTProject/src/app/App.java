package app;
import java.util.ArrayList;


import java.util.ArrayList;
import java.sql.Timestamp;
//import java.security.Timestamp;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Articles;
import model.BlogPosts;
import model.Box;
import model.NFT;
import model.NFTData_Binance;
import model.NFTData_Opensea;
import model.Tweets;
import data.DatabaseReader;
import java.util.Calendar;

import java.util.Map;
import java.util.HashMap;



public class App {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
       
       
	    //hashtagSearchingFunction("#NFT");
	    //tagSearchingFunction("NFT");
		System.out.println(findHotHashTagInTweets(18,12,2023));
		System.out.println(findHotTagInBlog(20,7,2023));

	    
	    List<Tweets> res = hashtagSearchingFunction("#NFT");
	    for(Tweets tweet : res) {
	    	System.out.println(tweet.getId());
	    }
	    List<BlogPosts> res2 = tagSearchingFunction("NFT");
	    for(BlogPosts blog : res2) {
	    	System.out.println(blog.getId());
	    }

	}
	
	public static List<BlogPosts> tagSearchingFunction(String tag) throws ClassNotFoundException, SQLException {
	    Box box = new Box();
	    populateBlogPosts(DatabaseReader.getConnection(), box);
	    List<Articles> articleList = box.searchByTag(tag);
	    List<BlogPosts> res = new ArrayList<>(); 
	    for (Articles article : articleList) {
	        if (article instanceof BlogPosts) {
	            BlogPosts blogPost = (BlogPosts) article;
	            res.add(blogPost);
	            // In các thuộc tính khác của BlogPosts nếu cần
	        }
	    }
	    return res;
	}
	
	public static List<Tweets> hashtagSearchingFunction(String tag) throws ClassNotFoundException, SQLException {
	    Box box = new Box();
	    populateTweets(DatabaseReader.getConnection(), box);
	    List<Articles> articleList = box.searchByHashTag(tag);
	    List<Tweets> res = new ArrayList<>(); // Khởi tạo đối tượng res

	    for (Articles article : articleList) {
	        if (article instanceof Tweets) {
	            Tweets tweet = (Tweets) article;
	            res.add(tweet);
	            // In các thuộc tính khác của Tweets nếu cần
	        }
	    }
	    return res;
	}
	
	
	public static String findHotHashTagInTweets(int day, int month, int year) throws ClassNotFoundException, SQLException {
	    List<String> allTags = new ArrayList<>();
	    Box box = new Box();
	    populateTweets(DatabaseReader.getConnection(), box);
	    
	    // Lặp qua danh sách tweets và thu thập tất cả các tag
	    for (Articles article : box.getBox()) {
	        if (article instanceof Tweets) {
	            Tweets tweet = (Tweets) article;
	            
	            // Kiểm tra xem tweet có thuộc ngày, tháng và năm cần tìm không
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(tweet.getTimestamp());
	            
	            // Lấy ngày, tháng và năm từ timestamp của tweet
	            int tweetDay = cal.get(Calendar.DAY_OF_MONTH);
	            int tweetMonth = cal.get(Calendar.MONTH) + 1;
	            int tweetYear = cal.get(Calendar.YEAR);

	            // Kiểm tra xem tweet có thuộc ngày, tháng và năm cần tìm không
	            if (tweetDay == day && tweetMonth == month && tweetYear == year) {
	                allTags.addAll(tweet.getTag());
	            }
	        }
	    }

	    // Tính số lần xuất hiện của từng tag
	    String hotTag = findMostFrequentTag(allTags);

	    return hotTag;
	}

	public static String findHotTagInBlog(int day, int month, int year) throws ClassNotFoundException, SQLException {
	    List<String> allTags = new ArrayList<>();
	    Box box = new Box();
	    populateBlogPosts(DatabaseReader.getConnection(), box);
	    
	    // Lặp qua danh sách blogposts và thu thập tất cả các tag
	    for (Articles article : box.getBox()) {
	        if (article instanceof BlogPosts) {
	            BlogPosts blogPost = (BlogPosts) article;
	            
	            // Kiểm tra xem blogpost có thuộc ngày, tháng và năm cần tìm không
	            Calendar cal = Calendar.getInstance();
	            cal.setTime(blogPost.getTimestamp());
	            
	            // Lấy ngày, tháng và năm từ timestamp của blogpost
	            int postDay = cal.get(Calendar.DAY_OF_MONTH);
	            int postMonth = cal.get(Calendar.MONTH) + 1;
	            int postYear = cal.get(Calendar.YEAR);

	            // Kiểm tra xem blogpost có thuộc ngày, tháng và năm cần tìm không
	            if (postDay == day && postMonth == month && postYear == year) {
	                allTags.addAll(blogPost.getTag());
	            }
	        }
	    }

	    // Tính số lần xuất hiện của từng tag
	    String hotTag = findMostFrequentTag(allTags);

	    return hotTag;
	}


	
	
	public static String findMostFrequentTag(List<String> tags) {
	    if (tags == null || tags.isEmpty()) {
	        return null; // Trả về null nếu danh sách rỗng hoặc null
	    }

	    Map<String, Integer> tagCountMap = new HashMap<>();

	    // Đếm số lần xuất hiện của từng tag
	    for (String tag : tags) {
	        tagCountMap.put(tag, tagCountMap.getOrDefault(tag, 0) + 1);
	    }

	    // Tìm tag xuất hiện nhiều nhất
	    String mostFrequentTag = null;
	    int maxCount = 0;

	    for (Map.Entry<String, Integer> entry : tagCountMap.entrySet()) {
	        if (entry.getValue() > maxCount) {
	            mostFrequentTag = entry.getKey();
	            maxCount = entry.getValue();
	        }
	    }

	    return mostFrequentTag;
	}
	
	

	
	
	
	
	
	
	private static void populateTweets(Connection connection, Box box) throws SQLException {
        String query = "SELECT * FROM tweets";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("tweet_id");
            String author = resultSet.getString("userr");
        	String content = resultSet.getString("text");
        	Timestamp timestamp = resultSet.getTimestamp("date");
        	Date date = new Date(timestamp.getTime());
        	String link = resultSet.getString("urlTweet");
        	int noOfComment = resultSet.getInt("No_of_Comment");
        	int reTweet = resultSet.getInt("reTweet");
        	int idquoteTweet = resultSet.getInt("quoteTweet");
        	int noOfLike = resultSet.getInt("No_of_Likes");
        	// Tạo đối tượng Tweets từ dữ liệu đọc được
            Tweets tweet = new Tweets(id, author, content, date, link, noOfComment, reTweet, idquoteTweet, noOfLike);
        	String query_tag = "SELECT hashtag FROM hashtag WHERE tweet_id = " + id;
            PreparedStatement statement_tag = connection.prepareStatement(query_tag);
            ResultSet resultSet_tag = statement_tag.executeQuery();
            while (resultSet_tag.next()) {
            	String tag = resultSet_tag.getString("hashtag");
            	tweet.addTag(tag);
            }
            box.addToBox(tweet);
        }
        
    }
    private static void populateBlogPosts(Connection connection, Box box) throws SQLException {
        String query = "SELECT * FROM blogposts";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt("post_id");
        	String title = resultSet.getString("title");
            String author = resultSet.getString("author");
        	String link = resultSet.getString("link");
        	Timestamp timestamp = resultSet.getTimestamp("date");
        	String content = resultSet.getString("content");
        	Date date = new Date(timestamp.getTime());
        	// Tạo đối tượng Tweets từ dữ liệu đọc được
        	BlogPosts blogPost = new BlogPosts(id, author, content, date, link, title);
        	String query_tag = "SELECT tags_keywords FROM blogposttags WHERE post_id = " + id;
            PreparedStatement statement_tag = connection.prepareStatement(query_tag);
            ResultSet resultSet_tag = statement_tag.executeQuery();
            while (resultSet_tag.next()) {
            	String tag = resultSet_tag.getString("tags_keywords");
            	blogPost.addTag(tag);
            }
            box.addToBox(blogPost);
        }
    }
    
    private static void populateNFTData_Opensea(Connection connection, Box box) throws SQLException {
    	String query = "SELECT * FROM NFTData_Opensea";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int rank = resultSet.getInt("rank");
            String collection = resultSet.getString("collection");
        	String volume = resultSet.getString("volume");
        	String floorPrice = resultSet.getString("floorPrice");
        	Timestamp timestamp = resultSet.getTimestamp("date");
        	Date date = new Date(timestamp.getTime());
        	String percentChange = resultSet.getString("percentChange");
        	int sales = resultSet.getInt("sales");
        	// Tạo đối tượng Tweets từ dữ liệu đọc được
        	NFTData_Opensea nftDataOpensea = new NFTData_Opensea(rank, collection, volume, floorPrice, date, percentChange, sales);
            box.addMoney(nftDataOpensea);
        }
    }
    
    private static void populateNFTData_Binance(Connection connection, Box box) throws SQLException {
    	String query = "SELECT * FROM NFTData_Binance";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int rank = resultSet.getInt("rank");
            String collection = resultSet.getString("collection");
        	String volume = resultSet.getString("volume");
        	String floorPrice = resultSet.getString("floorPrice");
        	Timestamp timestamp = resultSet.getTimestamp("date");
        	Date date = new Date(timestamp.getTime());
        	int owners = resultSet.getInt("owners");
        	int items = resultSet.getInt("items");
        	// Tạo đối tượng Tweets từ dữ liệu đọc được
        	NFTData_Binance nftDataBinance = new NFTData_Binance(rank, collection, volume, floorPrice, date, owners, items);
            box.addMoney(nftDataBinance);
        }
    }

}
