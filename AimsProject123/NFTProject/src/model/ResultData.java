package model;

import java.util.Date;
import java.util.List;

public class ResultData {
    private final List<java.sql.Date> x;
    private final List<Float> volumeAsFloat;

    public ResultData(List<java.sql.Date> x2, List<Float> volumeAsFloat) {
        this.x = x2;
        this.volumeAsFloat = volumeAsFloat;
    }

    public List<java.sql.Date> getX() {
        return x;
    }

    public List<Float> getY() {
        return volumeAsFloat;
    }
}