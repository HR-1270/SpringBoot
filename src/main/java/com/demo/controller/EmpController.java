package com.demo.controller;

import com.demo.dao.DepartmentDao;
import com.demo.dao.EmployeeDao;
import com.demo.pojo.Department;
import com.demo.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmpController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    /**
     * 来显示现有的员工
     * @param model
     * @return
     */
    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getEmployees();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    //get请求走这个添加方法
    //显示出现有的全部部门
    @GetMapping("/emp")
    public String toAdd(Model model) {
        //查询部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        //跳转到表单页面
        return "emp/add";
    }

    //post请求走这个方法
    //增加员工的操作
    @PostMapping("/emp")
    public String add(Employee employee) {
        int result = employeeDao.save(employee);
        if (result >= 1) {
            return "redirect:/emps";
        }
        return "emp";
    }

    @GetMapping("/emp/{id}")
    public String toEdit(@PathVariable("id") String id, Model model) {
        Employee employee = employeeDao.getEmployeeById(id);
        //查询部门列表
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        model.addAttribute("emp", employee);
        //转向编辑页面
        return "emp/edit";
    }

    //修改员工信息
    @PostMapping("/emp/{id}")
    public String edit(@PathVariable("id") String id, Employee employee) {
        //进行dao层的修改操作
        employeeDao.updateEmployee(employee, id);
        return "redirect:/emps";
    }

    //删除员工
    @RequestMapping("/delemp/{id}")
    public String delete(@PathVariable("id") String id) {
        employeeDao.deleteEmployee(id);
        return "redirect:/emps";
    }
}
