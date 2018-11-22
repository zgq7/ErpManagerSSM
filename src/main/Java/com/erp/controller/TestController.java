package com.erp.controller;

import com.erp.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
    private CustomerService customerService;

    @RequestMapping(value = "/Login")
    public String Login() {
        boolean bool = customerService.Login("666666","666666");
        System.out.println(bool);
        return "loginSuccess";
    }

    @RequestMapping(value = "/toTest01")
    public String toTest01() {
        return "test01";
    }

    @RequestMapping(value = "/toTest02")
    public String toTest02() {
        return "test02";
    }

    @RequestMapping(value = "/toTest03")
    public String toTest03() {
        return "test03";
    }
}
