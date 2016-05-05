package net.yanzl.controller;

import net.yanzl.entity.UserEntity;
import net.yanzl.service.IUserService;
import net.yanzl.util.EncryptHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by xqq on 16-4-26.
 */

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    private IUserService userService;

    //调用首页
    @RequestMapping(method = RequestMethod.GET)
    public String index(){
        return "register";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        String email = request.getParameter("email");

        String password = request.getParameter("password");

        UserEntity user = userService.getOne(email);

        if(user == null || user.getPassword() == null){
            //跳转到登录失败页面
        }

        password = EncryptHelp.getPassword(password);

        boolean ren =  password.equals(user.getPassword());
        if(ren == true) {

            HttpSession session = request.getSession();

            session.setAttribute("userId",user.getUserId());
            session.setAttribute("userName",user.getUserName());
            session.setAttribute("email",user.getEmail());
            //跳转至首页
        }else {
            //跳转到登录失败页面
        }
        return "login";

    }

    @RequestMapping(value = "logout",method = RequestMethod.GET)
    public void logout(HttpServletRequest request){
        HttpSession session = request.getSession();

        session.removeAttribute("userId");
        session.removeAttribute("userName");
        session.removeAttribute("email");

        //跳转至登录页面
    }
}
