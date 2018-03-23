package com.swjtu.BydcServers.service.impl;

import com.swjtu.BydcServers.entity.Account;
import com.swjtu.BydcServers.entity.AccountExample;
import com.swjtu.BydcServers.mapper.AccountMapper;
import com.swjtu.BydcServers.service.IAccountService;
import com.swjtu.BydcServers.web.exception.base.CustomException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService{

    @Resource
    private AccountMapper accountMapper;

    /**
     * 注册
     * @param account
     */
    public void register(Account account) {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andUsernameEqualTo(account.getUsername());
        List<Account> list = new ArrayList<Account>();
        list = accountMapper.selectByExample(accountExample);
        //账号存在
        if(list.size() != 0){
            throw new CustomException("账号已经存在");
        }
        accountMapper.insert(account);
    }

    /**
     * 登录
     * @param account
     * @return 登录用户信息
     */
    public Account login(Account account) {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andUsernameEqualTo(account.getUsername());
        List<Account> list = new ArrayList<Account>();
        list = accountMapper.selectByExample(accountExample);
        //账号不存在
        if(list.size() == 0){
            throw new CustomException("用户名不正确");
        }
        //密码不正确
        Account res = list.get(0);
        if(!res.getPassword().equals(account.getPassword())){
            throw new CustomException("密码错误");
        }
        return res;
    }
}
