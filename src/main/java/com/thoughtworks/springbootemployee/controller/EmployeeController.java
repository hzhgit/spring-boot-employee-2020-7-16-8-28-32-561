package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.data.EmployeeData;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    public List<Employee> getEmployeesByPage(
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "pageSize", required = false) Integer pageSize,
            @RequestParam(name = "gender", required = false) String gender) {
        List<Employee> employees = new EmployeeData().getCompanies();
        if (page != null && pageSize != null) {
            return employees.subList(page - 1, pageSize - 1);
        }

        if (gender != null) {
            return employees = employees.stream().filter(employee -> {
                return employee.getGender().equals(gender);
            }).collect(Collectors.toList());
        }

        return employees;
    }

}
