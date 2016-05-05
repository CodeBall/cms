package net.yanzl.Service;

import net.yanzl.entity.UserEntity;
import net.yanzl.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xqq on 16-4-24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = "classpath*:spring.xml")
public class UserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void save(){
        UserEntity user = userService.addUser("xiaofang","juebufangqi","xiaofang@126.net");
        System.out.println(user.getUserId());
    }

    @Test
    public void delete(){
        System.out.println(userService.deleteUser((long) 4));
    }

    @Test
    public void update(){
        Map<String,String > map = new HashMap<String, String>();
        map.put("id","6");
        map.put("password","password");
        System.out.println(userService.updateUser(map));
    }

    @Test
    public void findAll(){
        Page<UserEntity> list = userService.findAll(4,2);

        if(!list.hasContent())
            System.out.println("false");
        else{
            for (UserEntity user : list)
                System.out.println(user.getUserId()+"\t"+user.getUserName());
        }
    }

}
