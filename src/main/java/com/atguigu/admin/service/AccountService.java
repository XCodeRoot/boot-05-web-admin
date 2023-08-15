package com.atguigu.admin.service;

import com.atguigu.admin.bean.Account;
import com.atguigu.admin.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AccountService {

    @Autowired
    AccountMapper accountMapper;//爆红不用管 , 可以正常编译的



    public Account getAcctById(Long id){
        return accountMapper.getAcct(id);
    }

}
