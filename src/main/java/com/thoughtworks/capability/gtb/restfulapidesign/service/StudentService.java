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
        studentEntity.setId(getMaxId());
        students.add(studentEntity);
        return studentEntity;
    }

    public void deleteStudent(Integer studentId) throws StudentException {
        List<StudentEntity> list = students.stream().filter(item -> item.getId() == studentId).collect(Collectors.toList());
        if (list.size() > 0) {
            students.remove(list.get(0));
        } else {
            throw new StudentException("student id did not exist");
        }
    }

    private Integer getMaxId() {
        if (students.size() == 0) return 0;
        Integer maxId = 0;
        for (StudentEntity student : students) {
            if (student.getId()>maxId)maxId = student.getId();
        }
        return maxId + 1;
    }

    public List<StudentEntity> getStudents(String gender) {
        if (gender == null) {
            return students;
        } else {
            return students.stream().filter(student -> student.getGender().equals(gender)).collect(Collectors.toList());
        }
    }

    public StudentEntity getStudentById(Integer id) throws StudentException {
        List<StudentEntity> list = students.stream().filter(item -> item.getId() == id).collect(Collectors.toList());
        if (list.size() > 0) {
            return list.get(0);
        } else {
            throw new StudentException("student id did not exist");
        }
    }

    public StudentEntity updateStudent(Integer id, StudentEntity studentEntity) throws StudentException {
        StudentEntity stu = getStudentById(id);
        students.remove(stu);
        stu.setGender(studentEntity.getGender());
        stu.setName(studentEntity.getName());
        stu.setNote(studentEntity.getNote());
        students.add(stu);
        return stu;
    }
}
