package com.ss;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class MyBatisIntroductionTest {
    public static void main(String[] args) throws Exception {
        //获取SqlSessionFactoryBuilder对象
        //直接new对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        //获取SqlSessionFactory对象
        //创建输入流，通过Resources.getResourcesAsStream()获取配置文件地址
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //类加载器加载
        //底层：ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //一般情况下，一个数据库对应一个SqlSessionFactory

        //获取SqlSession对象
        //openSession()
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //执行Sql语句
        //insert()
        int count = sqlSession.insert("insertCar");
        System.out.println("输入的记录条数：" + count);

        //MyBatis不会自动提交记录，需要手动提交
        sqlSession.commit();
    }
}
