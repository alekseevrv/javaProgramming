package jdev.server.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.Point;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
public class OutputCoordinatesController {

    private static final Logger log = LoggerFactory.getLogger(OutputCoordinatesController.class);

    @RequestMapping(value = "/coordinates", method = RequestMethod.POST)
    public String setCoords(@RequestBody Point point) throws JsonProcessingException {

        log.info(point.toJson());

        return "ok";

    }

}
