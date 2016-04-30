package net.yanzl.service;

import net.yanzl.entity.UserEntity;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Map;

/**
 * 用户Server层,完成用户基本操作
 * Created by xqq on 16-4-17.
 */
public interface IUserService {
    UserEntity getOne(String email);
    UserEntity addUser(String userName,String password,String email);
    Boolean updateUser(Map<String,String>map);
    Page<UserEntity> findAll(int page,int size);
    boolean deleteUser(Long id);
}
