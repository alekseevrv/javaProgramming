package jdev.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.Point;
import org.junit.Test;
import static org.junit.Assert.*;

public class OutputCoordinatesControllerTest {

    @Test
    public void setCoords() throws JsonProcessingException {

        String rezult;
        Point point = new Point();
        point.setAzimuth(15);
        point.setInstantSpeed(60);
        point.setAutoId("efwefwe");
        point.setLon(15.3);
        point.setLat(48.3);


        OutputCoordinatesController OCC = new OutputCoordinatesController();
        rezult = OCC.setCoords(point);

        assertEquals(point.toJson(),rezult);

    }
}
