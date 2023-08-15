package com.atguigu.admin.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }


    /** 文件上传控制器方法 , 匹配请求然后接收表单的请求参数
     *  MultipartFile会自动封装上传来的文件
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(
            @RequestParam("email")String email,
            @RequestParam("username")String username,
            @RequestParam("headerImg") MultipartFile headerImg,
            @RequestParam("photos") MultipartFile[] photos
    ) throws IOException {

        log.info("上传的信息: email={},username={},headerImg大小={},photo数量={}"
                ,email,username,headerImg.getSize(),photos.length);
        //email=1045547784@qq.com,username=txj123,headerImg大小=837510,photo数量=2

        if(!headerImg.isEmpty()){
            //拿到原始文件名 , 包含后缀
            String originalFilename = headerImg.getOriginalFilename();
            //使用封装好的transferTo方法 , 传入文件存放目录和原始文件名即可保存在磁盘里
            headerImg.transferTo(new File("D:\\SoftWare\\photos\\"+originalFilename));
        }
        if(photos.length>0){
            for (MultipartFile photo : photos) {
                if(!photo.isEmpty()){
                    String originalFilenames = photo.getOriginalFilename();
                    photo.transferTo(new File("D:\\SoftWare\\photos\\"+originalFilenames));
                }
            }
        }


        return "main";
    }
}
