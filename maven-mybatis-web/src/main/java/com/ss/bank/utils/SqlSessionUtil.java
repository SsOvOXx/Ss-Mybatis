package com.ss.bank.utils;

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

    // 全局的，服务器级别的，一个服务器中定义一个即可
    private static ThreadLocal<SqlSession> local = new ThreadLocal<>();

    public static SqlSession openSession(){
        SqlSession sqlSession = local.get();
        if (sqlSession == null) {
            sqlSession = sqlSessionFactory.openSession();
            // 绑定到当前线程
            local.set(sqlSession);
        }
        return sqlSession;
    }

    public static void close(SqlSession sqlSession){
        if(sqlSession != null){
            sqlSession.close();
            // 移除sqlSession对象和当前对象的绑定关系
            local.remove();
        }
    }
}