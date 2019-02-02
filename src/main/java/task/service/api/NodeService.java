package task.service.api;

import task.entity.Node;

import java.util.List;

public interface NodeService {
    int getAllPointsNumber(Node node);
    int getEmptyPointsNumber(Node node);
    Node findWithDependenciesById(int id);
    List<Node> findAll();
    List<Node> findAllWithDependencies();
    void add(Node node);
}
