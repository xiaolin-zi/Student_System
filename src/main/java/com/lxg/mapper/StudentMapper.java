package com.lxg.mapper;

import com.lxg.pojo.Student;
import java.util.List;

public interface StudentMapper {




    int deleteBySno(String sno);

    int insert(Student record);


    Student selectBySno(String sno);


    List<Student> selectAll();


    int updateBySno(Student record);
}