package model;

import java.sql.Date;
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
    
    public List<Articles> searchByAuthor(String author) {
        List<Articles> articlesByAuthor = new ArrayList<>();

        for (Articles article : box) {
            if (article instanceof Tweets) {
                Tweets tweet = (Tweets) article;
                if (tweet.getAuthor().equals(author)) {
                    articlesByAuthor.add(tweet);
                }
            }
        }
        return articlesByAuthor;
    }
    
    public void searchNFTsByCollectionAndDate(String collection, Date searchDate, List<Date> x, List<String> y) {
        for (NFT nft : money) {
            if (nft instanceof NFTData_Opensea || nft instanceof NFTData_Binance) {
                if (nft.getCollection().equals(collection) && nft.getDate().after(searchDate)) {
                    x.add(nft.getDate());
                    y.add(nft instanceof NFTData_Opensea ?
                            ((NFTData_Opensea) nft).getVolume() :
                            ((NFTData_Binance) nft).getVolume());
                }
            }
        }
    }
    
    public <T extends NFT> List<T> getMoneyOfType(Class<T> type) {
        List<T> result = new ArrayList<>();
        for (NFT nft : money) {
            if (type.isInstance(nft)) {
                result.add(type.cast(nft));
            }
        }
        return result;
    }



   
}




