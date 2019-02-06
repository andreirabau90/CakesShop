package myShop.DAO.entityDAO.productDAO;

import myShop.Entity.Product;

import java.util.List;

public interface ProductDAO {
    Product getId(Long id);

    void saveOrUpdate(Product product);

    void delete(Product product);

    List<Product> getAll(String string);


}
