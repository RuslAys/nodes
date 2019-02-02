package task.dao.api;

import task.entity.Node;

import java.util.List;

/**
 * Interface for node data access object
 */
public interface NodeDao extends GenericDao<Node, Integer>{
    /**
     * Find all nodes with connection units
     * @return list with nodes
     */
    List<Node> findAllWithDependencies();
}
