package model;

import java.sql.Date;

public class NFT {
	private int rank;
	private String collection;
	private String volume;
	private String floorPrice;
	private Date date;

	public NFT(int rank, String collection, String volume, String floorPrice, Date date) {
		super();
		this.rank = rank;
		this.collection = collection;
		this.volume = volume;
		this.floorPrice = floorPrice;
		this.date = date;
	}

}
