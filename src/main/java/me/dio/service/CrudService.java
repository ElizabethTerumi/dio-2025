package me.dio.service;

import java.util.List;
import java.util.Map;

public interface CrudService<ID, T> {
    List<T> findAll();
    T findById(ID id);
    T create(T entity);
    T update(ID id, T entity);
    T patch(ID id, Map<String, Object> updates);
    void delete(ID id);
}
