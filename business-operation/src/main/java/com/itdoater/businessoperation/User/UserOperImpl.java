package com.itdoater.businessoperation.User;

import com.itdoater.access.pojo.User;
import com.itdoater.businessoperation.dal.DalAccessFactory;
import java.util.List;

/**
 * Created by jt_hu on 2017/1/4.
 */
public class UserOperImpl implements UserOper{

    /**
     * 获取所有用户
     * @param userName
     * @return
     */
    @Override
    public List<User> getAllUsers(String userName) {
        return DalAccessFactory.getUserAccess().getUsers(userName);
    }
}
