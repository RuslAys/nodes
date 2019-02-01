package task.dao.impl;

import task.dao.api.PointDao;
import task.entity.Point;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Local(PointDao.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class PointDaoImpl extends GenericDaoImpl<Point, Integer> implements PointDao {

}
