package com.sishuok.architecture1.cartmgr.web;

import com.sishuok.architecture1.cartmgr.service.CartService;
import com.sishuok.architecture1.cartmgr.vo.TblCart;
import com.sishuok.architecture1.common.utils.LeeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zjb on 2018/10/17.
 */
@RestController
@RequestMapping("/")
public class CartController {

    @Autowired
    CartService cartService;

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public LeeJSONResult insert(TblCart cart) {
        return LeeJSONResult.ok(cartService.insert(cart));
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public LeeJSONResult delete(String pk) {
        return LeeJSONResult.ok(cartService.delete(pk));
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public LeeJSONResult update(TblCart cart) {
        return LeeJSONResult.ok(cartService.updateWithVersion(cart));
    }

    @RequestMapping(value = "selectByConditionPage", method = RequestMethod.GET)
    public LeeJSONResult selectByConditionPage(TblCart cart, int pageNum, int pageSize) {
        return LeeJSONResult.ok(cartService.selectByConditionPage(cart, pageNum, pageSize));
    }

}
