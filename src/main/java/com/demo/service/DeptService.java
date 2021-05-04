package com.demo.service;

import com.demo.mapper.DeptMapper;
import com.demo.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptService {
    @Autowired
    DeptMapper deptMapper;

    public String getDeptName(String deptId) {
        return deptMapper.getDeptName(deptId);
    }

    public List<Department> getAll() {
        return deptMapper.getAll();
    }
}
