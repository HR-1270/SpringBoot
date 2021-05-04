package com.demo;

import com.demo.pojo.Department;
import com.demo.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class Demo03WebApplicationTests {

    @Autowired
    DeptService deptService;


    @Test
    void contextLoads() {
        String deptName = deptService.getDeptName("101");
        log.info("101对应的部门名称是:" + deptName);
        List<Department>departmentList = deptService.getAll();
        for (Department department:departmentList){
            log.info("************************");
            log.info(department.toString());
        }
    }
}
