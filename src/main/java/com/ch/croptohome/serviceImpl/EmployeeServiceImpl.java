package com.ch.croptohome.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager; 
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.croptohome.model.Employee;
import com.ch.croptohome.repo.EmployeeRepo;
import com.ch.croptohome.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
	EmployeeRepo employeeRepo;
    @Autowired
	EntityManager em ;
    @Override
	public Employee getEmployee(Long  empId) {
		
		
		Employee emp= employeeRepo.findById(empId).get();
		/*
		 * employee.setEmpId(empId); employee.setEmployeename("Thiru");
		 */
		
		return emp;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getEmployeeDtls() {
		// TODO Auto-generated method stub
		//List<Employee> employees = new ArrayList<Employee>();
		
		Query query = em.createQuery("SELECT c FROM Employee c");
		List<Employee> results = query.getResultList();
		 return results;
		//return employees;
	}

	@Override
	public List<Employee> getEmployeeByAnyType(String keys) {
		return employeeRepo.findBySearchTerm(keys);
	}

	@Override
	public void deleteEmpRecords(Long id) {
		 employeeRepo.deleteById(id);
		
	}

	
}
