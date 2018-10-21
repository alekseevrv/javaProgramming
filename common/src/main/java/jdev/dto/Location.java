package jdev.dto;

import com.fasterxml.jackson.core.JsonProcessingException;

public class Location {
    Point point;

    public double getLat() {
        return point.getLat();
    }

    public void setLat(double lat) {
        point.setLat(lat);
    }

    public double getLon() {
        return point.getLon();
    }

    public void setLon(double lon) {
        point.setLon(lon);
    }

    public String getAutoId() {
        return point.getAutoId();
    }

    public void setAutoId(String autoId) {
        point.setAutoId(autoId);
    }

    public String toJson() throws JsonProcessingException {
        return point.toJson();
    }

    public void setTime(long time) {
        point.setTime(time);
    }

    public long getTime() {
        return point.getTime();
    }
}
