package com.thoughtworks.springbootemployee.data;

import com.thoughtworks.springbootemployee.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeData {
    private List<Employee> employees = new ArrayList<>();

    public EmployeeData() {
        this.employees.add(new Employee(001,18,"zach","male",1000));
        this.employees.add(new Employee(001,19,"alex","male",2000));
        this.employees.add(new Employee(001,20,"karen","female",3000));
        this.employees.add(new Employee(001,21,"green","male",4000));
        this.employees.add(new Employee(001,22,"Cchris","male",5000));
        this.employees.add(new Employee(001,23,"york","male",6000));
    }

    public List<Employee> getCompanies() {
        return employees;
    }
}
