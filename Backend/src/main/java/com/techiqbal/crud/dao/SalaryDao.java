package com.techiqbal.crud.dao;

import com.techiqbal.crud.entity.Employee;
import com.techiqbal.crud.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryDao extends JpaRepository<Salary, Integer> {
    List<Salary> findByEmployee(Employee employee);
}

