package com.ctrip.mapper;

import com.ctrip.pojo.User;

import java.util.List;

/**
 * Created by jt_hu on 2016/12/30.
 */
public interface UserMapper {
    /**
     * 根据id获取User
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 获取Users like userName
     * @param userName
     * @return
     */
    List<User> getUsers(String userName);

    /**
     * 新增User
     * @param user
     */
    void addUser(User user);

    /**
     * 修改User
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除User
     * @param id
     */
    void deleteUserById(int id);

    /**
     * 根据UserName删掉符合条件的Users
     * @param userName
     */
    void deleteUserByUserName(String userName);
}
