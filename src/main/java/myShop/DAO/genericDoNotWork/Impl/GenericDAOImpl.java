//package myShop.DAO.Impl;
//
//import myShop.DAO.GenericDAO;
//import myShop.Entity.GroupProduct;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.inject.Inject;
//import java.util.List;
//
//@Repository
//@Transactional
//public class GenericDAOImpl<T> implements GenericDAO {
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    @Override
//    public Object getId(Object o, Long id) {
//        System.out.println(o.toString());
//        return sessionFactory.getCurrentSession().get(o.getClass(),id);
//    }
//
//    @Override
//    public void saveOrUpdate(Object o) {
//        sessionFactory.getCurrentSession().saveOrUpdate(o);
//    }
//
//    @Override
//    public void delete(Object o) {
//        sessionFactory.getCurrentSession().delete(o);
//    }
//
//
//    @Override
//    public List<T> getAll(String tableBD) {
//        String genericHQL = "FROM " + tableBD;
//        Query query = sessionFactory.getCurrentSession().createQuery(genericHQL);
//        return query.list();
//    }
//
//}
