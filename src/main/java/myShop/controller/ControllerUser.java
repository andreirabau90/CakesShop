//package myShop.controller;
//
//import myShop.DAO.GenericDAO;
//import myShop.Entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//public class ControllerUser {
//    @Autowired
//   private GenericDAO genericDAOImpl;
//    @RequestMapping("/addMyUser")
//    public void addUser(@RequestParam("name") String name,
//                        @RequestParam("pass") String pass,
//                        @RequestParam("email") String email){
//        User user= new User();
//        user.setName(name);
//        user.setPass(pass);
//        user.setEmail(email);
//        genericDAOImpl.saveOrUpdate(user);
//
//    }
//    @RequestMapping("/deleteUser")
//    public void deleteUser(@RequestParam("id") Long id){
//        User user=(User)genericDAOImpl.getId(id);
//        System.out.println(user.toString());
//genericDAOImpl.delete(user);
//
//    }
//}
