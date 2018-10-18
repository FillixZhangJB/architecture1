package com.sishuok.architecture1.front;

import com.github.pagehelper.PageInfo;
import com.sishuok.architectrue1.storemgr.service.StoreService;
import com.sishuok.architecture1.cartmgr.service.CartService;
import com.sishuok.architecture1.cartmgr.vo.TblCart;
import com.sishuok.architecture1.goodsmgr.service.GoodsService;
import com.sishuok.architecture1.goodsmgr.vo.TblGoods;
import com.sishuok.architecture1.ordermgr.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zjb on 2018/10/15.
 */
@Controller
@RequestMapping(value = "/")
public class IndexController {

    @Autowired
    GoodsService goodsService;
    @Autowired
    CartService cartService;
    @Autowired
    StoreService storeService;
    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/toIndex", method = RequestMethod.GET)
    public String toIndex(Model model) {
        TblGoods goods = new TblGoods();
        PageInfo<TblGoods> page = goodsService.selectByConditionPage(goods);
        model.addAttribute("page", page);
        return "index";
    }

    @RequestMapping(value = "/toGoodsDesc/{goodsUuid}", method = RequestMethod.GET)
    public String toGoodsDesc(Model model, @PathVariable("goodsUuid") String goodsUuid) {
        TblGoods goods = goodsService.selectByPk(goodsUuid);

        model.addAttribute("m", goods);
        return "goods/desc";
    }

    @RequestMapping(value = "toCart", method = RequestMethod.GET)
    public String toCart(Model model, @CookieValue("MyLogin") String myLogin) {
        String customerUuid = myLogin.split(",")[0];
        TblCart cart = new TblCart();
        cart.setCustomerUuid(customerUuid);
        PageInfo<TblCart> tblCartPageInfo = cartService.selectByConditionPage(cart, 1, 20);

        model.addAttribute("page", tblCartPageInfo);

        return "cart/myCart";
    }

    @RequestMapping(value = "/addToCart/{goodsUuid}", method = RequestMethod.GET)
    public String addToCart(Model model, @PathVariable("goodsUuid") String goodsUuid, @CookieValue("MyLogin") String myLogin) {
        String customerUuid = myLogin.split(",")[0];
        TblCart cart = new TblCart();
        cart.setBuyNum(1);
        cart.setCustomerUuid(customerUuid);
        cart.setGoodsUuid(goodsUuid);
        cartService.insert(cart);

        TblCart cartQuery = new TblCart();
        cartQuery.setCustomerUuid(customerUuid);
        PageInfo<TblCart> tblCartPageInfo = cartService.selectByConditionPage(cartQuery, 1, 20);
        model.addAttribute("page", tblCartPageInfo);

        return "cart/myCart";
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    public String order(@CookieValue("MyLogin") String myLogin) {
        //1:查出这个人购物车所有的信息
        String customerUuid = myLogin.split(",")[0];

        TblCart cartQuery = new TblCart();
        cartQuery.setCustomerUuid(customerUuid);
        PageInfo<TblCart> tblCartPageInfo = cartService.selectByConditionPage(cartQuery, 1, 20);
        orderService.order(customerUuid,tblCartPageInfo.getList());

        return "success";
    }
}
