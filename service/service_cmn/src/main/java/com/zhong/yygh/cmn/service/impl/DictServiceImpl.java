package com.zhong.yygh.cmn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zhong.yygh.cmn.mapper.DictMapper;
import com.zhong.yygh.cmn.service.DictService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhong.yygh.model.cmn.Dict;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 组织架构表 服务实现类
 * </p>
 *
 * @author zhong
 * @since 2022-11-01
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {

    /**
    * @description :  根据 父id 查询下面的子元素
    * @param : Long pid
    * @return : List<Dict>
    * @date Created in 2022/11/1 15:36
    */
    @Override
    public List<Dict> getChildListByPid(Long pid) {
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<Dict>();
        queryWrapper.eq("parent_id",pid);
        List<Dict> dicts = baseMapper.selectList(queryWrapper);
        for (Dict dict : dicts) {
            dict.setHasChildren(isHasChildren(dict.getId()));
        }
        return dicts;
    }

    /**
    * @param :
    * @description : 判断是否还有下级元素
    */
    private boolean isHasChildren(Long pid){
        QueryWrapper<Dict> queryWrapper = new QueryWrapper<Dict>();
        queryWrapper.eq("parent_id",pid);
        Integer count = baseMapper.selectCount(queryWrapper);
        return count > 0;
    }
}
