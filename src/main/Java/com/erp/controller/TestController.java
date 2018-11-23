package com.erp.controller;

import com.erp.pojo.Customer;
import com.erp.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class TestController {
    private static final Logger log = LoggerFactory.getLogger(TestController.class);
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/Login")
    public String Login(HttpServletRequest request) {
        Customer customer = new Customer();
        //返回目标Jsp前缀
        String directJsp = null;
        customer.setPassword(request.getParameter("password"));
        customer.setCardNo(request.getParameter("cardNo"));
        log.info("账号:{}，密码:{}", customer.getCardNo(), customer.getPassword());
        try {
            String status = customerService.Login(customer);
            log.info("返回登录状态：{}", status);
            if (status.equals("true")) {
                directJsp = "Customer/loginSuccess";
            } else {
                directJsp = "Customer/error";
            }
        } catch (Exception e) {
            log.info("系统异常：", e);
        }
        return directJsp;
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
