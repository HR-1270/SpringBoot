package com.demo.dao;

//部门dao

import com.demo.pojo.Department;
import com.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    @Autowired
    DeptService deptService;
    //获得所有部门信息
    public Collection<Department> getDepartments(){
        return deptService.getAll();
    }

    //通过id得到部门
    public String getDepartmentById(String id) {
        return deptService.getDeptName(id);
    }
}
