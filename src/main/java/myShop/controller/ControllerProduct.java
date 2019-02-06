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

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerProduct {
    @Autowired
    private ProductDAO productDAOImpl;
    @Autowired
    private GroupProductDAO groupProductDAO;

    @RequestMapping("/getProduct")
    public void add(@RequestParam("id") Long id) {

        Product product = productDAOImpl.getId(id);

    }

    @RequestMapping("/saveOrUpdateProduct")
    public void savaOrUpdate(@RequestParam("id") Long id,
                             @RequestParam("name") String name,
                             @RequestParam("price") int price,
                             @RequestParam("groupProductId") Long groupProductId) {
        GroupProduct groupProduct = groupProductDAO.getId(groupProductId);
      if(groupProduct.getId() == null){
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
    @RequestMapping("/getGroupProducts")
    public ModelAndView getProductId(@RequestParam("myList") List listGroups){
        ModelAndView modelAndView= new ModelAndView();
        modelAndView.setViewName("myCakesShop");
        List listProducts= new ArrayList();
//       List<Product> list=productDAOImpl.getAll("Product");

//        for (Product p: list
//             ) {
//            if (p.getGroupProduct().getId()==){
//                list1.add(p);
//            }
//        }
        listProducts.addAll(productDAOImpl.getAll("Product"));

        modelAndView.addObject("listGr",listGroups);
        modelAndView.addObject("listPr",listProducts);
        return modelAndView;


    }




}
