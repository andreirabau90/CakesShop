package myShop.dao;


import java.util.List;

public interface GenericDAO<T> {
    T getId(final Class<T> type, Long id);

    void saveOrUpdate(T t);

    void delete(T t);

    List<T> getAll(String string);


}
