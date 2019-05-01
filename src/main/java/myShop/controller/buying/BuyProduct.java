package myShop.controller.buying;

import myShop.dao.GenericDAO;
import myShop.entity.BasketAndProduct;
import myShop.entity.Product;
import myShop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BuyProduct {
    @Autowired
    GenericDAO<User> userGenericDAO;
    @Autowired
    GenericDAO<Product> productGenericDAO;
    @Autowired
    GenericDAO<BasketAndProduct> basketAndProductGenericDAO;

    @RequestMapping("/buy")
    private ModelAndView Buying(@RequestParam("user") Long userId,
                                @RequestParam("product") Long productId,
                                @RequestParam(value = "quantity",defaultValue = "0") Double quantity) {
        ModelAndView modelAndView = new ModelAndView();
        String error = "product successfully added";
        modelAndView.setViewName("redirect:/");
        User user = userGenericDAO.getId(User.class, userId);
        Product product = productGenericDAO.getId(Product.class, productId);
        if (user.getBasket() == null) {
            error="basket not found";
        }else if(quantity==0){
            error="order from at least 1 kg";
        }
        basketAndProductGenericDAO.saveOrUpdate(new BasketAndProduct(user.getBasket(), product, quantity));
        modelAndView.addObject("error", error);
        modelAndView.addObject("user", userId);
        return modelAndView;
    }
}
