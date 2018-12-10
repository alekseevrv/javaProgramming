package jdev.tracker.services;

import jdev.dto.entity.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/*
Сервис отправки сообщений.
Получение накопленных данных из сервиса хранения сообщений
и вывод их с помощью логгирования на дисплей.
 */
@Service
public class GPSMessagingService {

    @Autowired
    private GPSMessageStorageService gpsMessageStorageService;

    private RestTemplate restTemplate = new RestTemplate();

    private static final Logger log = LoggerFactory.getLogger(GPSMessagingService.class);

    @Scheduled(cron = "${cron_messaging_service.prop}")
    private void GPSMessaging() throws InterruptedException {
        Point point; // передаваемая на сервер точка

        while (!gpsMessageStorageService.getQueue().isEmpty()) {
            // взятие точки из очереди
            point = gpsMessageStorageService.take();

            // отправка точки на сервер
            // response - ответ сервера
            HttpEntity<Point> sendEntity = new HttpEntity<>(point, getHeaders());
            ResponseEntity<String> response = restTemplate.postForEntity(
                    "http://127.0.0.1:8080/coordinates",
                    sendEntity,
                    String.class
            );

            // вывод ответа сервера
            log.info(response.getBody());
        }

    }

    // формирование заголовка при отправке данных методом POST
    private static HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }

}
