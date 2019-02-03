package task.service.api;

import task.entity.Node;

import java.util.List;

/**
 * Service to work with nodes
 */
public interface NodeService {
    /**
     * Method to get all points on node
     * @param node node to search
     * @return number of all points
     */
    int getAllPointsNumber(Node node);

    /**
     * Method to get empty points on node
     * @param node node to search
     * @return number of empty points
     */
    int getEmptyPointsNumber(Node node);

    /**
     * Find node with all dependencies by id
     * @param id node`s id
     * @return node with all dependencies
     */
    Node findWithDependenciesById(int id);

    /**
     * Find all nodes with all dependencies by id
     * @return list of nodes with all dependencies
     */
    List<Node> findAllWithDependencies();

    /**
     * Method to add node to db
     * @param node node to add
     */
    void add(Node node);
}
