package com.swjtu.BydcServers.service;

import com.swjtu.BydcServers.entity.Account;

public interface IAccountService {
    /**
     * 注册
     * @param account
     */
    void register(Account account);


    Account login(Account account);
}
