//package myShop.controller;
//
//import myShop.entity.Feedback;
//import myShop.entity.Product;
//import myShop.entity.User;
//import myShop.dao.GenericDAO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//import java.util.List;
//
//@Controller
//public class ControllerFeedback {
//    @Autowired
//    GenericDAO<Feedback> feedbackGenericDAO;
//    @Autowired
//    GenericDAO<User> userGenericDAOl;
//    @Autowired
//    GenericDAO<Product> productGenericDAO;
//
//    String feedbackName = "feedback";
//
//
//    public void saveOrUpdate(String text,
//                             User user,
//                             Product product
//    ) {
////         user = userGenericDAOl.getId(User.class, user.getUserId());
////         product = productGenericDAO.getId(Product.class, product.getId());
//        Feedback feedback = new Feedback();
//        feedback.setFeedbackProduct(product);
//        feedback.setFeedbackUser(user);
//        feedback.setText(text);
//        feedbackGenericDAO.saveOrUpdate(feedback);
//    }
//
//    public List getAllFeedback() {
//        List<Feedback> list = feedbackGenericDAO.getAll(feedbackName);
//        return list;
//    }
//}
