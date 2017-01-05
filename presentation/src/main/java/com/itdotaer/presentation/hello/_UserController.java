package com.itdotaer.presentation.hello;

import com.itdotaer.access.pojo._User;
import com.itdotaer.businessoperation._user._UserOper;
import com.itdotaer.businessoperation._user._UserOperImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by jt_hu on 2017/1/4.
 */
@Controller
public class _UserController {
    @RequestMapping("/_users")
    public String index(Model model) {
        _UserOper userOper = new _UserOperImpl();
        List<_User> users = userOper.getAllUsers("%");

        model.addAttribute("users", users);
        return "_users";
    }
}
