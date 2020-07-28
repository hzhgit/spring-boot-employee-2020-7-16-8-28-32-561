package com.thoughtworks.springbootemployee.data;

import com.thoughtworks.springbootemployee.model.Company;

import java.util.ArrayList;
import java.util.List;

public class CompanyData {
    private List<Company> companies = new ArrayList<>();

    public CompanyData() {
        this.companies.add(new Company(1, "OOCL"));
        this.companies.add(new Company(2, "BLIBLI"));
        this.companies.add(new Company(3, "TW"));
        this.companies.add(new Company(4, "AAA"));
        this.companies.add(new Company(5, "BBB"));
        this.companies.add(new Company(6, "CCC"));
    }

    public List<Company> getCompanies() {
        return companies;
    }
}
