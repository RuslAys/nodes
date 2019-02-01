package task.controller;

import task.dao.api.NodeDao;
import task.entity.Node;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class NodeController implements Serializable {

    @Inject
    private NodeDao nodeDao;

    public List<Node> getNodes(){
        return nodeDao.findAll();
    }
}
