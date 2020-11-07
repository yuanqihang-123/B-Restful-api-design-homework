package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.StudentEntity;
import org.apache.catalina.valves.StuckThreadDetectionValve;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {
    private List<StudentEntity> students = new LinkedList<>();

    public StudentEntity addStudent(StudentEntity studentEntity){
        studentEntity.setId(students.size());
        students.add(studentEntity);
        return studentEntity;
    }
}
