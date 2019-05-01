package myShop.view;

import myShop.controller.groupproduct.GroupProductController;
import myShop.controller.product.ProductController;
import myShop.controller.user.LogIn;
import myShop.dao.GenericDAO;
import myShop.entity.GroupProduct;
import myShop.entity.Product;
import myShop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ShopView {
    @Autowired
    private GenericDAO<GroupProduct> groupProductDAOImpl;
    @Autowired
    GenericDAO<Product> productDAOImpl;
    @Autowired
    GenericDAO<User> userGenericDAO;
    @Autowired
    GroupProductController controllerGroupProduct;
    @Autowired
    ProductController controllerProduct;
    @Autowired
    LogIn logIn;


    @RequestMapping(value = {"/", "/shopPage"})
    public ModelAndView PrintShopPage(@RequestParam(value = "user", defaultValue = "0") Long userId,
                                      @RequestParam(value = "error", defaultValue = "") String error) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myCakesShop");
        if (userId != 0) {
            User user = userGenericDAO.getId(User.class, userId);
            modelAndView.addObject("user", user);
        }
        if (!error.isEmpty()) {
            modelAndView.addObject("error", error);
        }

        modelAndView.addObject("listGr", controllerGroupProduct.getAll());
        return modelAndView;
    }

    @RequestMapping("/getGroupProducts")
    public ModelAndView getProductId(@RequestParam(value = "id", defaultValue = "0") Long id,
                                     @RequestParam(value = "idProduct", defaultValue = "0") Long idProduct,
                                     @RequestParam(value = "user", defaultValue = "0") Long userId,
                                     @RequestParam(value = "error", defaultValue = "") String error,
                                     Model model
    ) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myCakesShop");
        if (userId != 0) {
            User user = userGenericDAO.getId(User.class, userId);
            modelAndView.addObject("user", user);
        }
        if (id == 0 && idProduct == 0) {
            modelAndView.addObject("user", userId);
            modelAndView.addObject("error", error);
            modelAndView.setViewName("redirect:/shopPage");
            return modelAndView;
        }
        if (id == 0) {
            Product product = productDAOImpl.getId(Product.class, idProduct);
            id = product.getGroupProduct().getId();
            modelAndView.addObject("product", product);
        }

        GroupProduct groupProduct = groupProductDAOImpl.getId(GroupProduct.class, id);
        List list = groupProduct.getProductList();
        modelAndView.addObject("listGr", controllerGroupProduct.getAll());
        modelAndView.addObject("listPr", list);
        modelAndView.addObject("error", error);
        return modelAndView;
    }
}
