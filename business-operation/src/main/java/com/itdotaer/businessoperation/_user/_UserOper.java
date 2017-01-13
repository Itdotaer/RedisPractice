package com.itdotaer.businessoperation._user;

import com.itdotaer.access.pojo._User;

import java.util.List;

/**
 * Created by jt_hu on 2017/1/4.
 */
public interface _UserOper {

    /**
     * 获取所有用户
     * @param userName
     * @return
     */
    List<_User> getAllUsers(String userName);

}
