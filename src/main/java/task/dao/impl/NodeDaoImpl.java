package task.dao.impl;

import org.hibernate.Hibernate;
import task.dao.api.NodeDao;
import task.entity.ConnectionUnit;
import task.entity.Node;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import java.util.List;

@Stateless
@Local(NodeDao.class)
@SuppressWarnings("uncheked")
public class NodeDaoImpl extends GenericDaoImpl<Node, Integer> implements NodeDao {

    @Override
    public List<Node> findAllWithDependencies() {
        List<Node> nodes = findAll();
        for (Node node: nodes){
            Hibernate.initialize(node.getConnectionUnits());
            for (ConnectionUnit connectionUnit: node.getConnectionUnits()){
                Hibernate.initialize(connectionUnit.getPoints());
            }
        }
        return nodes;
    }

    @Override
    public Node findNodeWithDependenciesById(int id) {
        Node node = (Node) entityManager.createQuery("SELECT n FROM Node n where n.id = :id")
                .setParameter("id", id)
                .getSingleResult();
        Hibernate.initialize(node.getConnectionUnits());
        for(ConnectionUnit connectionUnit: node.getConnectionUnits()){
            Hibernate.initialize(connectionUnit.getPoints());
        }
        return node;
    }
}
