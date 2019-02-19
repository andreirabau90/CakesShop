//package myShop.DAO.Impl;
//
//import myShop.DAO.GenericDAO;
//import myShop.Entity.Product;
//import org.hibernate.SessionFactory;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.inject.Inject;
//import javax.inject.Qualifier;
//import java.util.List;
//@Controller
//@Repository
//@Transactional
//public class GenericDAOImpl<T> implements GenericDAO {
//@Bean
//public  Product product(){
//    return new Product();
//}
//
//    @Inject
////    public GenericDAOImpl(Product product) {
//        product=this.product();
//    }
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    @Override
//    public Object getUserId(Object o,Long id) {
//        GenericDAOImpl genericDAO= new GenericDAOImpl(product());
//        return  sessionFactory.getCurrentSession().get(genericDAO.getClass(),id);
//
//
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
