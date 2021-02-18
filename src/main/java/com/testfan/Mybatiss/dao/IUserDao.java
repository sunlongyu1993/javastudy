package com.testfan.Mybatiss.dao;

import com.testfan.Mybatiss.domain.User;

import java.util.List;

/**
 * @author 孙珑瑜
 * @version 20210218
 * 用户的持久层接口
 */
public interface IUserDao {
    List<User> findAll();
}
