package br.com.clubprivate.daos.impl;

import br.com.clubprivate.daos.DAO;
import br.com.clubprivate.models.AbstractModel;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;
import java.util.List;

@Repository
@Transactional("transactionManager")
public abstract class DAOImpl<T extends AbstractModel, ID> implements DAO<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public DAOImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public Class<T> getPersistentClass() {
        return persistentClass;
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void remove(ID id) {
        Object o = find(id);
        entityManager.remove(o);
    }

    public void refresh(T entity) {
        entityManager.refresh(entity);
    }

    @Transactional
    public T find(ID id) {
        return entityManager.find(persistentClass, id);
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return entityManager.createQuery("Select x from " + persistentClass.getSimpleName() + " x ").getResultList();
    }
}
