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

@ManagedBean(name = "nodeController")
@SessionScoped
public class NodeController implements Serializable {

    @Inject
    private NodeService nodeService;

    @Inject
    private PointService pointService;

    private int nodeId;
    private Node node;
    private Set<Point> points;

    public List<Node> getNodes(){
        return nodeService.findAllWithDependencies();
    }

    public int getAllPointsNumber(Node node){
        return nodeService.getAllPointsNumber(node);
    }

    public int getEmptyPointsNumber(Node node){
        return nodeService.getEmptyPointsNumber(node);
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setNodeId(int nodeId) {
        this.nodeId = nodeId;
    }

    public Node getNode() {
        return node;
    }

    public void setNode(Node node) {
        this.node = node;
    }

    public void loadNodeWithFullInformation(){
        this.node = nodeService.findWithDependenciesById(this.nodeId);
    }

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
