package com.test.springboot.mybatis.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.test.springboot.mybatis.model.Employee;

import java.util.List;

@Mapper
public interface EmployeeMapper {

	@Select("select * from employee")
	List<Employee> findAll();

	@Insert("insert into employee(fistname,lastName,dept) values(#{fistName},#{lastName},#{dept})")
	@SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
	void insert(Employee employee);
}
