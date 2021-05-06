package com.cg.fms.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.fms.model.EmployeeModel;
import com.cg.fms.service.ITrainerManagement;


@RestController
@RequestMapping(path="/employee")
public class EmployeeController {

	@Autowired
	private ITrainerManagement employeerepository;

	/*
	 * to retrieve all customer
	 * return : List<customer>
	 * params : NIL
	 */

	//get employee detail
	@GetMapping
	public ResponseEntity<List<EmployeeModel>> getEmployeeDetails() throws Exception{
		return new ResponseEntity<>(employeerepository.getAll(), HttpStatus.OK);
	}

	/*
	 * to add a customer
	 * return : customer
	 * params : NIL
	 */

	@PostMapping
	public ResponseEntity<EmployeeModel> addTrainer(@RequestBody @Valid EmployeeModel employee, BindingResult result) throws Exception {
		employee = employeerepository.addTrainer(employee);
		return new ResponseEntity<>(employee, HttpStatus.CREATED);

	}
	/*
	 * to modify a customer
	 * return : customer
	 * params : NIL
	 */

	//	@PutMapping("/employee")
	//	public ResponseEntity<EmployeeModel> updateTrainer(@RequestBody String employee) throws Exception {
	//	   EmployeeModel employee1 = employeerepository.updateTrainer(1L, employee);
	//		return new ResponseEntity<>(employee1, HttpStatus.OK);
	//
	//	}

	/*
	 * to delete a customer
	 * return : void
	 * params : customer Id
	 */

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<Void> removeEmployee(@PathVariable("employeeId") Long id) throws Exception{
		ResponseEntity<Void> response = null;
		EmployeeModel employee = employeerepository.getById(id);
		if (employee == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
			//response = ResponseEntity.notFound().build();
		} else {
			employeerepository.removeEmployee(id);
			response = new ResponseEntity<>(HttpStatus.OK);
			//response = ResponseEntity.ok().build();
		}
		return response;
	}

	/*
	 * to retrieve a customer
	 * return : customer
	 * params : customer Id
	 */


	@GetMapping("/{employeeId}")
	public ResponseEntity<EmployeeModel> findCustomer(@PathVariable("employeeId") Long id) throws Exception {
		ResponseEntity<EmployeeModel> response = null;
		EmployeeModel employee = employeerepository.getById(id);
		if (employee == null) {
			response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			employeerepository.getById(id);
			response = new ResponseEntity<>(employee, HttpStatus.OK);
		}
		return response;
	}

} 
