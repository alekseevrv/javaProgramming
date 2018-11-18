package jdev.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Point {

    private double lat;         // широта
    private double lon;         // долгота
    private String autoId;      // госномер
    private long time;          // текущее время
    private float instantSpeed; // мгновенная скорость
    private int azimuth;        // азимут

    public float getInstantSpeed() {
        return instantSpeed;
    }

    public void setInstantSpeed(float instantSpeed) {
        this.instantSpeed = instantSpeed;
    }

    public int getAzimuth() {
        return azimuth;
    }

    public void setAzimuth(int azimuth) {
        this.azimuth = azimuth;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public String getAutoId() {
        return autoId;
    }

    public void setAutoId(String autoId) {
        this.autoId = autoId;
    }

    public String toJson() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(this);
    }

    @Override
    public String toString() {
        return "Point{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", autoId='" + autoId + '\'' +
                '}';
    }


    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }

}
