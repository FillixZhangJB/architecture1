package com.sishuok.architecture1.ordermgr.web;

import com.sishuok.architecture1.common.utils.LeeJSONResult;
import com.sishuok.architecture1.ordermgr.service.OrderService;
import com.sishuok.architecture1.ordermgr.vo.TblOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zjb on 2018/10/17.
 */
@RestController
@RequestMapping("/")
public class OrderController {

    @Autowired
    OrderService orderService;
    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public LeeJSONResult insert(TblOrder order) {
        return LeeJSONResult.ok(orderService.insert(order));
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public LeeJSONResult delete(String pk) {
        return LeeJSONResult.ok(orderService.delete(pk));
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public LeeJSONResult update(TblOrder order) {
        return LeeJSONResult.ok(orderService.updateWithVersion(order));
    }

    @RequestMapping(value = "selectByConditionPage", method = RequestMethod.GET)
    public LeeJSONResult selectByConditionPage(TblOrder order, int pageNum, int pageSize) {
        return LeeJSONResult.ok(orderService.selectByConditionPage(order, pageNum, pageSize));
    }

}
