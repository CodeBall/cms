package net.yanzl.Service;

import net.yanzl.entity.UserEntity;
import net.yanzl.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

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
        UserEntity user = userService.addUser("yzl","juebufangqi","m@yanzl.net");
        System.out.println(user.getUserId());
    }

    @Test
    public void delete(){

    }

}
