package com.ch.croptohome.reposerviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ch.croptohome.model.Employee;
import com.ch.croptohome.repo.EmployeeRepo;
import com.ch.croptohome.reposervice.IEmployeeService;
@Service
public class IEmployeeServiceImpl implements IEmployeeService{
   @Autowired
	EmployeeRepo employeeService;
	@Override
	public void saveEmployeeDtls(Employee employee) {
		employeeService.save(employee);
		
	}

}
