package com.sishuok.architecture1.goodsmgrweb;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;
import com.sishuok.architecture1.common.utils.LeeJSONResult;
import com.sishuok.architecture1.goodsmgr.service.GoodsService;
import com.sishuok.architecture1.goodsmgr.vo.TblGoods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zjb on 2018/9/28.
 */
@Controller
@RequestMapping(value = "/")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/selectByConditionPage", method = RequestMethod.GET)
    @ResponseBody
    public LeeJSONResult selectByConditionPage() {
        PageInfo<TblGoods> pageInfo = goodsService.selectByConditionPage(new TblGoods());
        return LeeJSONResult.ok(pageInfo);
    }

    @RequestMapping(value = "toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "goods/add";
    }

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public String add(@ModelAttribute("goods") TblGoods goods) {
        goodsService.insert(goods);
        return "goods/success";
    }

    @RequestMapping(value = "toUpdate/{goodsUuid}", method = RequestMethod.GET)
    public String toUpdate(Model model, @PathVariable("goodsUuid") String goodsUuid) {
        TblGoods goods = goodsService.selectByPk(goodsUuid);
        model.addAttribute("goods", goods);
        return "goods/update";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String post(@ModelAttribute("cm") TblGoods goods) {
        goodsService.update(goods);
        return "goods/success";
    }

    @RequestMapping(value = "toDelete/{goodsUuid}", method = RequestMethod.GET)
    public String toDelete(Model model, @PathVariable("goodsUuid") String goodsUuid) {
        TblGoods goods = goodsService.selectByPk(goodsUuid);
        model.addAttribute("goods", goods);
        return "goods/delete";
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    public String post(@RequestParam("uuId") String goodsUuId) {
        goodsService.delete(goodsUuId);
        return "goods/success";
    }

    @RequestMapping(value = "toQuery", method = RequestMethod.GET)
    public String toQuery() {
        return "goods/query";
    }

    @RequestMapping(value = "toList", method = RequestMethod.GET)
    public String toList(String queryJsonStr, Model model) {
        TblGoods goods = null;
        if (queryJsonStr == null || queryJsonStr.trim().length() == 0) {
            return null;
        } else {
            goods = JSON.parseObject(queryJsonStr, TblGoods.class);
        }
        PageInfo<TblGoods> goodsPageInfo = goodsService.selectByConditionPage(goods);
//        model.addAttribute("wm", customerQuery ModelPageInfo);
        model.addAttribute("page", goodsPageInfo);
        return "goods/list";
    }
}
