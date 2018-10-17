package com.sishuok.architecture1.front;

import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.goodsmgr.service.GoodsService;
import com.sishuok.architecture1.goodsmgr.vo.TblGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/toIndex", method = RequestMethod.GET)
    public String toIndex(Model model) {
        TblGoods goods = new TblGoods();
        PageInfo<TblGoods> page = goodsService.selectByConditionPage(goods);
        model.addAttribute("page", page);
        return "index";
    }
}
