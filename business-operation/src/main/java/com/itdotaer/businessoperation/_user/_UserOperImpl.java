package com.itdotaer.businessoperation._user;

import com.itdotaer.access.dataaccess._UserAccess;
import com.itdotaer.access.pojo._User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by jt_hu on 2017/1/4.
 */
@Service
public class _UserOperImpl implements _UserOper{

    @Autowired
    private _UserAccess userAccess;

//    public _UserOperImpl(){
//        userAccess = DalAccessFactory.getUserAccess();
//    }

    /**
     * 获取所有用户
     * @param userName
     * @return
     */
    @Override
    public List<_User> getAllUsers(String userName) {
        return userAccess.getUsers(userName);
    }

}
