package com.itdotaer.businessoperation._userpic;

import com.itdotaer.access.dataaccess._UserPicAccess;
import com.itdotaer.access.pojo._UserPic;
import com.itdotaer.businessoperation.dal.DalAccessFactory;

import java.util.List;

/**
 * Created by jt_hu on 2017/1/13.
 */
public class _UserPicOperImpl implements _UserPicOper {

    private _UserPicAccess userPicAccess;

    public _UserPicOperImpl(){
        userPicAccess = DalAccessFactory.getUserPicAccess();
    }

    /**
     * 获取所有用户图片
     * @param id UserId
     * @return
     */
    @Override
    public List<_UserPic> getUserPics(int id) {
        return userPicAccess.getUserPics(id);
    }

    /**
     * 获取UserPic
     *
     * @param id FileId
     * @return
     */
    @Override
    public _UserPic getPic(int id) {
        return userPicAccess.getPic(id);
    }

    /**
     * 上传新图片
     *
     * @param userPic
     * @return
     */
    @Override
    public boolean uploadPic(_UserPic userPic) {
        int count = userPicAccess.insertUserPic(userPic);
        DalAccessFactory.getUserPicAccess().commit();

        return count > 0;
    }

}
