package com.fspring.JobApplication.Company;

import com.fspring.JobApplication.Job.Job;

import java.util.List;

public interface CompanyService {

    List<Company> getAllCompanies();
    boolean updateCompany(Long id, Company updateCompany);
    void createCompany( Company company);
    boolean deleteCompanyById(Long id);
    Company getCompanyById(Long id);

}
