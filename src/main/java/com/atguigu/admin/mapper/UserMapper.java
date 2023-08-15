package com.atguigu.admin.mapper;

import com.atguigu.admin.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

public interface UserMapper extends BaseMapper<User> {
    //继承BaseMapper<> 即可获取其所有泛型方法 , 里面有很多配好的接口 有简单的crud和分页
}
