package myShop.controller.user;

import myShop.dao.GenericDAO;
import myShop.entity.Basket;
import myShop.entity.User;
import myShop.repository.UserConnectionBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Registration {
    @Autowired
    UserConnectionBD userConnectionBD;
    @Autowired
    private GenericDAO<User> genericDAO;
    @Autowired
    private GenericDAO<Basket> basketGenericDAO;

    private boolean CheckUser(String name, String email) {
        return !userConnectionBD.existName(name) && !userConnectionBD.existEmail(email);
    }

    @RequestMapping("/registration")
    private ModelAndView Registration(@RequestParam("name") String name,
                                      @RequestParam("email") String email,
                                      @RequestParam("pass") String pass) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        if (CheckUser(name, email)) {
            Basket basket = new Basket();
            basketGenericDAO.saveOrUpdate(basket);
            User user = new User(name, pass, email, basket);
            genericDAO.saveOrUpdate(user);
            modelAndView.addObject("error", "user user successfully registered");
        } else {
            modelAndView.addObject("error", "user with this name or email exist");
        }
        return modelAndView;
    }

}
