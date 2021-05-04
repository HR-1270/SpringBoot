package com.demo.dao;

//员工dao

import com.demo.pojo.Department;
import com.demo.pojo.Employee;
import com.demo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class EmployeeDao {

    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    EmpService empService;


    //   增加一个员工
    public int save(Employee employee) {
        return empService.insert(employee.getLastName(), employee.getEmail(), employee.getGender(), employee.getDepartment(), employee.getBirth());
    }

    //查询全部员工信息
    public Collection<Employee> getEmployees() {
        return empService.getAll();
    }

    //通过id查询员工

    public Employee getEmployeeById(String id) {
        return empService.getEmployeeById(id);
    }

    //修改员工信息
    public int updateEmployee(Employee employee, String id) {
        return empService.update(employee.getLastName(), employee.getEmail(), employee.getGender(), employee.getDepartment(), employee.getBirth(), id);
    }

    //删除员工信息
    public void deleteEmployee(String id) {
        empService.delete(id);
    }
}
