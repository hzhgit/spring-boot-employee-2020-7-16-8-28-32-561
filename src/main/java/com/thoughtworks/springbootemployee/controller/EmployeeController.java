package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.data.EmployeeData;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @GetMapping
    public List<Employee> getEmployees() {
        return new EmployeeData().getCompanies();
    }

    @GetMapping(path = "/{id}")
    public Employee getEmployees(@PathVariable int id) {
        List<Employee> employees = new EmployeeData().getCompanies();
        for (Employee employee : employees){
            if(employee.getId() == id){
                return employee;
            }
        }
        return null;
    }


}
