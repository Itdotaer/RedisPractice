package com.itdoater.access.mapper;

import com.itdoater.access.pojo.Article;
import com.itdoater.access.pojo.User;
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
    int addUser(User user);

    /**
     * 修改User
     * @param user
     */
    int updateUser(User user);

    /**
     * 删除User
     * @param id
     */
    int deleteUserById(int id);

    /**
     * 根据UserName删掉符合条件的Users
     * @param userName
     */
    int deleteUserByUserName(String userName);

    /**
     * 关联查询
     * @param id
     * @return
     */
    List<Article> getUserArtices(int id);
}
