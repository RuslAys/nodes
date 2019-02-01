package task.dao.impl;

import task.dao.api.NodeDao;
import task.entity.Node;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Local(NodeDao.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class NodeDaoImpl extends GenericDaoImpl<Node, Integer> implements NodeDao {

}
