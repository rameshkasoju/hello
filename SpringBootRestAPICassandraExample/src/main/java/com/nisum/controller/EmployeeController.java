package com.nisum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nisum.entity.Employee;
import com.nisum.service.EmployeeService;

@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;
    
    public EmployeeController() {
        System.out.println("EmployeeController()");
    }
         
    @RequestMapping(value = "/employee", method = RequestMethod.POST)    
    public Employee create(@RequestBody Employee employee) {        
        return employeeService.createEmployee(employee);
    }
 
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") int id) {
        employeeService.deleteEmployee(id);
    }
 
    @RequestMapping(value="/employee", method = RequestMethod.GET)
    public List<Employee> findAll() {
        return employeeService.getAllEmployees();
    }
 
    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public  Employee findById(@PathVariable("id") int id) {        
        return employeeService.getEmployee(id);
    }
 
    @RequestMapping(value = "/employee", method = RequestMethod.PUT)
    public Employee update(@RequestBody Employee employee) {
        return employeeService.updateEmployee(employee);
    }
}