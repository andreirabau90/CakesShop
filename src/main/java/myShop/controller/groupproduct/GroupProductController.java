package myShop.controller.groupproduct;

import myShop.dao.GenericDAO;
import myShop.entity.GroupProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class GroupProductController {

    @Autowired
    private GenericDAO<GroupProduct> groupProductDAOImpl;
    String groupName = "GroupProduct";

    @RequestMapping("/getGroup")
    public void read(@RequestParam("id") long id) {
        GroupProduct groupProduct = groupProductDAOImpl.getId(GroupProduct.class, id);
    }

    @RequestMapping("/saveOrUpdate")
    public void saveOrUpdate(@RequestParam(value = "id") Long id,
                             @RequestParam(value = "name", defaultValue = "null") String groupName) {
        GroupProduct groupProduct = groupProductDAOImpl.getId(GroupProduct.class, id) == null ? new GroupProduct() : groupProductDAOImpl.getId(GroupProduct.class, id);
        groupProduct.setGroup(groupName);
        groupProductDAOImpl.saveOrUpdate(groupProduct);
    }

    @RequestMapping("/delete")
    public void delete(@RequestParam(value = "id") long id) {
        GroupProduct groupProduct = groupProductDAOImpl.getId(GroupProduct.class, id);
        groupProductDAOImpl.delete(groupProduct);
    }

    public List getAll() {

        List<GroupProduct> list = groupProductDAOImpl.getAll(groupName);
        return list;
    }

}