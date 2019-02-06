package myShop.DAO.entityDAO.groupProductDAO;

import myShop.Entity.GroupProduct;

import java.util.List;

public interface GroupProductDAO {
    GroupProduct getId(Long id);

    void saveOrUpdate(GroupProduct groupProduct);

    void delete(GroupProduct groupProduct);

    List<GroupProduct> getAll(String string);


}
