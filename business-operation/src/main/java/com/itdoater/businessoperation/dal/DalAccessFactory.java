package com.itdoater.businessoperation.dal;


import com.itdoater.access.dataaccess._UserAccess;

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
}
