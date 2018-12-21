package com.kg.springfinal.controller;

import java.util.List;

import com.kg.springfinal.*;
import com.kg.springfinal.model.Employee;
import com.kg.springfinal.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository; 

    @RequestMapping(method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee) {
        employee.setEmployeeId(0L);
        return employeeRepository.saveAndFlush(employee);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Employee update(@PathVariable Long id, @RequestBody Employee updatedEmployee) {
        Employee employee = employeeRepository.getOne(id);
        employee.setFirstName(updatedEmployee.getFirstName());
        return employeeRepository.saveAndFlush(employee);
    }

    @RequestMapping(method = RequestMethod.GET)
    public  String read() {
        employeeRepository.findAll();
        return "employee";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    void delete(@PathVariable("id") Long id) {
        employeeRepository.deleteById(id);
    }

}