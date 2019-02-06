package myShop.DAO.entityDAO.productDAO.productImpl;

import myShop.DAO.entityDAO.productDAO.ProductDAO;
import myShop.Entity.Product;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Product getId(Long id) {
        System.out.println(sessionFactory.getCurrentSession().get(Product.class, id));
        return sessionFactory.getCurrentSession().get(Product.class, id);
    }

    @Override
    public void saveOrUpdate(Product product) {
        sessionFactory.getCurrentSession().saveOrUpdate(product);
    }

    @Override
    public void delete(Product product) {
        sessionFactory.getCurrentSession().delete(product);
    }

    @Override
    public List<Product> getAll(String tableProductBD) {
        String s = "FROM " + tableProductBD;
        org.hibernate.query.Query query = sessionFactory.getCurrentSession().createQuery(s);
        return query.list();
    }
}
