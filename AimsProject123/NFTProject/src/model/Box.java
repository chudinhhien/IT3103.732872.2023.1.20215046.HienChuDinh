package model;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Box {
    public List<Articles> box = new ArrayList<Articles>();
	private List<NFT> money = new ArrayList<NFT>();
    public Box() {
    }

    public void addToBox(Articles article) {
        box.add(article);
    }
    
    public void addMoney(NFT nft) {
		money.add(nft);
	}
    
    

    public List<NFT> getMoney() {
		return money;
	}

	public void setMoney(List<NFT> money) {
		this.money = money;
	}

	public List<Articles> getBox() {
		return box;
	}

	public void setBox(List<Articles> box) {
		this.box = box;
	}

	public List<Articles> searchByHashTag(String tag) {
        List<Articles> articlesWithTag = new ArrayList<>();

        for (Articles article : box) {
            if (article instanceof Tweets) {
                Tweets tweet = (Tweets) article;
                if (tweet.getTag().contains(tag)) {
                    articlesWithTag.add(tweet);
                }
            }
        }
        return articlesWithTag;
    }
    
    public List<Articles> searchByTag(String tag) {
        List<Articles> articlesWithTag = new ArrayList<>();

        for (Articles article : box) {
            if (article instanceof BlogPosts) {
                BlogPosts blogPost = (BlogPosts) article;
                if (blogPost.getTag().contains(tag)) {
                    articlesWithTag.add(blogPost);
                }
            }
        }
        return articlesWithTag;
    }

   
}




