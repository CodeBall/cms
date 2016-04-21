package net.yanzl.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import net.yanzl.entity.UserEntity;
import net.yanzl.repository.UserRepository;

import java.util.List;

/**
 * Created by xqq on 16-4-19.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(value = {"classpath*:spring.xml"})
public class UserDaoTest {
    @Autowired
    private UserRepository dao;

    /**
     * 测试存储用户信息
     */
    @Test
    public void save(){
        UserEntity user = new UserEntity("闫子璐","juebufangqi","m123@yanzl.com");
        dao.save(user);
        System.out.println(user.getUserName());
    }
    /**
     *测试根据Id查询用户
     */
    @Test
    @Transactional
    public void getUserById(){
        Long num = Long.valueOf(1);
        UserEntity user = dao.getOne(num);
        System.out.println(user.getUserName());
    }
    /**
     * 测试根据用户名查询用户
     */
    @Test
    public void getUserByUserName(){
        UserEntity user = dao.getUserByUserName("yzl");
        System.out.println(user.getUserId());
    }
    /**
     * 测试根据邮箱查询用户
     */
    @Test
    public void getUserByEmail(){
        UserEntity user = dao.getUserByEmail("m@yanzl.net");
        System.out.println(user.getUserName());
    }
    /**
     * 测试查询所有用户
     */
    @Test
    public void getAll(){
        List<UserEntity> list = dao.findAll();

        for(UserEntity user : list){
            System.out.println(user.getUserId() + "\t" + user.getUserName());
        }
    }

    /**
     * 测试删除用户
     */
    @Test
    public void deleteUser(){
        dao.delete((long) 6);
        System.out.println("1");
    }

    /**
     * 测试修改用户信息
     */
    @Test
    public void ipdateUser(){
        UserEntity user = dao.findOne((long) 1);
        user.setEmail("yanzl.net@126.com");
        dao.save(user);
        System.out.println(user.getEmail());
    }
}
