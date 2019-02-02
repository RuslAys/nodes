package task.service.api;

import task.entity.ConnectionUnit;
import task.entity.Node;
import task.entity.Point;

import java.util.Set;

public interface PointService {
    Set<Point> getPointsWithLinks(Set<ConnectionUnit> connectionUnits);
}
