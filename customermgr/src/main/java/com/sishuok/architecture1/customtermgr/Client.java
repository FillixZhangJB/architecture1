package com.sishuok.architecture1.customtermgr;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.customtermgr.dao.CustomerMapper;
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
@Service
public class Client {
    @Autowired
    private CustomerMapper customerMapper;

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        Client client = (Client) ctx.getBean("client");
        CustomerModel customer = new CustomerModel();
        customer.setShowName("tt");
        client.customerMapper.insert(customer);
        PageHelper.startPage(1, 10);
        List<CustomerModel> customerModels = client.customerMapper.selectAll();
        PageInfo pageInfo = new PageInfo(customerModels);

//        CustomerQueryModel queryModel = new CustomerQueryModel();
//        queryModel.setShowName("jim");
    }
}
