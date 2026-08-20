package com.springboot.FirstAPI.controller;

import com.springboot.FirstAPI.dto.EmployeeDTO;
import com.springboot.FirstAPI.entities.EmployeeEntity;
import com.springboot.FirstAPI.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

//    @GetMapping(path = "/getSecretMessage")
//    public  String getSecretMessage(){
//        return "Secret Message : astasf!3e1345rfaws";
//    }

    private EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getEmployeeById(@PathVariable(name = "employeeId") Long id){

        return employeeRepository.findById(id).orElse(null);
    }

    @GetMapping
    public List<EmployeeEntity> getEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){


        return  employeeRepository.findAll();
    }

    @PostMapping
    public EmployeeEntity createNewEmployee(@RequestBody EmployeeEntity inputEmployee){

        return employeeRepository.save(inputEmployee);
    }

    @PutMapping String updateEmployeeById(){

        return  "Hello from PUT";
    }

}
