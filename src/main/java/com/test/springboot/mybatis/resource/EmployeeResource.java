package com.test.springboot.mybatis.resource;

import java.util.List;

import org.apache.ibatis.type.MappedTypes;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springboot.mybatis.mapper.EmployeeMapper;
import com.test.springboot.mybatis.model.Employee;

@MappedTypes(Employee.class)
@MapperScan("com.test.springboot.mybatis.mapper")
@RestController
@RequestMapping("/rest/employee")
public class EmployeeResource {
    
    private EmployeeMapper employeeMapper;

    public EmployeeResource(EmployeeMapper employeeMapper) {
        this.employeeMapper = employeeMapper;
    }


    @GetMapping("/all")
    public List<Employee> getAll() {
        return employeeMapper.findAll();
    }

    @GetMapping("/update")
    private List<Employee> update() {

        Employee employee = new Employee();
        employee.setFistName("Nadhamuni"); 
        employee.setLastName("Kothapalle"); 
        employee.setDept("MCA"); 
        employeeMapper.insert(employee);

        return employeeMapper.findAll();
    }
}
