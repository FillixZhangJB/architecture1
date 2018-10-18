package com.sishuok.architecture1.front;

import com.sishuok.architecture1.customtermgr.service.CustomerService;
import com.sishuok.architecture1.customtermgr.vo.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by zjb on 2018/10/13.
 */
@Controller
@RequestMapping(value = "/")
public class LoginController {

    @Autowired
    CustomerService customerService;


    @RequestMapping(value = "toLogin", method = RequestMethod.GET)
    public String toLogin() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String customerId, String pwd, HttpServletResponse response) {
        if (customerId == null || customerId.trim().length() == 0) {
            return "login";
        }
        CustomerModel customerModel = this.customerService.selectByCustomerId(customerId);
        if (customerModel == null || !customerModel.getPwd().equals(pwd)) {
            return "login";
        }
        Cookie cookie = new Cookie("MyLogin", customerModel.getUuId() + "," + System.currentTimeMillis());
        response.addCookie(cookie);
        return "redirect:toIndex";
    }

}
