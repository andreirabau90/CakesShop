package myShop.validation;


import myShop.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ValidatorImpl implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "name.error");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pass", "pass.error");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.error");
    }
}
