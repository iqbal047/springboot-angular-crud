package com.techiqbal.crud.controller;


import com.techiqbal.crud.entity.Employee;
import com.techiqbal.crud.entity.Salary;
import com.techiqbal.crud.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @PostMapping("/save/salary")
    public Salary saveSalary(@RequestBody Salary salary){
        return salaryService.saveSalary(salary);
    }

    @GetMapping("/get/salary")
    public List<Salary> getSalaries() {
        return salaryService.getSalaries();
    }

    @GetMapping("/get/{salaryId}")
    public Salary getSalaryById(@PathVariable Integer salaryId) {
        return salaryService.getSalaryById(salaryId);
    }

//    @GetMapping("/get/employee/{employeeId}")
//    public List<Salary> getSalariesByEmployee(@PathVariable Integer employeeId) {
//        Employee employee = new Employee();
//        employee.setEmployeeId(employeeId); // Creating a dummy Employee object to fetch salaries
//        return salaryService.getSalariesByEmployee(employee);
//    }

    @DeleteMapping("/delete/{salaryId}")
    public void deleteSalary(@PathVariable Integer salaryId) {
        salaryService.deleteSalaryById(salaryId);
    }

    @PutMapping("/update/salary")
    public Salary updateSalary(@RequestBody Salary salary) {
        return salaryService.updateSalary(salary);
    }



}
