package task.service.api;

import task.entity.ConnectionUnit;
import task.entity.Point;

import java.util.Set;

/**
 * Service to work with points
 */
public interface PointService {
    /**
     * Method to get point with links on connection units
     * @param connectionUnits set with connection units
     * @return set with points with links
     */
    Set<Point> getPointsWithLinks(Set<ConnectionUnit> connectionUnits);
}
