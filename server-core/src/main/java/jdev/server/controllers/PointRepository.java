package jdev.server.controllers;

import jdev.dto.entity.Point;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PointRepository extends CrudRepository<Point, Integer> {

    @Cacheable(value = "points")
    List<Point> findAllByAutoIdOrderByTimeDesc(String autoId);

}
