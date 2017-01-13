package com.itdotaer.access.mapper;

import com.itdotaer.access.pojo._UserPic;

import java.util.List;

/**
 * Created by jt_hu on 2017/1/13.
 */
public interface _UserPicMapper {

    /**
     * 获取User pics
     * @param id
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
     * 插入UserPic
     * @param userPic
     * @return
     */
    int insertUserPic(_UserPic userPic);
}
