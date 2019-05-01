package myShop.controller.user;

import myShop.dao.GenericDAO;
import myShop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class GetUserBasket {
    @Autowired
    GenericDAO<User> userGenericDAO;

    @RequestMapping("/getBasket")
    private ModelAndView getBasket(@RequestParam("user") Long userId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("listProductInBasket", userGenericDAO.getId(User.class, userId).getBasket().getBasketAndProductList());
        modelAndView.addObject("user", userId);
        modelAndView.setViewName("/UserBasket");
        return modelAndView;
    }
}
