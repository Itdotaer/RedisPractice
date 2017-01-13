package com.itdotaer.presentation.hello;

import com.itdotaer.access.pojo._UserPic;
import com.itdotaer.businessoperation._userpic._UserPicOper;
import com.itdotaer.businessoperation._userpic._UserPicOperImpl;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by jt_hu on 2017/1/13.
 */
@Controller
public class BlogImgController {

    Logger logger = LoggerFactory.getLogger(BlogImgController.class);

    /**
     * Blob图片生成器
     * @param fileId
     * @param model
     * @return
     */
    @RequestMapping(value = "/image/{fileId}")
    public void image(@PathVariable int fileId, Model model, HttpServletResponse response) throws IOException {
        _UserPicOper userPicOper = new _UserPicOperImpl();
        _UserPic userPic = userPicOper.getPic(fileId);
        InputStream inputStream = new ByteArrayInputStream(userPic.getPic());

        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        IOUtils.copy(inputStream, response.getOutputStream());
    }

    @ResponseBody
    @RequestMapping(value = "/imageDemo/{fileId}")
    public ResponseEntity<InputStreamResource> imageDemo(@PathVariable int fileId) {
        _UserPicOper userPicOper = new _UserPicOperImpl();
        _UserPic userPic = userPicOper.getPic(fileId);

        return ResponseEntity.ok()
                .contentLength(userPic.getPic().length)
                .contentType(MediaType.IMAGE_JPEG)
                .body(new InputStreamResource(new ByteArrayInputStream(userPic.getPic())));
    }
}
