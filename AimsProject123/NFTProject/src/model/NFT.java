package model;

import java.sql.Date;

public class NFT {
    private int rank;
    private String collection;
    private String volume;
    private String floorPrice;
    private Date date;

    public NFT(int rank, String collection, String volume, String floorPrice, Date date) {
        this.rank = rank;
        this.collection = collection;
        this.volume = volume;
        this.floorPrice = floorPrice;
        this.date = date;
    }

    public int getRank() {
        return rank;
    }

    public String getCollection() {
        return collection;
    }

    public String getVolume() {
        return volume;
    }

    public String getFloorPrice() {
        return floorPrice;
    }

    public Date getDate() {
        return date;
    }
}
