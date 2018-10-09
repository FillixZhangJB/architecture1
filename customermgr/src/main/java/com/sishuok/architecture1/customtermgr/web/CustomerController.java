package com.sishuok.architecture1.customtermgr.web;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.common.utils.LeeJSONResult;
import com.sishuok.architecture1.customtermgr.service.CustomerService;
import com.sishuok.architecture1.customtermgr.vo.CustomerModel;
import com.sishuok.architecture1.customtermgr.vo.CustomerQueryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "customer/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("cm") CustomerModel cm) {
        cm.setRegisterTime(Long.toString(System.currentTimeMillis()));
        customerService.insert(cm);
        return "customer/success";
    }

    @RequestMapping(value = "toUpdate/{customerUuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("customerUuid") String customerUuid) {
        CustomerModel cm = customerService.selectByPk(customerUuid);
        model.addAttribute("cm", cm);
        return "customer/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String post(@ModelAttribute("cm") CustomerModel cm) {
        customerService.updateWithVersion(cm);
        return "customer/success";
    }

    @RequestMapping(value = "toDelete/{customerUuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("customerUuid") String customerUuid) {
        CustomerModel cm = customerService.selectByPk(customerUuid);
        model.addAttribute("cm", cm);
        return "customer/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String post(@RequestParam("uuId") String customerUuid) {
        customerService.delete(customerUuid);
        return "customer/success";
    }

    @RequestMapping(value = "toList", method = RequestMethod.GET)
    public String toList(String queryJsonStr, Model model) {
        CustomerQueryModel customerQueryModel = null;
        if (queryJsonStr == null || queryJsonStr.trim().length() == 0) {
            return null;
        } else {
            customerQueryModel = JSON.parseObject(queryJsonStr, CustomerQueryModel.class);
        }
        PageInfo<CustomerQueryModel> customerQueryModelPageInfo = customerService.selectByConditionPage(customerQueryModel);
//        model.addAttribute("wm", customerQuery ModelPageInfo);
        model.addAttribute("page", customerQueryModelPageInfo);
        return "customer/list";
    }

    @RequestMapping(value = "toQuery", method = RequestMethod.GET)
    public String toQuery() {
        return "customer/query";
    }
}
