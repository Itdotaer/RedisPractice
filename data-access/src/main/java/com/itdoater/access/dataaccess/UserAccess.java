package com.itdoater.access.dataaccess;

import com.itdoater.access.mapper.UserMapper;
import com.itdoater.access.pojo.Article;
import com.itdoater.access.pojo.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by jt_hu on 2016/12/30.
 */
public class UserAccess implements UserMapper {
    private SqlSession session;
    private UserMapper mapper;

    public UserAccess(){
        session = AccessFactory.getSession();
        try {
            mapper =  session.getMapper(UserMapper.class);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 根据id获取User
     *
     * @param id
     * @return
     */
    @Override
    public User getUserById(int id) {
        return mapper.getUserById(id);
    }

    /**
     * 获取Users like userName
     *
     * @param userName
     * @return
     */
    @Override
    public List<User> getUsers(String userName) {
        return mapper.getUsers(userName);
    }

    /**
     * 新增User
     *
     * @param user
     */
    @Override
    public void addUser(User user) {
        mapper.addUser(user);
        session.commit();
    }

    /**
     * 修改User
     *
     * @param user
     */
    @Override
    public void updateUser(User user) {
        mapper.updateUser(user);
        session.commit();
    }

    /**
     * 删除User
     *
     * @param id
     */
    @Override
    public void deleteUserById(int id) {
        mapper.deleteUserById(id);
        session.commit();
    }

    /**
     * 根据UserName删掉符合条件的Users
     *
     * @param userName
     */
    @Override
    public void deleteUserByUserName(String userName) {
        mapper.deleteUserByUserName(userName);
        session.commit();
    }

    /**
     * 关联查询
     *
     * @param id
     * @return
     */
    @Override
    public List<Article> getUserArtices(int id) {
        return mapper.getUserArtices(id);
    }

    /**
     * 关闭
     */
    public void close(){
        session.close();
    }
}
