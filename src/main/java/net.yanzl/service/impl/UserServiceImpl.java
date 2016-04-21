package net.yanzl.service.impl;

import net.yanzl.entity.UserEntity;
import net.yanzl.repository.UserRepository;
import net.yanzl.service.IUserService;
import net.yanzl.util.EncryptHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by xqq on 16-4-17.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 登录验证
     * @param email
     * @param password
     * @return
     */
    public Boolean login(String email,String password){
        if(password == null || email == null || password.length() == 0){
            return false;
        }

        UserEntity user = userRepository.getUserByEmail(email);

        if(user == null || user.getPassword() == null)
            return false;
        password = EncryptHelp.getPassword(password);

        return password.equals(user.getPassword());
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
     * @param user
     * @return
     */
    public Boolean updateUser(Map<String,String> map,UserEntity user){
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
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }
}
