package jdev.server.services;

import jdev.dto.Point;
import org.springframework.stereotype.Service;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

/*
Сервис хранения сообщений.
Предоставляет доступ к записи в очередь и чтения из нее сообщений.
Чтение происходит в режиме блокировки.
 */
@Service
public class GPSMessageStorageService {

    private BlockingDeque<Point> queue =  new LinkedBlockingDeque<>(100);

    void put(Point point) throws InterruptedException {
        queue.put(point);
    }

    Point take() throws InterruptedException {
        return queue.take();
    }

    Integer sizeQueue() {
        return queue.size();
    }

}
