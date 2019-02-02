package task.dao.impl;

import task.dao.api.ConnectionUnitDao;
import task.entity.ConnectionUnit;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

@Stateless
@Local(ConnectionUnitDao.class)
public class ConnectionUnitDaoImpl extends GenericDaoImpl<ConnectionUnit, Integer> implements ConnectionUnitDao {
}
