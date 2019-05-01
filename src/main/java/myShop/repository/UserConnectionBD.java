package myShop.repository;

import myShop.entity.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserConnectionBD {

    @Autowired
    SessionFactory sessionFactory;


    public boolean existUser(String name, String pass) {
        String HQL = "FROM User WHERE( userName = :name and pass = :pass)";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        query.setParameter("name", name);
        query.setParameter("pass", pass);
        System.out.println(query.getParameter("name"));
        return query.list().size() > 0;
    }

    public boolean existEmail(String email) {
        String HQL = "FROM User WHERE( email= :email) ";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        query.setParameter("email", email);
        List list = query.list();
        return list.size() > 0;
    }

    public boolean existName(String name) {
        String HQL = "FROM User Where( userName=: name)";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        query.setParameter("name", name);
        List list = query.list();
        return list.size() > 0;
    }

    public Long getUserId(String name) {
        String HQL = "FROM User Where( userName=: name)";
        Query query = sessionFactory.getCurrentSession().createQuery(HQL);
        query.setParameter("name", name);

        return ((User) query.getSingleResult()).getUserId();
    }

}
