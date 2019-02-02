package task.controller;

import task.entity.Node;
import task.entity.Point;
import task.service.api.NodeService;
import task.service.api.PointService;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import java.io.Serializable;
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

    public Set<Point> getPointsWithLinks(){
        return pointService.getPointsWithLinks(this.node.getConnectionUnits());
    }
}
