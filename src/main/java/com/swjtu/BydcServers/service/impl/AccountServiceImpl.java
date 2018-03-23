package com.swjtu.BydcServers.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.swjtu.BydcServers.entity.Account;
import com.swjtu.BydcServers.entity.AccountExample;
import com.swjtu.BydcServers.mapper.AccountMapper;
import com.swjtu.BydcServers.mapper.AccountMapperCustom;
import com.swjtu.BydcServers.service.IAccountService;
import com.swjtu.BydcServers.util.PageResult;
import com.swjtu.BydcServers.web.exception.base.CustomException;
import com.swjtu.BydcServers.web.exception.base.ReqParmIncorException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements IAccountService{

    @Resource
    private AccountMapper accountMapper;

    @Resource
    private AccountMapperCustom accountMapperCustom;

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
    public Account login(Account account) throws CustomException{
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

    /**
     * 添加用户
     * @param account
     * @throws Exception
     */
    public void add(Account account) throws CustomException{
        if(account.getName() == null || account.getPassword() ==null || account.getUsername() == null || account.getEmail() == null)
            throw new ReqParmIncorException();
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andUsernameEqualTo(account.getUsername());
        if(accountMapper.selectByExample(accountExample).size() != 0){
            throw new CustomException("该用户名已经存在");
        }else {
            accountMapper.insert(account);
        }
    }

    /**
     * 多项删除
     * @param uns 用户username列表
     */
    public void delete(List uns) {
        for(int i = 0 ;  i < uns.size(); i++){
            AccountExample accountExample = new AccountExample();
            accountExample.createCriteria().andUsernameEqualTo(uns.get(i).toString());
            accountMapper.deleteByExample(accountExample);
        }
    }

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    public Account getByUn(String username) throws CustomException{
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andUsernameEqualTo(username);
        accountMapper.selectByExample(accountExample);
        List<Account> list = new ArrayList<Account>();
        list = accountMapper.selectByExample(accountExample);
        //账号不存在
        if(list.size() == 0){
            throw new CustomException("该用户不存在");
        }
        return list.get(0);
    }

    /**
     * 分页查询用户信息
     * @param pageNum
     * @param pageSize
     * @return PageResult 信息数组和信息的总条数
     */
    public PageResult getByPage(Integer pageNum, Integer pageSize) throws CustomException{
        if(pageNum == null || pageSize == null)
            throw  new CustomException("参数缺失");
        PageHelper.startPage(pageNum, pageSize);
        List<Account> accounts = accountMapperCustom.query();
        PageInfo<Account> pageInfo = new PageInfo<Account>(accounts);
        PageResult pageResult = new PageResult();
        pageResult.setRows(accounts);
        pageResult.setTotal(pageInfo.getTotal());
        return pageResult;
    }

    /**
     * 根据用户名更新用户信息
     * @param account
     */
    public void updateByUn(Account account) {
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andUsernameEqualTo(account.getUsername());
        accountMapper.updateByExample(account, accountExample);
    }
}
