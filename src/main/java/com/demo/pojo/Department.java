package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//部门
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private String id;
    private String departmentName;
}
