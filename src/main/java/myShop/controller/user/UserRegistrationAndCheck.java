package myShop.controller.user;

import myShop.dao.GenericDAO;
import myShop.entity.User;
import myShop.repository.UserConnectionBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UserRegistrationAndCheck {
    @Autowired
    private GenericDAO<User> userDAOImpl;
    @Autowired
    UserConnectionBD userConnectionBD;

    @RequestMapping("/getUser")
    public void getUser(@RequestParam("idUser") Long id) {
        userDAOImpl.getId(User.class, id);
    }

    public void deleteUser(@RequestParam("id") Long id) {
        User user = userDAOImpl.getId(User.class, id);
        userDAOImpl.delete(user);
    }

    @RequestMapping("enter")
    public ModelAndView enterUser(@RequestParam("name") String name,
                                  @RequestParam("pass") String pass,
                                  @RequestParam(value = "email", defaultValue = "null") String email) {
        User user;
        String error;
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:getGroupProducts");
        if (userConnectionBD.existUser(name, pass) && email.equals("null")) {
            user = userConnectionBD.getUserId(name);
            modelAndView.addObject("user", user.getUserId());
            return modelAndView;
        }
        if (userConnectionBD.existName(name)) {
            error = "user with this name exist";
        } else if (userConnectionBD.existEmail(email)) {
            error = "user with this email exist";
        } else {
            user = new User();
            user.setUserName(name);
            user.setPass(pass);
            user.setEmail(email);
            userDAOImpl.saveOrUpdate(user);
            error = "user successfully registered ";
        }

        modelAndView.addObject("error", error);
        return modelAndView;
    }
}
