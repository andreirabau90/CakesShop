package myShop.controller.basketandproduct;

import myShop.dao.GenericDAO;
import myShop.entity.BasketAndProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DeleteProductInBasket {
    @Autowired
    GenericDAO<BasketAndProduct> basketAndProductGenericDAO;

    @RequestMapping("/deleteProductInBasket")
    private ModelAndView DeleteProduct(@RequestParam(value = "deleteId") Long deleteId) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", basketAndProductGenericDAO.getId(BasketAndProduct.class, deleteId).getBasket().getUser().getUserId());
        basketAndProductGenericDAO.delete(basketAndProductGenericDAO.getId(BasketAndProduct.class, deleteId));
        modelAndView.setViewName("redirect:/getBasket");
        return modelAndView;
    }
}
