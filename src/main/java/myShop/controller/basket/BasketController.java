package myShop.controller.basket;


import myShop.entity.Basket;
import myShop.entity.Product;
import myShop.entity.User;
import myShop.dao.GenericDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BasketController {
    @Autowired
    GenericDAO<Basket> basketGenericDAO;
    @Autowired
    GenericDAO<User> userGenericDAO;
    @Autowired
    GenericDAO<Product> productGenericDAO;
    public void getBacket(Long id) {
        basketGenericDAO.getId(Basket.class, id);
    }

    @RequestMapping("/buy")
    public ModelAndView saveOrUpdateBasket(@RequestParam(value = "user",defaultValue = "0") Long userId,
                                           @RequestParam(value = "product", defaultValue = "0") Long productId,
                                           @RequestParam(value ="quantity", defaultValue = "0") double quantity) {
        ModelAndView modelAndView= new ModelAndView();
        Basket basket= new Basket();


        User user= userGenericDAO.getId(User.class,userId);

        try{
            basket = new Basket();
        } catch (NullPointerException e) {
             e.fillInStackTrace();
        }

        Product product= productGenericDAO.getId(Product.class,productId);

        basket.setQuantity(quantity);
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        basket.setProductList(productList);
        user.setBasket(basket);
        basketGenericDAO.saveOrUpdate(basket);
        modelAndView.setViewName("redirect:/getGroupProducts");
        modelAndView.addObject("idProduct",product.getId());
        modelAndView.addObject("user",userId);
 return modelAndView;
    }
}
