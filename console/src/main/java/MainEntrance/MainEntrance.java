package MainEntrance;

import com.ctrip.access.SysConfigAccess;
import com.ctrip.mapper.SysConfigMapper;
import com.ctrip.pojo.SysConfig;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

class MainEntrance{
    public static  void main(String[] args){
        SqlSessionFactory sqlSessionFactory = SysConfigAccess.getSession();
        SqlSession session = sqlSessionFactory.openSession();
        try {
            SysConfigMapper sysConfigMapper =  session.getMapper(SysConfigMapper.class);
            List<SysConfig> sysConfigs = sysConfigMapper.select("");

            for(SysConfig sysConfig : sysConfigs){
                String rs = String.format("%s\t%s\t%s\t%s", sysConfig.getVariable(), sysConfig.getValue(),
                        sysConfig.getSetTime(), sysConfig.getSetBy());
                System.out.println(rs);
            }
        } finally {
            session.close();
        }
    }
}