package model;

import java.sql.Date;

public class NFTData_Opensea extends NFT {
	private String percentChange;
	private int sales;

	public NFTData_Opensea(int rank, String collection, String volume, String floorPrice, Date date,
			String percentChange, int sales) {
		super(rank, collection, volume, floorPrice, date);
		this.percentChange = percentChange;
		this.sales = sales;
	}

}
