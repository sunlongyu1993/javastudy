package com.testfan.Mybatiss.dao;

import com.testfan.Mybatiss.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author 孙珑瑜
 * @version 20210218
 * 用户的持久层接口
 */
//不使用注解
public interface IUserDao {
    List<User> findAll();
}



//使用注解
//public interface IUserDao {
//
//    @Select("select * from user")
//    List<User> findAll();
//}