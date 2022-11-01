package com.zhong.yygh.cmn.excel;

import com.alibaba.excel.EasyExcel;

/**
 * @author : zhong
 * @Description :
 * @create : 2022/11/1-23:09
 */
public class EasyExcelReadDemo {

    // excel 读取
    public static void main(String[] args) {

        EasyExcel.read("C:\\Users\\adc\\Desktop\\hello.xlsx",Student.class,new StudentListener()).sheet().doRead();

    }
}
