package task.controller;

import task.entity.Node;
import task.entity.Point;
import task.service.api.NodeService;
import task.service.api.PointService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Bean to work with nodes
 */
@ManagedBean(name = "nodeController")
@SessionScoped
public class NodeController implements Serializable {

    @Inject
    private NodeService nodeService;

    @Inject
    private PointService pointService;

    /** Node id to find node */
    private int nodeId;
    /** Node to show info about */
    private Node node;
    /** Points with links*/
    private Set<Point> points;

    /**
     * Method to get nodes with dependencies
     * @return list with nodes
     */
    public List<Node> getNodes(){
        return nodeService.findAllWithDependencies();
    }

    /**
     * Method to get all points number on node
     * @param node node to calculate
     * @return number of points on node
     */
    public int getAllPointsNumber(Node node){
        return nodeService.getAllPointsNumber(node);
    }

    /**
     * Method to get empty points on node
     * @param node node to calculate
     * @return number of empty points on node
     */
    public int getEmptyPointsNumber(Node node){
        return nodeService.getEmptyPointsNumber(node);
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        if (this.nodeId != nodeId){
            this.points = null;
        }
        this.nodeId = nodeId;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    /**
     * Load node with all dependencies
     */
    public void loadNodeWithFullInformation(){
        this.node = nodeService.findWithDependenciesById(this.nodeId);
    }

    /**
     * Load points with links
     */
    public void loadPointsWithLinks(){
        this.points = pointService.getPointsWithLinks(this.node.getConnectionUnits());
    }

    public Set<Point> getPointsWithLinks(){
        if (points == null){
            return new HashSet<>();
        }
        return this.points;
    }
}
