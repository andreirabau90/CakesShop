package myShop.dao.impl;

import myShop.dao.GenericDAO;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class GenericDAOImpl<T> implements GenericDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Object getId(Class type, Long id) {
        return sessionFactory.getCurrentSession().get(type, id);
    }

    @Override
    public void saveOrUpdate(Object o) {
        sessionFactory.getCurrentSession().saveOrUpdate(o);
    }

    @Override
    public void delete(Object o) {
        sessionFactory.getCurrentSession().delete(o);
    }


    @Override
    public List<T> getAll(String tableBD) {
        String genericHQL = "FROM " + tableBD;
        Query query = sessionFactory.getCurrentSession().createQuery(genericHQL);
        return query.list();
    }

}
