package com.thoughtworks.capability.gtb.restfulapidesign.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeamEntity {
    private Integer id;  // 组号
    private String name;  // 组名
    private String note;  // 备注
    private List<StudentEntity> students;  //学生集合
}
