package com.li.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface BaseDao<T> {
    public T get(String id);
    public List<T> find(Map map);
    public void insert(T entity);
    public void update(T entity);
    public void deleteById(Serializable id);
    public void delete(Serializable[] ids);
}
