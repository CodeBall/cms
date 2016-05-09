package net.yanzl.controller;

import net.yanzl.entity.UserEntity;
import net.yanzl.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
     * 游客自己注册,注册成功后自动登录进入后台首页
     * @param request
     * @return
     */
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public String addUser(ModelMap map,HttpServletRequest request){

        String userName = request.getParameter("username");

        String password = request.getParameter("password");

        String email = request.getParameter("email");

        UserEntity user = userService.addUser(userName, password, email);

        if(user == null){
            map.addAttribute("status","注册失败!");
            return "register";

        }
        else {
            //注册成功,自动登录并进入后台首页面
            HttpSession session = request.getSession();
            session.setAttribute("userId",user.getUserId());
            session.setAttribute("userName", user.getUserName());
            session.setAttribute("email", user.getEmail());
            return "index";
        }
    }

    /**
     * 管理员添加用户界面,添加完成后不会自动登录,而是进入状态页面
     * @return
     */
    @RequestMapping(value = "/addOne",method = RequestMethod.POST)
    public String addUser(ModelMap map,String username,String password,String email){

        if(username.isEmpty() || password.isEmpty() || email.isEmpty()){
            map.addAttribute("status","新用户添加失败,用户名,密码和邮箱必不可少!");
            return "status";
        }
        UserEntity user = userService.addUser(username,password,email);

        if(user == null){
            //添加失败
            map.addAttribute("status","新用户添加失败");
        }
        else{
            //添加成功
            map.addAttribute("status", "新用户添加成功");
        }
        return "status";
    }

    /**
     * 添加用户页面调用方法
     * @return
     */
    @RequestMapping(value = "add/",method = RequestMethod.GET)
    public String addUser(){
        return "user/addUser";
    }
    /**
     * 删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    public String deleteUser(@PathVariable Long id,ModelMap map){
        if(userService.deleteUser(id)) {
            map.addAttribute("status","删除该用户成功");
        }
        else{
            map.addAttribute("status","删除该用户失败");
        }
        return "status";
    }

    /**
     * 修改用户信息调取界面方法
     * @param id
     * @param map
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.GET)
    public String updateUser(@PathVariable Long id,ModelMap map){
        UserEntity user = userService.getUserById(id);
        map.addAttribute("user",user);
        return "user/update";
    }
    /**
     * 修改用户
     * @param id
     * @return
     */
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    public String updateUser(ModelMap rnt,@PathVariable Long id,String username,String password,String email){
        if (username.isEmpty() || password.isEmpty() || email.isEmpty()){
            rnt.addAttribute("status","请填写完整的用户信息!");
            UserEntity user = userService.getUserById(id);
            rnt.addAttribute("user", user);
            return "user/update";
        }

        Map<String,String> map = new HashMap<String, String>();

        map.put("id",String.valueOf(id));

        map.put("userName",username);

        map.put("password",password);

        map.put("email", email);


        if(userService.updateUser(map))
            rnt.addAttribute("status","修改用户信息成功");
        else
            rnt.addAttribute("status","修改用户信息失败");

        return "status";
    }

    /**
     * 查询用户
     * @param page
     * @param size
     * @return
     */
    @RequestMapping(value = "/{page}/{size}",method = RequestMethod.GET)
    public String findAll(ModelMap map,@PathVariable int page,@PathVariable int size){
        Page<UserEntity> users = userService.findAll(page-1,size);

        if (users == null || !users.hasContent()){
            map.addAttribute("status",0);
            return "user/userList";
        }

        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();

        for (UserEntity user : users){
            Map<String,Object> one = new HashMap<String, Object>();
            one.put("id",user.getUserId());
            one.put("userName",user.getUserName());
            one.put("email",user.getEmail());

            list.add(one);
        }
        map.addAttribute("page", page);
        map.addAttribute("posts", list);
        map.addAttribute("status", 1);
        return "user/userList";
    }

    @RequestMapping(value = "/mine",method = RequestMethod.GET)
    public String findMine(){
        return "user/mine";
    }
}
