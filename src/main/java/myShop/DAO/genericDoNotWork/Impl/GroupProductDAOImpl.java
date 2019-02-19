//package myShop.DAO.Impl;
//
//import myShop.DAO.GenericDAO;
//import myShop.Entity.GroupProduct;
//import myShop.Entity.Product;
//import org.hibernate.SessionFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import javax.inject.Inject;
//import java.util.List;
//
//public class GroupProductDAOImpl implements GenericDAO {
//
//    @Autowired
//    SessionFactory sessionFactory;
//
//    @Override
//    public Object getUserId( Long id) {
//        return sessionFactory.getCurrentSession().get(GroupProduct.class,id);
//    }
//
//    @Override
//    public void saveOrUpdate(Object o) {
//sessionFactory.getCurrentSession().saveOrUpdate(o);
//    }
//
//    @Override
//    public void delete(Object o) {
//
//    }
//
//    @Override
//    public List getAll(String string) {
//        return null;
//    }
//}
