package com.ctrip.access;

import com.ctrip.mapper.SysConfigMapper;
import com.ctrip.pojo.SysConfig;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Created by jt_hu on 2016/12/29.
 */
public class SysConfigAccess implements SysConfigMapper {
    private SqlSession session;
    private SysConfigMapper mapper;

    public SysConfigAccess(){
        session = AccessFactory.getSession();
        try {
            mapper =  session.getMapper(SysConfigMapper.class);
        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 根据variable获取SysConfig
     *
     * @param variable
     * @return
     */
    @Override
    public List<SysConfig> select(String variable) {
        return mapper.select(variable);
    }

    /**
     * 关闭
     */
    public void close(){
        session.close();
    }
}
