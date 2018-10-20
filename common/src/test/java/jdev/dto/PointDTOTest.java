package jdev.dto;


import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PointDTOTest {

    private String expected = "{\"lat\":56.0,\"lon\":74.0,\"autoId\":\"o567gfd\",\"time\":1539962123782}";
    private String autoId = "o567gfd";

    @Test // преобразование полей объекта в Json
    public void toJson() throws Exception {
        PointDTO point = new PointDTO();
        point.setLat(56);
        point.setLon(74);
        point.setAutoId("o567gfd");
        point.setTime(System.currentTimeMillis());
        assertTrue(point.toJson().contains("\"lat\":56"));
        assertTrue(point.toJson().contains("\"time\":"));
        System.out.println(point.toJson());
    }

    @Test // преобразование Json в объект
    public void decodeDto() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        PointDTO dto = mapper.readValue(expected, PointDTO.class);
        assertEquals(autoId, dto.getAutoId());
        assertEquals(1539962123782L, dto.getTime());
        System.out.println(dto.getLat() + " " +
                dto.getLon() + " " +
                dto.getAutoId());
    }
}