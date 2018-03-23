package com.swjtu.BydcServers.web.controller;

import com.google.gson.Gson;
import com.swjtu.BydcServers.entity.Account;
import com.swjtu.BydcServers.service.IAccountService;
import com.swjtu.BydcServers.util.JsonResult;
import com.swjtu.BydcServers.util.PageResult;
import com.swjtu.BydcServers.util.enums.StatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/account")
@ResponseBody
public class AccountController {
    @Resource
    private IAccountService accountService;

    @RequestMapping(value="/register", method = RequestMethod.POST)
    public JsonResult register(@RequestBody Account account) throws  Exception{
        System.out.println(account.getUsername());
        System.out.println(account.getPassword());
        System.out.println("注册信息：" + new Gson().toJson(account));
        accountService.register(account);
        return JsonResult.build(StatusCode.SUCCESS);
    }

    @RequestMapping(value="/login", method = RequestMethod.POST)
    public Account login(@RequestBody Account account) throws  Exception{
        System.out.println(account.getUsername());
        System.out.println(account.getPassword());
        Account acc = accountService.login(account);
        return acc;
    }

    @RequestMapping(value="/add", method = RequestMethod.POST)
    public JsonResult add(@RequestBody Account account) throws Exception{
        accountService.add(account);
        return JsonResult.build(StatusCode.SUCCESS);
    }

    @RequestMapping(value = "/deletes", method = RequestMethod.DELETE)
    public JsonResult deleteDepartment(@RequestBody Map map) {
        List uns =  (List)map.get("uns");
        accountService.delete(uns);
        return JsonResult.ok("");
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public JsonResult query(Integer pageNum, Integer pageSize){
        PageResult accounts = accountService.getByPage(pageNum, pageSize);
        return JsonResult.build(StatusCode.SUCCESS, accounts);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public JsonResult update(@RequestBody Account account){
        accountService.updateByUn(account);
        return JsonResult.build(StatusCode.SUCCESS);
    }
}
