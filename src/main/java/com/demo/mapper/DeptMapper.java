package com.demo.mapper;

import com.demo.pojo.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface DeptMapper {
    /**
     * 通过id来得到部门名称
     */
    @Select("select departmentName from Department where id = #{id}")
    String getDeptName(String deptId);
    //查询全部的部门信息
    @Select("select * from Department")
    List<Department> getAll();
}
