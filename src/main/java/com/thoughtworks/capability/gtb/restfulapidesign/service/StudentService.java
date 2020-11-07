package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.entity.StudentEntity;
import com.thoughtworks.capability.gtb.restfulapidesign.exception.StudentException;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {
    private List<StudentEntity> students = new LinkedList<>();

    public StudentEntity addStudent(StudentEntity studentEntity) {
        studentEntity.setId(getIdFormList());
        students.add(studentEntity);
        return studentEntity;
    }

    public void deleteStudent(Integer studentId) throws StudentException {
        List<StudentEntity> list = students.stream().filter(item -> item.getId() == studentId).collect(Collectors.toList());
        if (list.size() > 0) {
            students.remove(list.get(0));
        } else {
            throw new StudentException("student id did not exsit");
        }
    }

    private Integer getIdFormList() {
        return students.size() > 0 ? students.get(students.size() - 1).getId() + 1 : 0;
    }

    public List<StudentEntity> getStudents(String gender) {
        if (gender == null) {
            return students;
        } else {
            return students.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
        }
    }
}
