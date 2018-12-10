package jdev.dto.entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table(name="points")
public class Point {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "latitude")
    private double lat;         // широта

    @Column(name = "longitude")
    private double lon;         // долгота

    @Column(name = "autoId")
    private String autoId;      // госномер

    @Column(name = "time")
    private long time;          // текущее время

    @Column(name = "instantSpeed")
    private float instantSpeed; // мгновенная скорость

    @Column(name = "azimuth")
    private int azimuth;        // азимут

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

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

    public void setNowTime() {
        this.time = System.currentTimeMillis();
    }

    public long getTime() {
        return time;
    }

}
