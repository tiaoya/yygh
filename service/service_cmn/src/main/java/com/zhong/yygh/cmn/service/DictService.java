package com.zhong.yygh.cmn.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zhong.yygh.model.cmn.Dict;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * <p>
 * 组织架构表 服务类
 * </p>
 *
 * @author zhong
 * @since 2022-11-01
 */
public interface DictService extends IService<Dict> {

    List<Dict> getChildListByPid(Long pid);

    void download(HttpServletResponse response) throws IOException;
}
