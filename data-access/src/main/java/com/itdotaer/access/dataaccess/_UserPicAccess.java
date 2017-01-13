package com.itdotaer.access.dataaccess;

import com.itdotaer.access.mapper._UserPicMapper;
import com.itdotaer.access.pojo._UserPic;
import org.apache.ibatis.session.SqlSession;

import java.util.Date;
import java.util.List;

/**
 * Created by jt_hu on 2017/1/13.
 */
public class _UserPicAccess implements _UserPicMapper {

    private SqlSession session;
    private _UserPicMapper mapper;

    public _UserPicAccess(){
        session = AccessFactory.getItdotaerSession();
        try {
            mapper =  session.getMapper(_UserPicMapper.class);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 获取User pics
     *
     * @param id
     * @return
     */
    @Override
    public List<_UserPic> getUserPics(int id) {
        return mapper.getUserPics(id);
    }

    /**
     * 获取UserPic
     *
     * @param id FileId
     * @return
     */
    @Override
    public _UserPic getPic(int id) {
        return mapper.getPic(id);
    }

    /**
     * 插入UserPic
     *
     * @param userPic
     * @return
     */
    @Override
    public int insertUserPic(_UserPic userPic) {
        if(userPic != null){
            Date now = new Date();
            userPic.setCreatedAt(now);
            userPic.setUpdatedAt(now);
        }

        return mapper.insertUserPic(userPic);
    }

    /**
     * 提交更改
     */
    public void commit(){
        session.commit();
    }

    /**
     * 关闭
     */
    public void close(){
        session.close();
    }
}
