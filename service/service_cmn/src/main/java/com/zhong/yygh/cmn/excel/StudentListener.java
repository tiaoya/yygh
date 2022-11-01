package com.zhong.yygh.cmn.excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author : zhong
 * @Description :
 * @create : 2022/11/1-23:11
 */
public class StudentListener extends AnalysisEventListener<Student> {

    private static final int BATCH_COUNT = 5;

    List<Student> list = new ArrayList<>();


    // 每解析excel 文件中的一行数据,都会调用一次 invoke 方法
    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
//        System.out.println(student);
        // 批量插入数据
//        list.add(student);
//        if (list.size() >= BATCH_COUNT){
//            baseMapper.batchInsert(list);
//            list.clear();
//        }

    }

    // 当解析 excel 文件某个 sheet 的标题的时候
    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("标题为:"+headMap);
    }

    // 当 excel 文件被解析完毕之后,走这个方法,收尾工作, 关闭连接
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

        // 为了防止列表里还有遗留的数据没有插入
//        baseMapper.batchInsert(list);

    }
}
