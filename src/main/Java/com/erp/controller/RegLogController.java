package com.erp.controller;

import com.erp.pojo.Customer;
import com.erp.service.CustomerService;
import jdk.nashorn.internal.ir.annotations.Immutable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
     **/
    @RequestMapping(value = "/Login", method = RequestMethod.POST)
    public String Login(HttpServletRequest request, HttpSession session, Model model) {
        Customer customer = new Customer();
        String directJsp = null;
        //返回目标Jsp前缀
        customer.setPassword(request.getParameter("password"));
        customer.setCardNo(request.getParameter("cardNo"));
        log.info("账号:{}，密码:{}", customer.getCardNo(), customer.getPassword());
        try {
            String status = customerService.Login(customer);
            log.info("返回登录状态：{}", status);
            if (status.equals("true")) {
                session.setAttribute("username", customer.getCardNo());
                directJsp = "forward:toLoginSuccess";
            } else {
                model.addAttribute("msg", "登录失败");
                directJsp = "forward:toIndex";
            }
        } catch (Exception e) {
            log.info("系统异常：", e);
        }
        return directJsp;
    }

    /**
     * 用户注册
     **/
    @RequestMapping(value = "/Register", method = RequestMethod.POST)
    public @ResponseBody
    Map<String, Object> Register(@RequestBody Customer customer) {
        log.info("{}", customer.toString());
        String resultCard = customerService.Register(customer);
        log.info("{}", resultCard);
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("msg", resultCard);
        log.info("{}", resultMap);
        return resultMap;
    }

    /**
     * 登录成功跳转
     **/
    @RequestMapping(value = "toLoginSuccess")
    public String toLoginSuccess() {
        return "Customer/loginSuccess";
    }

    /**
     * 返回首页
     **/
    @RequestMapping(value = "toIndex")
    public String toIndex() {
        return "welcome/index";
    }

    @RequestMapping(value = "toError")
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
