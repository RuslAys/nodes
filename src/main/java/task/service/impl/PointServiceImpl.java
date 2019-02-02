package task.service.impl;

import task.entity.ConnectionUnit;
import task.entity.Node;
import task.entity.Point;
import task.service.api.NodeService;
import task.service.api.PointService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
@Local(PointService.class)
public class PointServiceImpl implements PointService {
    @Override
    public Set<Point> getPointsWithLinks(Set<ConnectionUnit> connectionUnits) {
        return connectionUnits.stream()
                .map(ConnectionUnit::getPoints)
                .flatMap(Collection::stream)
                .filter(point -> point.getConnectedPoint() != null)
                .collect(Collectors.toSet());
    }
}
