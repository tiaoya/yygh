package com.zhong.yygh.hosp.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhong.yygh.common.result.R;
import com.zhong.yygh.common.utils.MD5;
import com.zhong.yygh.hosp.service.HospitalSetService;
import com.zhong.yygh.model.hosp.HospitalSet;
import com.zhong.yygh.vo.hosp.HospitalQueryVo;
import com.zhong.yygh.vo.hosp.HospitalSetQueryVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

/**
 * <p>
 * 医院设置表 前端控制器
 * </p>
 *
 * @author zhong
 * @since 2022-10-17
 *
 *
 */
@RestController
@Api(tags = "医院设置信息") // 对当前全部接口的说明
@RequestMapping("/admin/hosp/hospitalSet")
@Slf4j
@CrossOrigin
public class HospitalSetController {

    /*
     * @Api(tags=""): 标记在接口类
     * @ApiOperation(value=""):标记在方法上
     * @ApiParam(value =""): 标记在参数上
     *
     * @ApiModel(description=""): 对POJO类做说明
     * @ApiModelProperty(value =""): 对POJO类属性做说明
     * */

    @Autowired
    private HospitalSetService hospitalSetService;



    @ApiOperation(value = "查询所有的医院设置信息") // 对当前接口的说明
    @GetMapping("/findAll")
    public R findAll(){
        List<HospitalSet> list = hospitalSetService.list();
        return R.ok().data("item",list);
    }

    // 根据医院设置id删除医院设置信息
    @ApiOperation(value = "根据医院设置id删除医院设置信息")
    @DeleteMapping(value = "/deleteById/{id}") // @ApiParam 对参数的说明信息
    public R deleteById(@ApiParam(name = "id",value = "医院设置id",required = true) @PathVariable Integer id){
        hospitalSetService.removeById(id);
        return R.ok();
    }

    /**
    * @param :
    * @description : 带查询条件的分页插件
    */
    @ApiOperation(value="带查询条件的分页插件")
    @PostMapping(value = "/page/{pageNum}/{size}")
    public R getPageInfo(@ApiParam(name = "pageNum",value = "当前页") @PathVariable Integer pageNum,
                         @ApiParam(name = "size",value = "每页显示多少条") @PathVariable Integer size,
                         @RequestBody HospitalSetQueryVo hospitalSetQueryVo){

        // 从 这里面HospitalSet 查表
        Page<HospitalSet> page = new Page<HospitalSet>(pageNum,size);

        QueryWrapper<HospitalSet> queryWrapper = new QueryWrapper<>();

        if (!StringUtils.isEmpty(hospitalSetQueryVo.getHosname())){
            queryWrapper.like("hosname",hospitalSetQueryVo.getHosname());
        }

        if (!StringUtils.isEmpty(hospitalSetQueryVo.getHoscode())){
            queryWrapper.eq("hoscode",hospitalSetQueryVo.getHoscode());
        }

        hospitalSetService.page(page,queryWrapper);
        return R.ok().data("total",page.getTotal()).data("rows",page.getRecords());
    }

    /**
    * @param :
    * @description : 新增医院设置
    */
    @ApiOperation(value = "新增医院设置")
    @PostMapping("/save")
    public R save(@RequestBody HospitalSet hospitalSet){
        // 设置状态 1 使用, 0 不能使用
        hospitalSet.setStatus(1);

        // 当前时间戳+随机数+MD5加密
        Random random =new Random();
        String encrypt = MD5.encrypt(System.currentTimeMillis() + "" + random.nextInt(1000));
        //签名秘钥
        hospitalSet.setSignKey(encrypt);

        hospitalSetService.save(hospitalSet);

        return R.ok();
    }


    /**
    * @param :
    * @description : 修改之回显数据
    */
    @GetMapping("/detail/{id}")
    public R detail(@PathVariable Integer id){
        HospitalSet hospitalSet = hospitalSetService.getById(id);
        return R.ok().data("item",hospitalSet);
    }

    /**
    * @param :
    * @description : 修改数据
    */
    @PutMapping("/update")
    public R update(@RequestBody HospitalSet hospitalSet){
        hospitalSetService.updateById(hospitalSet);
        return R.ok();
    }

    /**
    * @param :
    * @description : 批量删除
    */
    @DeleteMapping("/delete")
    public R batchDelete(@RequestBody List<Integer> ids){
        hospitalSetService.removeByIds(ids);
        return R.ok();
    }

    /**
    * @param :
    * @description : 锁定与解锁
    */
    @PutMapping("/status/{id}/{status}")
    public R updateStatus(@PathVariable Long id,@PathVariable Integer status){
        log.info("current thread is "+Thread.currentThread().getId()+",params:id="+id);
        HospitalSet hospitalSet = new HospitalSet();
        hospitalSet.setId(id);
        hospitalSet.setStatus(status);
        hospitalSetService.updateById(hospitalSet);
        log.info("result"+Thread.currentThread().getId()+hospitalSet.toString());

        return R.ok();
    }



}

