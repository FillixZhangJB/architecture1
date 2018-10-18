package com.sishuok.architectrue1.storemgr.web;

import com.sishuok.architectrue1.storemgr.service.StoreService;
import com.sishuok.architectrue1.storemgr.vo.TblStore;
import com.sishuok.architecture1.common.utils.LeeJSONResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zjb on 2018/10/17.
 */
@RestController
@RequestMapping("/")
public class StoreController {

    @Autowired
    StoreService storeService;

    @RequestMapping(value = "insert", method = RequestMethod.POST)
    public LeeJSONResult insert(TblStore store) {
        return LeeJSONResult.ok(storeService.insert(store));
    }

    @RequestMapping(value = "delete", method = RequestMethod.GET)
    public LeeJSONResult delete(String pk) {
        return LeeJSONResult.ok(storeService.delete(pk));
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public LeeJSONResult update(TblStore store) {
        return LeeJSONResult.ok(storeService.updateWithVersion(store));
    }

    @RequestMapping(value = "selectByConditionPage", method = RequestMethod.GET)
    public LeeJSONResult selectByConditionPage(TblStore store, int pageNum, int pageSize) {
        return LeeJSONResult.ok(storeService.selectByConditionPage(store, pageNum, pageSize));
    }

}
