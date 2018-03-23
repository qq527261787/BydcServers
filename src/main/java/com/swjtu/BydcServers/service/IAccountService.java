package com.swjtu.BydcServers.service;

import com.swjtu.BydcServers.entity.Account;
import com.swjtu.BydcServers.util.PageResult;

import java.util.List;

public interface IAccountService {
    /**
     * 注册
     * @param account
     */
    void register(Account account);

    /**
     * 登录
     * @param account
     * @return
     */
    Account login(Account account);

    /**
     * 添加
     * @param account
     */
    void add(Account account);

    /**
     * 根据用户名列表删除用户
     * @param uns
     */
    void delete(List uns);

    /**
     * 根据用户名获取用户信息
     * @param username
     * @return
     */
    Account getByUn(String username);

    /**
     * 分页获取
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageResult getByPage(Integer pageNum, Integer pageSize);

    /**
     * 根据用户名更新用户信息
     * @param account
     */
    void updateByUn(Account account);
}
