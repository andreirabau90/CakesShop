package myShop.controller;

import myShop.DAO.entityDAO.userDAO.UserDAO;
import myShop.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ControllerUser {
    @Autowired
    private UserDAO userDAOImpl;

    @RequestMapping("/getUser")
    public void getUser(@RequestParam("idUser") Long id) {
        userDAOImpl.getUserId(id);
    }


    @RequestMapping("/addMyUser")
    public void addUser(@ModelAttribute("name") String name, @RequestParam("pass") String pass, @RequestParam("email") String email
    ) {
        User user = new User();
        user.setUserName(name);
        user.setPass(pass);
        user.setEmail(email);
        userDAOImpl.saveOrUpdate(user);

    }

    @RequestMapping("/deleteUser")
    public void deleteUser(@RequestParam("id") Long id) {
        User user = userDAOImpl.getUserId(id);
        userDAOImpl.delete(user);

    }
}
