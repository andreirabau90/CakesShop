package myShop.controller;

import myShop.DAO.entityDAO.groupProductDAO.GroupProductDAO;
import myShop.DAO.entityDAO.productDAO.ProductDAO;
import myShop.Entity.GroupProduct;
import myShop.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControllerProduct {
    @Autowired
    private ProductDAO productDAOImpl;
    @Autowired
    private GroupProductDAO groupProductDAOImpl;

    @RequestMapping("/getProduct")
    public void add(@RequestParam("id") Long id) {

        Product product = productDAOImpl.getId(id);

    }

    @RequestMapping("/saveOrUpdateProduct")
    public void savaOrUpdate(@RequestParam("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("price") int price,
                             @RequestParam("groupProductId") Long groupProductId) {
        GroupProduct groupProduct = groupProductDAOImpl.getId(groupProductId);
        if (groupProduct.getId() == null) {
            return;
        }
        Product product = productDAOImpl.getId(id) == null ? new Product() : productDAOImpl.getId(id);
        product.setProductName(name);
        product.setPrice(price);
        product.setGroupProduct(groupProduct);
        productDAOImpl.saveOrUpdate(product);
    }

    @RequestMapping("/deleteProduct")
    public void delete(@RequestParam("id") Long id) {
        Product product = productDAOImpl.getId(id);
        productDAOImpl.delete(product);
    }

    @RequestMapping("/getAllProduct")
    public ModelAndView getAllProduct() {
        List list = productDAOImpl.getAll("Product");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/start");
        modelAndView.addObject("product", list);
        return modelAndView;
    }

    @RequestMapping("/getDescription")
    public ModelAndView getDescription(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = productDAOImpl.getId(id);
        String description = product.getDescription();
        modelAndView.setViewName("myCakesShop");
        modelAndView.addObject("description", description);
        return modelAndView;


    }

    @RequestMapping("/setDescription")
    public void setDescription(@RequestParam("description") String description,
                               @RequestParam("id") Long id) {
        Product product = productDAOImpl.getId(id);
        product.setDescription(description);
        productDAOImpl.saveOrUpdate(product);
        System.out.println(product.getDescription());
    }


}
