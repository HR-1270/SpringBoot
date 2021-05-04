package com.demo.service;

import com.demo.mapper.EmpMapper;
import com.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    EmpMapper empMapper;

    public List<Employee> getAll() {
        return empMapper.getAll();
    }

    public int insert(String lastName, String email, String gender, String department, String birth) {
        return empMapper.insert(lastName, email, gender, department, birth);
    }

    public Employee getEmployeeById(String id) {
        return empMapper.getEmployeeById(id);
    }

    public int delete(String id) {
        return empMapper.delete(id);
    }

    public int update(String lastName, String email, String gender, String department, String birth, String id) {
        return empMapper.update(lastName, email, gender, department, birth, id);
    }
}
