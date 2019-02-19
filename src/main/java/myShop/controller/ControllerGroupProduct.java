package myShop.controller;

import myShop.DAO.entityDAO.groupProductDAO.GroupProductDAO;
import myShop.Entity.GroupProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ControllerGroupProduct {

    private String groupName = "GroupProduct";
    @Autowired
    private GroupProductDAO groupProductDAOImpl;

    @RequestMapping("/getGroup")
    public void read(@RequestParam("id") long id) {
        GroupProduct groupProduct = groupProductDAOImpl.getId(id);
    }

    @RequestMapping("/saveOrUpdate")
    public void saveOrUpdate(@RequestParam(value = "id") Long id,
                             @RequestParam(value = "name", defaultValue = "null") String groupName) {
        GroupProduct groupProduct = groupProductDAOImpl.getId(id) == null ? new GroupProduct() : groupProductDAOImpl.getId(id);
        groupProduct.setGroup(groupName);
        groupProductDAOImpl.saveOrUpdate(groupProduct);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam(value = "id") long id) {
        GroupProduct groupProduct = groupProductDAOImpl.getId(id);
        groupProductDAOImpl.delete(groupProduct);
    }

    @RequestMapping("/allGroupProduct")
    public ModelAndView getAll() {
        List list = groupProductDAOImpl.getAll(groupName);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myCakesShop");
        modelAndView.addObject("listGr", list);
        return modelAndView;

    }

    @RequestMapping("/getGroupProducts")
    public ModelAndView getProductId(@RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("myCakesShop");
        GroupProduct groupProduct = groupProductDAOImpl.getId(id);
        List list = groupProduct.getProductList();
        modelAndView.addObject("listPr", list);
        return modelAndView;
    }
}



