package com.itdoater.businessoperation._user;

import com.itdoater.access.pojo._User;
import com.itdoater.businessoperation.dal.DalAccessFactory;
import java.util.List;

/**
 * Created by jt_hu on 2017/1/4.
 */
public class _UserOperImpl implements _UserOper{

    /**
     * 获取所有用户
     * @param userName
     * @return
     */
    @Override
    public List<_User> getAllUsers(String userName) {
        return DalAccessFactory.getUserAccess().getUsers(userName);
    }
}
