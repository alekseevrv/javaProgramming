package jdev.tracker;

import com.fasterxml.jackson.core.JsonProcessingException;
import jdev.dto.Point;

public class Main {
    public static void main(String... args) throws Exception {
        for (int i=0; i<5; i++) {
            extractedMethod(45);
        }
    }

    private static void extractedMethod(int lat) throws JsonProcessingException, InterruptedException {
        System.out.println("Main.main say Hello!!!!");
        Point point = new Point();
        point.setLat(lat);
        System.out.println(point.toJson());
        Thread.sleep(1000);
    }
}
