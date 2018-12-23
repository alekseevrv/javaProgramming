package jdev.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.Point;
import jdev.dto.RequestRoute;
import jdev.dto.repo.PointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

@RestController
public class OutputCoordinatesController {

    private static final Logger log = LoggerFactory.getLogger(OutputCoordinatesController.class);

    @Autowired
    private PointRepository pointRepository;

    @RequestMapping(value = "/coordinates", method = RequestMethod.POST)
    public String setCoords(@RequestBody Point point) throws JsonProcessingException {

        try {
            // запись точки в базу данных
            pointRepository.save(point);
        } catch (NullPointerException e) {
            log.info(e.getMessage());
        }

        // вывод точки в лог
        log.info(point.toJson());

        return point.toJson();

    }

    @RequestMapping(value = "/getpoints", method = RequestMethod.GET)
    public ResponseEntity<Point[]> getTrack(@RequestBody RequestRoute requestRoute) {

        String autoId = requestRoute.getAutoId();
        Integer maxPoints = requestRoute.getScope();

        log.info("Query for:");
        log.info("autoId=" + autoId + " maxPoints=" + maxPoints.toString());

        Point[] points = new Point[maxPoints];
        HttpHeaders headers = new HttpHeaders();
        headers.add("accept", MediaType.APPLICATION_JSON_UTF8_VALUE);

        ArrayList<Point> track = new ArrayList<>();
        track = (ArrayList<Point>) pointRepository.findAllByAutoIdOrderByTimeDesc(autoId);

        System.out.print(track.size());

        if (track.size() > 0) {
            for(int i=0; i<track.size() && i<maxPoints; i++) {
                points[i] = track.get(i);
            }

            return new ResponseEntity<>(points, headers, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(points, headers, HttpStatus.NOT_FOUND);
        }
    }
}
