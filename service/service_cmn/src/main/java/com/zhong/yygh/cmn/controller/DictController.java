package com.zhong.yygh.cmn.controller;


import com.zhong.yygh.cmn.service.DictService;
import com.zhong.yygh.common.result.R;
import com.zhong.yygh.model.cmn.Dict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 组织架构表 前端控制器
 * </p>
 *
 * @author zhong
 * @since 2022-11-01
 */
@RestController
@RequestMapping("/admin/cmn")
public class DictController {

    @Autowired
    private DictService dictService;

    @GetMapping("/childList/{pid}")
    public R getChildListByPid(@PathVariable Long pid){
        List<Dict> list = dictService.getChildListByPid(pid);
        return R.ok().data("items",list);
    }


}



