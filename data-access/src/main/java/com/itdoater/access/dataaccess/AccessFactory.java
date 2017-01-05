package com.itdoater.access.dataaccess;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;

/**
 * Created by jt_hu on 2016/12/30.
 */
public class AccessFactory {

    private static Logger logger = LoggerFactory.getLogger(AccessFactory.class);
    //多数据库
    private static SqlSessionFactory itdotaerSqlSessionFactory;
    private static SqlSessionFactory sysSqlSessionFactory;
    private static Reader reader;


    private static SqlSessionFactory getItdotaerSqlSessionFactory(){
        try{
            reader = Resources.getResourceAsReader("mybatisConfig.xml");
            itdotaerSqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "itdotaer");

            logger.info("Created Itdoater SessionFactory Successed");
        }catch(Exception e){
            e.printStackTrace();
        }

        return itdotaerSqlSessionFactory;
    }

    private static SqlSessionFactory getSysSqlSessionFactory(){
        try{
            reader = Resources.getResourceAsReader("mybatisConfig.xml");
            sysSqlSessionFactory = new SqlSessionFactoryBuilder().build(reader, "sys");

            logger.info("Created Sys SessionFactory Successed");
        }catch(Exception e){
            e.printStackTrace();
        }

        return sysSqlSessionFactory;
    }

    public static SqlSession getItdotaerSession(){
        if(itdotaerSqlSessionFactory == null){
            itdotaerSqlSessionFactory = getItdotaerSqlSessionFactory();
        }

        return itdotaerSqlSessionFactory.openSession();
    }

    public static SqlSession getSysSession(){
        if(sysSqlSessionFactory == null){
            sysSqlSessionFactory = getSysSqlSessionFactory();
        }

        return sysSqlSessionFactory.openSession();
    }
}
