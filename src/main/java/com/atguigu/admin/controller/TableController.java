package com.atguigu.admin.controller;

import com.atguigu.admin.bean.User;
import com.atguigu.admin.service.UserService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserService userService;


    @GetMapping("/basic_table")
    public String basic_table(){
        return "table/basic_table"; //因为前面一层目录不是 templates
    }


    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id ,
                             @RequestParam(value = "pn",defaultValue = "1")Integer pn,
                            RedirectAttributes ra){

        userService.removeById(id);
        ra.addAttribute("pn",pn);//这样就可以 以请求参数的形式 添加到重定向的请求里 , 刚好下面我们又取出了这个pn,完美
        return "redirect:/dynamic_table";
    }



    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn",defaultValue = "1")Integer pn, Model model){

        //从数据库的user表中查出用户信息
        List<User> list = userService.list();
        model.addAttribute("users",list);

        //分页查询数据
        Page<User> userPage = new Page<>(pn, 2);

        //分页查询的结果 , 里面有很多属性, 直接把 page对象共享到域中,就用点对象的方式,获取其内部的属性值
        Page<User> page = userService.page(userPage, null);
        model.addAttribute("page",page);

        return "table/dynamic_table"; //因为前面一层目录不是 templates
    }


    @GetMapping("/responsive_table")
    public String responsive_table(){
        return "table/responsive_table"; //因为前面一层目录不是 templates
    }


    @GetMapping("/editable_table")
    public String editable_table(){
        return "table/editable_table"; //因为前面一层目录不是 templates
    }
}
