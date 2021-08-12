package com.ch.croptohome.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ch.croptohome.model.Employee;
import com.ch.croptohome.reposervice.IEmployeeService;
import com.ch.croptohome.service.EmployeeService;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;



@RestController
public class EmployeeController {
	@Autowired
	EmployeeService empservice;
	@Autowired
	IEmployeeService iempservice;

	@GetMapping("/hello")
	public String getHello() {
		return "hello thiru";

	}

	// @GetMapping("/employee/{empId}" )
	@RequestMapping(value = "/employee/{empId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Object> getEmployee(@PathVariable Long empId) {
		Employee empnaem = empservice.getEmployee(empId);
		return new ResponseEntity<Object>(empnaem.toString(), HttpStatus.OK);

	}
	@DeleteMapping(value = "/employee/{empId}")
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long empId) {
		 empservice.deleteEmpRecords(empId);
		return new ResponseEntity<Object>("SUCCESS", HttpStatus.OK);

	}

	@GetMapping("/employeeByAnyType/search/{keys}")
	public ResponseEntity<Object> getEmployeeByAnyType(@PathVariable  String keys) {
		
		List<Employee> empnaem = empservice.getEmployeeByAnyType(keys);
		return new ResponseEntity<Object>(empnaem.toString(), HttpStatus.OK);

	}

	@GetMapping("/allemployess/")
	public ResponseEntity<Object> getEmployeeList() {
		List<Employee> empnaem = empservice.getEmployeeDtls();
		return new ResponseEntity<Object>(empnaem, HttpStatus.OK);

	}

	@PostMapping("/saveemployee")
	public ResponseEntity<Object> saveEmployee(@RequestBody Employee employee) {

		iempservice.saveEmployeeDtls(employee);
		return new ResponseEntity<Object>("saved successfully!", HttpStatus.OK);
	}

	@GetMapping("/read-employess")
	public void exportCSV(HttpServletResponse response) throws Exception {

		// set file name and content type
		String filename = "employees.csv";

		response.setContentType("text/csv");
		response.setHeader(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + filename + "\"");

		// create a csv writer
		StatefulBeanToCsv<Employee> writer = new StatefulBeanToCsvBuilder<Employee>(response.getWriter())
				.withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).withSeparator(CSVWriter.DEFAULT_SEPARATOR)
				.withOrderedResults(false).build();

		// write all users to csv file
		writer.write(empservice.getEmployeeDtls());

	}

}
