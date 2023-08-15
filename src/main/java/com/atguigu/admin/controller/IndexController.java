package com.atguigu.admin.controller;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.bean.City;
import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.AccountService;
import com.atguigu.admin.service.CityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    AccountService accountService;

    @Autowired
    CityService cityService;


    @ResponseBody
    @GetMapping("/city")
    public City getCityById(@RequestParam("id") Long id){
        return cityService.getById(id);
    }



    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id")Long id){
        Account acct = accountService.getAcctById(id);

        return acct;
    }






    /** 登录页
     *
     * @return
     */
    @GetMapping(value = {"/","/login"})
    public String loginPage(){
        return "login";
    }

    /** 登录成功来到首页
     *
     */
    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model){

        if(!StringUtils.isEmpty(user.getUserName()) && StringUtils.hasLength(user.getPassword())){
            //保存登录成功的用户信息
            session.setAttribute("loginUser",user);
            return "redirect:/main.html"; // 重定向到 main.html
        }else {
            model.addAttribute("msg","账号密码错误");

            //回到登录页
            return "login";
        }


    }


    /** 真正去main页面 , 匹配上面的重定向 ,实现真正的main.html跳转
     *  只能通过返回视图来跳转页面 , 无法通过直接的请求访问到页面
     *
     * @return
     */
    @GetMapping("/main.html") // 匹配上面的重定向 , 实现真正的跳转
    public String mainPage(HttpSession session , Model model){

        log.info("当前方法是:{}","mainPage()控制器方法");

        return "main";
    }
}
