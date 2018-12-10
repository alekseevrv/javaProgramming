package jdev.tracker.services;

import jdev.dto.entity.Point;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackerPointRepository extends CrudRepository<Point, Integer> {
}
