package com.itdotaer.access.mapper;

import com.itdotaer.access.pojo.Article;
import com.itdotaer.access.pojo.UserArticles;
import com.itdotaer.access.pojo._User;
import java.util.List;

/**
 * Created by jt_hu on 2016/12/30.
 */
public interface _UserMapper {
    /**
     * 根据id获取User
     * @param id
     * @return
     */
    _User getUserById(int id);

    /**
     * 获取Users like userName
     * @param userName
     * @return
     */
    List<_User> getUsers(String userName);

    /**
     * 新增User
     * @param user
     */
    int addUser(_User user);

    /**
     * 修改User
     * @param user
     */
    int updateUser(_User user);

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
    List<Article> getUserArticles(int id);

    UserArticles getUserArticlesBySelect(int id);
}
