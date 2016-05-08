package net.yanzl.service.impl;

import net.yanzl.entity.UserEntity;
import net.yanzl.repository.UserRepository;
import net.yanzl.service.IUserService;
import net.yanzl.util.EncryptHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.lang.Boolean;

/**
 * Created by xqq on 16-4-17.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    public UserEntity getOne(String email){
        UserEntity user = userRepository.getUserByEmail(email);
        return user;
    }

    /**
     * 添加用户信息
     * @param userName
     * @param password
     * @param email
     * @return
     */
    public UserEntity addUser(String userName,String password,String email){
        if(userRepository.getUserByEmail(email) == null && userRepository.getUserByUserName(userName)==null){
            UserEntity newUser = new UserEntity(userName,EncryptHelp.getPassword(password),email);
            userRepository.save(newUser);
            return newUser;
        }
        return null;
    }

    /**
     * 修改用户信息
     * @param map
     * @return
     */
    public Boolean updateUser(Map<String,String> map){
        String id = map.get("id");
        Long userId = Long.parseLong(id);
        UserEntity user = userRepository.findOne(userId);
        if(map.containsKey("userName")){
            String userName = map.get("userName");
            user.setUserName(userName);
        }
        if (map.containsKey("password")){
            String password = map.get("password");

            if(password != null && password.length() > 3){
                user.setPassword(EncryptHelp.getPassword(password));
            }
        }
        if (map.containsKey("email")){
            String email = map.get("email");
            user.setEmail(email);
        }
        userRepository.save(user);
        return true;
    }

    /**
     * 查询所有用户信息
     * @return
     */
    public Page<UserEntity> findAll(int page,int size){
        Page<UserEntity> list = userRepository.findAll(new PageRequest(page, size));
        return list;
    }

    /**
     * 根据用户id查询用户信息
     * @param id
     * @return
     */
    public UserEntity getUserById(Long id){
        UserEntity user = userRepository.getUserByUserId(id);
        return user;
    }

    /**
     * 删除用户
     */
    public boolean deleteUser(Long id){
        userRepository.delete(id);

        return true;
    }
}
