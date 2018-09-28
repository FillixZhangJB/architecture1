package com.sishuok.architecture1.customtermgr.web;

import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.common.utils.LeeJSONResult;
import com.sishuok.architecture1.customtermgr.service.CustomerService;
import com.sishuok.architecture1.customtermgr.vo.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zjb on 2018/9/28.
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/selectAllByPage", method = RequestMethod.GET)
    @ResponseBody
    public LeeJSONResult selectById(int pageNum, int pageSize) {
        PageInfo<CustomerModel> pageInfo = customerService.selectAllByPage(pageNum, pageSize);
        return LeeJSONResult.ok(pageInfo);
    }
}
