package task.controller;

import task.entity.Node;
import task.service.api.NodeService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class NodeController implements Serializable {

    @Inject
    private NodeService nodeService;

    public List<Node> getNodes(){
        return nodeService.findAllWithDependencies();
    }

    public int getAllPointsNumber(Node node){
        return nodeService.getAllPointsNumber(node);
    }

    public int getEmptyPointsNumber(Node node){
        return nodeService.getEmptyPointsNumber(node);
    }
}
