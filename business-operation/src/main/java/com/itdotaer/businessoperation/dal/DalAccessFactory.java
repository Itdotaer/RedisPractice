package com.itdotaer.businessoperation.dal;


import com.itdotaer.access.dataaccess._UserAccess;
import com.itdotaer.access.dataaccess._UserPicAccess;

/**
 * Created by jt_hu on 2017/1/4.
 */
public class DalAccessFactory {
    /**
     * 获取UserAccess Session连接
     * @return
     */
    public static _UserAccess getUserAccess(){
        return new _UserAccess();
    }

    /**
     * 获取User Pic连接
     * @return
     */
    public static _UserPicAccess getUserPicAccess(){
        return new _UserPicAccess();
    }
}
