package myShop.DAO.entityDAO.groupProductDAO.groupProductImpl;

import myShop.DAO.entityDAO.groupProductDAO.GroupProductDAO;
import myShop.Entity.GroupProduct;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class GroupProductDAOImpl implements GroupProductDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public GroupProduct getId(Long id) {
        return sessionFactory.getCurrentSession().get(GroupProduct.class, id);
    }

    @Override
    public void saveOrUpdate(GroupProduct groupProduct) {
        sessionFactory.getCurrentSession().saveOrUpdate(groupProduct);
    }

    @Override
    public void delete(GroupProduct groupProduct) {
        sessionFactory.getCurrentSession().delete(groupProduct);
    }

    @Override
    public List<GroupProduct> getAll(String tableBD) {
        String genericHQL = "FROM " + tableBD;
        Query query = sessionFactory.getCurrentSession().createQuery(genericHQL);
        return  query.list();
    }
}
