package com.spring.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.ResourceAccessException;

import com.spring.dto.employeedto;
import com.spring.exception.ResourcrNotFoundException;
import com.spring.model.Employee;
import com.spring.repository.EmployeeRepository;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/api/v1")
public class EmployeeController  {
	@Autowired
 private ModelMapper modelmapper;
	@Autowired
	private EmployeeRepository employeeRepository;
	@GetMapping("/employee")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	
	@PostMapping ("/employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}
	@PutMapping ("/employees/{id}")
	public ResponseEntity <Employee> updateEntity(@PathVariable Long id, @Valid @RequestBody employeedto empdto) throws ResourcrNotFoundException{
		//Employee emp=modelmapper.map(empdto, Employee.class);
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(() -> new ResourcrNotFoundException("Employee not exist with id :" + id));
		Employee emp=modelmapper.map(empdto, Employee.class);

		//employee.setFirstname(employeeDetails.getFirstname());
		//employee.setLastname(employeeDetails.getLastname());
		//employee.setEmailId(employeeDetails.getEmailId());
		
		Employee updatedEmployee = employeeRepository.save(emp);
		return ResponseEntity.ok(updatedEmployee);
		
	}
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Employee> deleteEntity(@PathVariable Long id) throws ResourcrNotFoundException{
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(() -> new ResourcrNotFoundException("Employee not exist with id :" + id));
		 employeeRepository.delete(employee);
		return ResponseEntity.ok(employee);
   }
	@GetMapping("/employees/{id}")
	public  ResponseEntity<Employee> getById(@PathVariable long id) throws ResourcrNotFoundException{
		Employee employee=employeeRepository.findById(id)
				.orElseThrow(() -> new ResourcrNotFoundException("Employee not exist with id :" + id));
		@SuppressWarnings("deprecation")
		Employee employee_new=employeeRepository.getById(id);
		return new ResponseEntity<>(employee_new ,HttpStatus.OK);
		
	}
}
