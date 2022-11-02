package com.zhong.yygh.cmn.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.metadata.ReadSheet;

/**
 * @author : zhong
 * @Description :
 * @create : 2022/11/1-23:09
 */
public class EasyExcelReadDemo {

    // excel 多个个sheet读取
    public static void main(String[] args) {
        ExcelReader excelReader = EasyExcel.read("C:\\Users\\adc\\Desktop\\hello.xlsx").build();
        ReadSheet sheet1 = EasyExcel.readSheet(0).head(Student.class).registerReadListener(new StudentListener()).build();
        ReadSheet sheet2 = EasyExcel.readSheet(1).head(Student.class).registerReadListener(new StudentListener()).build();

        excelReader.read(sheet1,sheet2);
        excelReader.finish();

    }

//    // excel 单个sheet读取
//    public static void main(String[] args) {
//
//        EasyExcel.read("C:\\Users\\adc\\Desktop\\hello.xlsx",Student.class,new StudentListener()).sheet().doRead();
//
//    }


}
