package com.zhong.yygh.cmn.controller;


import com.alibaba.excel.EasyExcel;
import com.zhong.yygh.cmn.excel.StudentListener;
import com.zhong.yygh.cmn.service.DictService;
import com.zhong.yygh.common.result.R;
import com.zhong.yygh.model.cmn.Dict;
import com.zhong.yygh.vo.cmn.DictEeVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
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
@CrossOrigin
public class DictController {

    @Autowired
    private DictService dictService;

    @PostMapping("/upload")
    public R upload(MultipartFile file) throws IOException {
        dictService.upload(file);
        return R.ok();
    }


    @GetMapping("/download")
    public void download(HttpServletResponse response) throws IOException {

        dictService.download(response);
    }

    @GetMapping("/childList/{pid}")
    public R getChildListByPid(@PathVariable Long pid){
        List<Dict> list = dictService.getChildListByPid(pid);
        return R.ok().data("items",list);
    }


}



