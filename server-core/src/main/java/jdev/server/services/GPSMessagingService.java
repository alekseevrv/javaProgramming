package jdev.server.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
Сервис отправки сообщений.
Получение накопленных данных из сервиса хранения сообщений
и вывод их с помощью логгирования на дисплей.
 */
@Service
public class GPSMessagingService {

    private static final Logger log = LoggerFactory.getLogger(GPSMessagingService.class);

    @Autowired
    private GPSMessageStorageService gpsMessageStorageService;

    @Scheduled(cron = "${cron_messaging_service.prop}")
    private void GPSMessaging() throws JsonProcessingException, InterruptedException {

        for (int count = 0; count <= gpsMessageStorageService.sizeQueue(); count++) {
            log.info(gpsMessageStorageService.take().toJson());
        }

    }

}
