package com.ss.mybatis.test;

import com.ss.mybatis.mapper.CarMapper;
import com.ss.mybatis.pojo.Car;
import com.ss.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @program: Ss-Mybatis
 * @ClassName CarMapperTest
 * @description:
 * @author: SsOvOXx
 * @create: 2022-10-04 09:18
 * @Version 1.0
 **/
public class CarMapperTest {
    @Test
    public void selectByIdTest(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = mapper.selectById(20L);
        System.out.println(car);
        sqlSession.close();
    }
}