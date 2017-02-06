package com.itdotaer.presentation.hello;

import com.itdotaer.access.pojo._User;
import com.itdotaer.access.pojo._UserPic;
import com.itdotaer.businessoperation._user._UserOper;
import com.itdotaer.businessoperation._userpic._UserPicOper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

/**
 * Created by jt_hu on 2017/1/4.
 */
@Controller
public class _UserController {

    Logger logger = LoggerFactory.getLogger(_UserController.class);
    @Autowired
    private _UserOper userOper;
    @Autowired
    private _UserPicOper userPicOper;


    @RequestMapping("/_users")
    public String index(Model model) {
        List<_User> users = userOper.getAllUsers("%");

        model.addAttribute("users", users);
        return "_users";
    }

    @RequestMapping("/_userPics")
    public String userPics(Model model) {
        List<_UserPic> userPics = userPicOper.getUserPics(1);

        model.addAttribute("userPics", userPics);
        return "_userPics";
    }

    @PostMapping("/uploadFile")
    public String handleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes) throws IOException {

        _UserPic userPic = new _UserPic();
        userPic.setPicName(file.getOriginalFilename());
        userPic.setPic(file.getBytes());

        userPicOper.uploadPic(userPic);

        return "redirect:/_userPics";
    }
}
