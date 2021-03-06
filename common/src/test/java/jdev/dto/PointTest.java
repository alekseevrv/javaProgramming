package jdev.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PointTest {

    private final String autoId = "o567gfd";
    private String json = "{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":1539962123782}";

    @Test // преобразование полей объекта в Json
    public void encodeDto() throws Exception {
        Point point = new Point();
        point.setLat(56);
        point.setLon(74);
        point.setAutoId(autoId);
        point.setTime(System.currentTimeMillis());
        String pointJson = point.toJson();
        assertTrue(pointJson.contains("\"lat\":56"));
        assertTrue(pointJson.contains("\"time\":"));
        System.out.println(pointJson);
    }

    @Test // преобразование Json в объект
    public void decodeDto() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Point dto = mapper.readValue(json, Point.class);
        assertEquals(autoId, dto.getAutoId());
        assertEquals(1539962123782L, dto.getTime());
        System.out.println(dto.getLat() + " " +
                dto.getLon() + " " +
                dto.getAutoId());
    }
}