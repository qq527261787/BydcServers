package com.swjtu.BydcServers.web.controller;

import com.google.gson.Gson;
import com.swjtu.BydcServers.entity.Account;
import com.swjtu.BydcServers.service.IAccountService;
import com.swjtu.BydcServers.util.JsonResult;
import com.swjtu.BydcServers.util.enums.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
@RequestMapping("account")
@ResponseBody
public class AccountController {
    @Resource
    private IAccountService accountService;

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public JsonResult register(@RequestBody Account account) throws  Exception{
        System.out.println("注册信息：" + new Gson().toJson(account));
        accountService.register(account);
        return JsonResult.build(StatusCode.SUCCESS);
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public Account login(@RequestBody Account account) throws  Exception{
        Account acc = accountService.login(account);
        return acc;
    }
}
