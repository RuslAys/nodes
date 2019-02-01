package task.dao.impl;

import task.dao.api.GenericDao;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Stateless
@Local(GenericDao.class)
@TransactionAttribute(TransactionAttributeType.REQUIRED)
@SuppressWarnings("unchecked")
public abstract class GenericDaoImpl<E, K> implements GenericDao<E, K> {

    protected Class<E> daoType;

    @PersistenceContext(unitName = "pUnit")
    protected EntityManager entityManager;

    public GenericDaoImpl(){
        ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
        this.daoType = (Class) genericSuperclass.getActualTypeArguments()[0];
//        Type t = getClass().getGenericSuperclass();
//        ParameterizedType pt = (ParameterizedType) t;
//        this.daoType = (Class) pt.getActualTypeArguments()[0];
    }

    public final void setDaoType(Class<E> daoType){
        this.daoType = daoType;
    }

    @Override
    public void add(E entity) {
        entityManager.persist(entity);
    }

    @Override
    public void update(E entity) {
        entityManager.merge(entity);
    }

    @Override
    public void remove(E entity) {
        entityManager.remove(entity);
    }

    @Override
    public E find(K key) {
        return entityManager.find(daoType, key);
    }

    @Override
    public List<E> findAll() {
        return (List<E>) entityManager.createQuery("SELECT e FROM " + daoType.getName()
                + " e").getResultList();
    }
}
