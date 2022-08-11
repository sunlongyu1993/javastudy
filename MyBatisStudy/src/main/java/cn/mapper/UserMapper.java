package cn.mapper;

import cn.pojo.User;

/**
 * @author 孙珑瑜
 * @version 20220811
 */
public interface UserMapper {
    User selectUserInfo(Integer id);
}
