package com.demo.mapper;

import com.demo.pojo.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmpMapper {
    //查询全部的员工信息
    @Select("select * from Employee")
    List<Employee> getAll();
    //增加
    @Insert("insert into Employee (lastName,email,gender,department,birth) values(#{lastName},#{email},#{gender},#{department},#{birth})")
    int insert(String lastName,String email,String gender,String department,String birth);
    //通过id查询员工信息
    @Select("select * from Employee where id=#{id}")
    Employee getEmployeeById(String id);
    //删除
    @Delete("delete from Employee where id =#{id}")
    int delete(String id);
    //修改
    @Update("update Employee set lastName=#{lastName},email=#{email},gender=#{gender},department=#{department},birth=#{birth} where id=#{id}")
    int update(String lastName,String email,String gender,String department,String birth,String id);
}
