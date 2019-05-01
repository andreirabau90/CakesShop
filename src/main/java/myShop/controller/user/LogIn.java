package myShop.controller.user;

import myShop.repository.UserConnectionBD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class LogIn {
    @Autowired
    UserConnectionBD userConnectionBD;

    @RequestMapping("/logIn")
    public ModelAndView enterUser(@RequestParam("name") String name,
                                  @RequestParam("pass") String pass) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        String error = "The name or password number you’ve entered doesn't match any account";
        if (userConnectionBD.existUser(name, pass)) {
            modelAndView.addObject("user", userConnectionBD.getUserId(name));
            modelAndView.setViewName("redirect:getGroupProducts");
            error = "Welcome!";
        }
        modelAndView.addObject("error", error);
        return modelAndView;
    }
}
