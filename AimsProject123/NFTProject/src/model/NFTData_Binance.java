package model;

import java.sql.Date;

public class NFTData_Binance extends NFT {
	private int owners;
	private int items;

	public NFTData_Binance(int rank, String collection, String volume, String floorPrice, Date date, int owners,
			int items) {
		super(rank, collection, volume, floorPrice, date);
		this.owners = owners;
		this.items = items;
	}

}
