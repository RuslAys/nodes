package task.service.impl;

import task.dao.api.NodeDao;
import task.entity.ConnectionUnit;
import task.entity.Node;
import task.service.api.NodeService;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Stateless
@Local(NodeService.class)
public class NodeServiceImpl implements NodeService {

    @Inject
    private NodeDao nodeDao;

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public List<Node> findAll() {
        return nodeDao.findAll();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public List<Node> findAllWithDependencies() {
        return nodeDao.findAllWithDependencies();
    }

    @Override
    @Transactional(Transactional.TxType.REQUIRED)
    public void add(Node node) {
        nodeDao.add(node);
    }

    @Override
    public int getAllPointsNumber(Node node) {
        return node.getConnectionUnits().stream()
                .map(ConnectionUnit::getPoints)
                .mapToInt(Set::size)
                .sum();
    }

    @Override
    public int getEmptyPointsNumber(Node node) {
        return node.getConnectionUnits().stream()
                .map(ConnectionUnit::getPoints)
                .map(points -> points
                        .stream()
                        .filter(point -> point.getConnectedPoint() == null)
                        .collect(Collectors.toSet()))
                .mapToInt(Set::size)
                .sum();
    }
}
