package com.ss.mybatis.mapper;

import com.ss.mybatis.pojo.Car;

/**
 * @program: Ss-Mybatis
 * @ClassName CarMapper
 * @description:
 * @author: SsOvOXx
 * @create: 2022-10-04 09:12
 * @Version 1.0
 **/
public interface CarMapper {
    Car selectById(Long id);
}
