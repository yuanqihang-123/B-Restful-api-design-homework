package com.thoughtworks.capability.gtb.restfulapidesign.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentEntity {
    private Integer id;
    private String name;
    private String gender;
    private String note ;  //备注

}
