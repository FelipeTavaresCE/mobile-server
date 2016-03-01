package br.com.clubprivate.daos;

import java.util.List;

public interface DAO<T, ID> {

    public void create(T entity);

    public void update(T entity);

    public void remove(ID id);

    public void refresh(T entity);

    T find(ID id);

    public List<T> findAll();

}
