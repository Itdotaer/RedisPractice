package com.itdotaer.businessoperation._userpic;

import com.itdotaer.access.pojo._UserPic;

import java.util.List;

/**
 * Created by jt_hu on 2017/1/13.
 */
public interface  _UserPicOper {

    /**
     * 获取所有用户图片
     * @param id UserId
     * @return
     */
    List<_UserPic> getUserPics(int id);

    /**
     * 获取UserPic
     * @param id FileId
     * @return
     */
    _UserPic getPic(int id);

    /**
     * 上传新图片
     * @param userPic
     * @return
     */
    boolean uploadPic(_UserPic userPic);

}
