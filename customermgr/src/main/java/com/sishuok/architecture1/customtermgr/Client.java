package com.sishuok.architecture1.customtermgr;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.customtermgr.dao.CustomerMapper;
import com.sishuok.architecture1.customtermgr.service.CustomerService;
import com.sishuok.architecture1.customtermgr.vo.CustomerModel;
import com.sishuok.architecture1.customtermgr.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zjb on 2018/9/26.
 */
//@Service
public class Client {
    @Autowired
    private CustomerService customerService;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Client client = (Client) ctx.getBean("client");
        CustomerModel customer = new CustomerModel();
        customer.setShowName("tt");
        client.customerService.insert(customer);
        PageInfo<CustomerModel> pageInfo = client.customerService.selectAllByPage(1, 2);
    }
}
