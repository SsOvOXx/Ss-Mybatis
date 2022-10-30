package com.ss.mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @program: Ss-Mybatis
 * @ClassName SqlSessionUtil
 * @description:
 * @author: SsOvOXx
 * @create: 2022-09-19 10:14
 * @Version 1.0
 **/
public class SqlSessionUtil {
    //
    private SqlSessionUtil(){}
    //
    private static SqlSessionFactory sqlSessionFactory;

    //
    static{
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
}