package jdev.server.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import jdev.dto.Point;

/*
Сервис GPS. Эмулирует работу GPS.
Генерирует значения широты, долготы, азимута и мгновенной скорости.
Сгенерированные данные записываются в очередь сервиса хранения сообщений
 */
@Service
public class GPSService {

    @Autowired
    private GPSMessageStorageService gpsMessageStorageService;

    private double gpsLat = 1; // широта
    private double gpsLon = 2; // долгота

    @Scheduled(cron = "${cron_gps_service.prop}")
    private void GPSCoordinates() throws InterruptedException {

        Point point = new Point();
        point.setLat(gpsLat);
        point.setLon(gpsLon);
        point.setAutoId("o567gfd");
        point.setTime(System.currentTimeMillis());
        point.setInstantSpeed(40);
        point.setAzimuth(30);

        gpsLat = gpsLat + 0.5;
        gpsLon = gpsLon + 1.5;

        gpsMessageStorageService.put(point);

    }

}
