package com.zhong.yygh.cmn.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhong
 * @Description :
 * @create : 2022/11/1-22:23
 */
public class ExcelWriteDemo {

    // 方法二: 往多个sheet中写数据
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1,"卡卡西",22,true));
        students.add(new Student(2,"我爱罗",23,true));
        students.add(new Student(3,"大蛇丸",24,true));
        students.add(new Student(4,"一打及",25,true));

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1,"名侦探",27,true));
        studentList.add(new Student(2,"福尔摩斯",28,false));


        ExcelWriter excelWriter = EasyExcel.write("C:\\Users\\adc\\Desktop\\hello.xlsx", Student.class).build();
        // 增加sheet
        WriteSheet sheet1 = EasyExcel.writerSheet(0,"学生列表1").build();
        WriteSheet sheet2 = EasyExcel.writerSheet(1,"学生列表2").build();
        excelWriter.write(students,sheet1);
        excelWriter.write(studentList,sheet2);

        // 关闭
        excelWriter.finish();


    }

    // 方法一: 往单个sheet中写数据
//    public static void main(String[] args) {
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(1,"卡卡西",22,true));
//        students.add(new Student(2,"我爱罗",23,true));
//        students.add(new Student(3,"大蛇丸",24,true));
//        students.add(new Student(4,"一打及",25,true));
//
//        EasyExcel.write("C:\\Users\\adc\\Desktop\\hello.xlsx",Student.class).sheet("学生列表").doWrite(students);
//
//    }
}
