package task.dao.impl;

import task.dao.api.LinkDao;
import task.entity.Link;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Local(LinkDao.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class LinkDaoImpl extends GenericDaoImpl<Link, Integer> implements LinkDao {
}
