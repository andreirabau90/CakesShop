package myShop.validation.user;

import myShop.entity.User;
import myShop.validation.ValidatorImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class UserValidation {
    @Autowired
    public ValidatorImpl userValidator;

    @RequestMapping("/valid")
    public String addUser(@Valid @ModelAttribute("user") User user,
                          BindingResult bindingResult,
                          Model model) {

        userValidator.validate(user, bindingResult);
        if (bindingResult.getErrorCount() > 0) {
            return "/newValidUser";
        }
        model.addAttribute("name", user.getUserName());
        model.addAttribute("pass", user.getPass());
        model.addAttribute("email", user.getEmail());
        return "redirect:/addMyUser";

    }

    @RequestMapping(value = "/valid", method = RequestMethod.GET)
    public String profileGet(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/newValidUser";
    }
}
