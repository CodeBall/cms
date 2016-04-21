package net.yanzl.service;

import net.yanzl.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户Server层,完成用户基本操作
 * Created by xqq on 16-4-17.
 */
public interface IUserService {
    Boolean login(String email,String password);
    UserEntity addUser(String userName,String password,String email);
    Boolean updateUser(Map<String,String>map,UserEntity user);
    List<UserEntity> findAll();
}
