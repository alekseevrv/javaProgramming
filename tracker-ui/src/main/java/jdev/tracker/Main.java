package jdev.tracker;

import jdev.dto.Point;

public class Main {
    public static void main(String... args) throws Exception {
        for (int i=0; i<5; i++) {
            System.out.println("Main.main say Hello!!!! ++ tracker-ui");
            Point point = new Point();
            point.setLat(45);
            System.out.println(point.toJson());
            Thread.sleep(1000);
        }
    }
}
