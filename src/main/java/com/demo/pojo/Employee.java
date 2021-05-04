package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

//员工
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private String id;
    private String lastName;
    private String email;
    private String gender;
    private String department;
    private String birth;

}
