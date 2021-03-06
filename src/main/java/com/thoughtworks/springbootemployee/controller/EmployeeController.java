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

    @PostMapping
    public String addEmploee(@RequestBody Employee employee) {
        String message = "fail";
        List<Employee> employees = new EmployeeData().getCompanies();
        if (employee != null) {
            employees.add(employee);
        }
        if (employees.contains(employee)) {
            return message = "success";
        }
        return message;
    }

    @PutMapping("/{id}")
    public Employee updateEmploeeById(@PathVariable Integer id, @RequestBody Employee employee) {
        List<Employee> employees = new EmployeeData().getCompanies();
        for (int index = 0; index < employees.size(); index++) {
            if (employees.get(index).getId() == id) {
                employees.set(index, employee);
                break;
            }
        }
        return employee;
    }

    @DeleteMapping("/{id}")
    public String deleteEmploeeById(@PathVariable Integer id) {
        String message = "fail";
        List<Employee> employees = new EmployeeData().getCompanies();
        Employee deleteEmployee = employees.stream().filter(employee -> {
            return employee.getId() == id;
        }).findFirst().orElse(null);

        if(deleteEmployee == null){
            return message;
        }
        return  message = "success";
    }
}
