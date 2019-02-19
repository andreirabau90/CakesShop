package myShop.DAO.entityDAO.userDAO;

import myShop.Entity.User;

public interface UserDAO {
    User getUserId(Long id);
    void saveOrUpdate(User user);
    void delete(User user);

}
