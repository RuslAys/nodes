package task.dao.api;

import java.util.List;

/**
 * Interface for generic data access object
 * @param <E> entity
 * @param <K> entity`s key
 */
public interface GenericDao <E, K> {

    /**
     * Method for add entity to data base
     * @param entity Generic entity
     */
    void add(E entity);

    /**
     * Method for update entity in data base
     * @param entity Generic entity
     */
    void update(E entity);

    /**
     * Method for remove entity from data base
     * @param entity Generic entity
     */
    void remove(E entity);

    /**
     * Method for search entity in data base
     * @param key Generic key
     * @return Generic entity
     */
    E find(K key);

    /**
     * Method for search all generic entities in data base
     * @return List with generic entities
     */
    List<E> findAll();
}
