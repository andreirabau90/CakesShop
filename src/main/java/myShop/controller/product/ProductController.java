package myShop.controller.product;


import myShop.dao.GenericDAO;
import myShop.entity.GroupProduct;
import myShop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ProductController {
    @Autowired
    private GenericDAO<Product> productDAOImpl;
    @Autowired
    private GenericDAO<GroupProduct> groupProductDAOImpl;

    @RequestMapping("/getProduct")
    public void getProduct(@RequestParam("id") Long id) {

        Product product = productDAOImpl.getId(Product.class, id);

    }

    @RequestMapping("/saveOrUpdateProduct")
    public void saveOrUpdate(@RequestParam("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("price") int price,
                             @RequestParam("groupProductId") Long groupProductId) {
        GroupProduct groupProduct = groupProductDAOImpl.getId(GroupProduct.class, groupProductId);
        // TODO: 11.03.2019  try catch (nullPointException)
        if (groupProduct.getId() == null) {
            return;
        }
        Product product = productDAOImpl.getId(Product.class, id) == null ? new Product() : productDAOImpl.getId(Product.class, id);
        product.setProductName(name);
        product.setPrice(price);
        product.setGroupProduct(groupProduct);
        productDAOImpl.saveOrUpdate(product);
    }

    @RequestMapping("/deleteProduct")
    public void delete(@RequestParam("id") Long id) {
        Product product = productDAOImpl.getId(Product.class, id);
        productDAOImpl.delete(product);
    }

    @RequestMapping("/getDescription")
    public ModelAndView getDescription(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        Product product = productDAOImpl.getId(Product.class, id);
        String description = product.getDescription();
        modelAndView.setViewName("myCakesShop");
        modelAndView.addObject("description", description);
        return modelAndView;


    }

    @RequestMapping("/setDescription")
    public void setDescription(@RequestParam("description") String description,
                               @RequestParam("id") Long id) {
        Product product = productDAOImpl.getId(Product.class, id);
        product.setDescription(description);
        productDAOImpl.saveOrUpdate(product);
    }


}
