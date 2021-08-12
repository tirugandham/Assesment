package com.ch.croptohome.service;

import java.util.List;

import com.ch.croptohome.model.Employee; 

public interface  EmployeeService {
public Employee getEmployee(Long id);
public List<Employee> getEmployeeDtls();
public List<Employee> getEmployeeByAnyType( String keys);
public void deleteEmpRecords(Long id);
}
