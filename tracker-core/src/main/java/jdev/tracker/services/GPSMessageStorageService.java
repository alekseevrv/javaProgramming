package jdev.tracker.services;

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

    // положить Точку в очередь
    void put(Point point) throws InterruptedException {
        queue.put(point);
    }

    // извлечь Точку из очереди
    Point take() throws InterruptedException {
        return queue.take();
    }

    // возвращаем очередь, для определения пустая она или нет
    BlockingDeque<Point> getQueue() {
        return queue;
    }

}
