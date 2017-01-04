package com.ctrip.presentation.hello;

import com.ctrip.businessoperation.User.UserOper;
import com.ctrip.businessoperation.User.UserOperImpl;
import com.ctrip.access.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by jt_hu on 2017/1/4.
 */
@Controller
public class UserController {
    @RequestMapping("/users")
    public String index(Model model) {
        UserOper userOper = new UserOperImpl();
        List<User> users = userOper.getAllUsers("%");

        model.addAttribute("users", users);
        return "users";
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String addUser(Model model){
        return "user";
    }
}
