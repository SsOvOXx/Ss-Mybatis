package com.ss;

import com.ss.utils.SqlSessionUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

public class CarMapperTest {
    @Test
    public void testInsertCarUtil(){
        SqlSession sqlSession = SqlSessionUtil.sqlSession();
        int insertCarCount = sqlSession.insert("insertCar");
        System.out.println("输入的记录条数：" + insertCarCount);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCar(){
        SqlSession sqlSession = null;
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        try {
            SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(Resources.getResourceAsStream("mybatis-config.xml"));
            sqlSession = sqlSessionFactory.openSession();
            int count = sqlSession.insert("insertCar");
            System.out.println("输入的记录条数：" + count);
            sqlSession.commit();
        } catch (Exception e) {
            if(sqlSession != null){
                sqlSession.rollback();
            }
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }
}
