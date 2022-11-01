package com.zhong.yygh.cmn.excel;

import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : zhong
 * @Description :
 * @create : 2022/11/1-22:23
 */
public class ExcelWriteDemo {
    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student(1,"卡卡西",22,true));
        students.add(new Student(2,"我爱罗",23,true));
        students.add(new Student(3,"大蛇丸",24,true));
        students.add(new Student(4,"一打及",25,true));

        EasyExcel.write("C:\\Users\\adc\\Desktop\\hello.xlsx",Student.class).sheet("学生列表").doWrite(students);

    }
}
