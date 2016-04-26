package net.yanzl.controller;

import net.yanzl.entity.UserEntity;
import net.yanzl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by xqq on 16-4-26.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;

    /**
     * 添加用户
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public @ResponseBody boolean addUser(HttpServletRequest request){

        String userName = request.getParameter("userName");

        String password = request.getParameter("password");

        String email = request.getParameter("email");

        UserEntity user = userService.addUser(userName,password,email);

        if(user == null)
            return false;
        else
            return true;
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public @ResponseBody boolean deleteUser(@PathVariable Long id){
        if(userService.deleteUser(id))
            return true;
        else
            return false;
    }

    /**
     * 修改用户
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public @ResponseBody boolean updateUser(@PathVariable Long id,HttpServletRequest request){
        Map<String,String> map = new HashMap<String, String>();
        map.put("id",String.valueOf(id));

        map.put("userName",request.getParameter("userName"));

        map.put("password",request.getParameter("password"));

        map.put("email",request.getParameter("email"));

        if(userService.updateUser(map))
            return true;
        else
            return false;
    }

    /**
     * 查询用户
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/{page}/{size}",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> findAll(@PathVariable int page,@PathVariable int size){
        Map<String,Object> rnt = new HashMap<String, Object>();
        Page<UserEntity> users = userService.findAll(page,size);

        if (users == null || !users.hasContent()){
            rnt.put("status",0);
            return rnt;
        }

        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();

        for (UserEntity user : users){
            Map<String,Object> one = new HashMap<String, Object>();
            one.put("id",user.getUserId());
            one.put("userName",user.getUserName());
            one.put("email",user.getEmail());

            list.add(one);
        }

        rnt.put("posts", list);
        rnt.put("status", 1);
        return rnt;
    }
}
