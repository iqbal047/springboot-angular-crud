package com.techiqbal.crud.service;

import com.techiqbal.crud.dao.EmployeeDao;
import com.techiqbal.crud.dao.SalaryDao;
import com.techiqbal.crud.entity.Employee;
import com.techiqbal.crud.entity.Salary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SalaryService {

    @Autowired
    private SalaryDao salaryDao;

    @Autowired
    private EmployeeDao employeeDao;

//    public Salary saveSalary(Salary salary){
//        return salaryDao.save(salary);
//    }

    public Salary saveSalary(Salary salary) {
        if (salary.getEmployee() == null || salary.getEmployee().getEmployeeId() == null) {
            throw new RuntimeException("Employee information is required");
        }

        // Fetch full Employee details from DB
        Employee employee = employeeDao.findById(salary.getEmployee().getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        salary.setEmployee(employee); // Attach full Employee object

        return salaryDao.save(salary);
    }

    public List<Salary> getSalaries() {
        return salaryDao.findAll();
    }

    public Salary getSalaryById(Integer salaryId) {
        return salaryDao.findById(salaryId).orElseThrow(() -> new RuntimeException("Salary not found"));
    }

    public List<Salary> getSalariesByEmployee(Employee employee) {
        return salaryDao.findByEmployee(employee);
    }

    public void deleteSalaryById(Integer salaryId) {
        salaryDao.deleteById(salaryId);
    }

    public Salary updateSalary(Salary salary) {
        if (!salaryDao.existsById(salary.getSalaryId())) {
            throw new RuntimeException("Salary record not found");
        }
        return salaryDao.save(salary);
    }
}
