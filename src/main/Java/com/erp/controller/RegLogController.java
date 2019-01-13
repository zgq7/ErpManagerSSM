package com.erp.controller;

import com.erp.pojo.Customer;
import com.erp.service.CustomerService;
import com.sun.org.apache.regexp.internal.RE;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RegLogController {
    private static final Logger log = LoggerFactory.getLogger(RegLogController.class);
    @Autowired
    private CustomerService customerService;

    /**
     * 用户登录
     * @param  request 传值
     **/
    @RequestMapping(value = "/Login",method = RequestMethod.POST)
    public String Login(HttpServletRequest request) {
        String cardNo= request.getParameter("cardNo");
        String password = request.getParameter("password");
        log.info("账号:{}，密码:{}", cardNo, password);
        //subject 指和shiro交互的所有用户
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(cardNo,password);
        try {
            subject.login(token);
        }catch (AuthenticationException e){
            log.info("{}",e);
            return "error";
        }
        return "forward:/toLoginSuccess";
    }

    /**
     * 用户注册
     * 使用ajax传一个customer对象然后返回注册信息
     **/
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> Register(@RequestBody Customer customer) {
        Map<String, Object> resultMap = new HashMap<>();
        log.info("{}", customer.toString());
        if (customerService.checkRegInfo(customer.getCardNo()) == 0) {
            String resultCard = customerService.Register(customer);
            log.info("{}", resultCard);
            resultMap.put("msg", "用户" + resultCard + "注册成功");
            log.info("{}", resultMap);
        } else {
            resultMap.put("msg",  "该账号已被注册，注册失败");
        }
        return resultMap;
    }

    /**
     * 登录成功跳转
     **/
    @RequestMapping(value = "/toLoginSuccess")
    public String toLoginSuccess() {
        return "Customer/loginSuccess";
    }

    /**
     * 返回首页
     **/
    @RequestMapping(value = "/toIndex")
    public String toIndex() {
        return "welcome/index";
    }

    @RequestMapping(value = "/toError")
    public String toError() {
        return "error";
    }

    @RequestMapping("/getAllCustomer")
    public String getAllCustomer() {
        try {
            List<Customer> c = customerService.CatchAllCustomer();
            log.info("{}", c.toString());
        } catch (Exception e) {
            log.info("系统异常：", e);
        }
        return "CatchAllCustomer";
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
