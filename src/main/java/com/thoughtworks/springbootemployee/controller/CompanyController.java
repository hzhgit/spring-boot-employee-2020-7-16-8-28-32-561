package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
    @GetMapping
    public List<Company> getCompanies() {
        ArrayList<Company> companies = new ArrayList<>();
        companies.add(new Company(1, "oocl"));
        companies.add(new Company(2, "blibli"));

        ArrayList<Employee> employeesOfOOCL = new ArrayList<>();
        ArrayList<Employee> employeesOfBlibli = new ArrayList<>();

        employeesOfOOCL.add(new Employee(1001, 18, "zach", "male", 1000));
        employeesOfOOCL.add(new Employee(1002, 17, "alex", "male", 1000));
        employeesOfBlibli.add(new Employee(1003, 19, "zach1", "male", 1000));
        employeesOfBlibli.add(new Employee(1004, 18, "zach2", "male", 1000));

        companies.get(0).setEmployees(employeesOfOOCL);
        companies.get(1).setEmployees(employeesOfBlibli);
        return companies;
    }

    @GetMapping(path = "/{id}")
    public Company getCompanyById(@PathVariable int id) {
        Company company = new Company(1, "OOCL");
        if (company.getId() == id) {
            return company;
        }
        return null;
    }

    @GetMapping(path = "/{id}/employees")
    public List<Employee> getEmployeeOfCompany(@PathVariable int id) {
        AbstractList<Employee> employees = new ArrayList<>();
        Company company = new Company(1, "OOCL");

        employees.add(new Employee(1001, 18, "zach", "male", 1000));
        employees.add(new Employee(1002, 17, "alex", "male", 1000));
        company.setEmployees(employees);

        if (company.getId() == id) {
            return company.getEmployees();
        }
        return null;
    }

}
