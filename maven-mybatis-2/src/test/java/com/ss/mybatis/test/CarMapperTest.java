package com.ss.mybatis.test;

import com.ss.mybatis.pojo.Car;
import com.ss.mybatis.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: Ss-Mybatis
 * @ClassName CarMapperTest
 * @description:
 * @author: SsOvOXx
 * @create: 2022-09-20 07:44
 * @Version 1.0
 **/
public class CarMapperTest {
    @Test
    public void testSelectAll(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        List<Object> cars = sqlSession.selectList("selectAll");
        System.out.println(cars);
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Object car = sqlSession.selectOne("selectById", 1);
        System.out.println(car);

        sqlSession.close();
    }

    @Test
    public void testUpdateById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(4L, "3344", "特斯拉ss", 60.0, "2020-1-12", "新能源");
        int count = sqlSession.delete("updateById", car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testDeleteById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        int count = sqlSession.delete("deleteById", 19);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCarByPOJO(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Car car = new Car(null, "3333", "特斯拉", 30.0, "2020-12-12", "新能源");
        int count = sqlSession.insert("insertCar" , car);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testInsertCar(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        Map<String, Object> map = new HashMap<>();
        // key不存在，获取null
        map.put("carNum", "1111");
        map.put("brand", "比亚迪汉");
        map.put("guidePrice", 10.0);
        map.put("produceTime", "2020-11-11");
        map.put("carType", "电车");

        int count = sqlSession.insert("insertCar" , map);
        System.out.println(count);

        sqlSession.commit();
        sqlSession.close();
    }
}