package com.thoughtworks.springbootemployee.model;

import java.util.List;

public class Company {
    private int id;
    private String companyName;
    private List<Employee> employees;
    private int empoyeesNumber;

    public Company(int id, String companyName) {
        this.id = id;
        this.companyName = companyName;
    }

    public Company(int id, String companyName, int empoyeesNumber, List<Employee> employees) {
        this.id = id;
        this.companyName = companyName;
        this.empoyeesNumber = empoyeesNumber;
        this.employees = employees;
    }

    public Company() {

    }

    public int getEmpoyeesNumber() {
        return empoyeesNumber;
    }

    public void setEmpoyeesNumber(int empoyeesNumber) {
        this.empoyeesNumber = empoyeesNumber;
    }

    public int getId() {
        return id;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
        this.empoyeesNumber = this.employees.size();
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
