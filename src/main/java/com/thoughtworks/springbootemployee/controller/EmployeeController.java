package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.data.EmployeeData;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping(path = "/{id}")
    public Employee getEmployees(@PathVariable int id) {
        List<Employee> employees = new EmployeeData().getCompanies();
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @GetMapping
    public List<Employee> getEmployeesByPage(@RequestParam(name = "page", required = false) Integer page, @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        EmployeeData employeeData = new EmployeeData();
        if (page != null && pageSize != null) {
            return employeeData.getCompanies().subList(page - 1, pageSize - 1);
        }
        return employeeData.getCompanies();
    }


}
