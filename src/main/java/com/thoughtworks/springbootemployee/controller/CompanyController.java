package com.thoughtworks.springbootemployee.controller;

import com.thoughtworks.springbootemployee.data.CompanyData;
import com.thoughtworks.springbootemployee.model.Company;
import com.thoughtworks.springbootemployee.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {
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

    @GetMapping
    public List<Company> getCompanyByPage(@RequestParam(name = "page" , required = false) Integer page, @RequestParam(name = "pageSize",required = false) Integer pageSize) {
        CompanyData companyData = new CompanyData();
        if (page != null && pageSize != null) {
            return companyData.getCompanies().subList(page- 1, pageSize-1);
        }
        return companyData.getCompanies();
    }

    @PostMapping
    public String addCompany(@RequestBody Company company){
        String message = "fail";
        List<Company> companies = new ArrayList<>();

        if(company != null){
            companies.add(company);
        }

        if (companies.contains(company)){
            return message = "success";
        }

        return message;
    }

    @PutMapping("/{id}")
    public Company updateCompanyById(@PathVariable Integer id, @RequestBody Company company) {
        List<Company> companies = new CompanyData().getCompanies();
        companies.add(new Company(1, "OOCl"));
        for (int i = 0; i < companies.size(); i++) {
            if(companies.get(i).getId() == company.getId()) {
                companies.set(i, company);
                break;
            }
        }
        return company;
    }

    @DeleteMapping("/{id}")
    public String deleteCompanyEmployees(@PathVariable Integer id) {
        List<Company> companies = new CompanyData().getCompanies();
        for (int i = 0; i < companies.size(); i++) {
            if (companies.get(i).getId() == id) {
                companies.get(i).setEmployees(new ArrayList<>());
                companies.get(i).setEmpoyeesNumber(0);
            }
        }
        return "delete success!";
    }
}
