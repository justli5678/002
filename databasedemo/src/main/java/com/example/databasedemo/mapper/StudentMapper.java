package com.example.databasedemo.mapper;
import com.example.databasedemo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper {
    public List<Student> findAllStudent();
    public List<Student> findStudentByno(int no);
    public List<Student> findStudentByname(String name);
    public int insertStudent(Student student);
    public int updateStudent(Student student);
    public int deleteStudent(Student student);
}


