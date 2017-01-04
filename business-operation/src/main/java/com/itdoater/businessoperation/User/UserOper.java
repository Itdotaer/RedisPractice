package com.itdoater.businessoperation.User;

import com.itdoater.access.pojo.User;
import java.util.List;

/**
 * Created by jt_hu on 2017/1/4.
 */
public interface UserOper {

    /**
     * 获取所有用户
     * @param userName
     * @return
     */
    List<User> getAllUsers(String userName);

}
