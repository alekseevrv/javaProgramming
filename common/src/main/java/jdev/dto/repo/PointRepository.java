package jdev.dto.repo;

import jdev.dto.Point;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PointRepository extends CrudRepository<Point, Integer> {

    List<Point> findAllByAutoIdOrderByTimeDesc(String autoId);

}
