package com.springboot.FirstAPI.controller;

import com.springboot.FirstAPI.dto.EmployeeDTO;
import com.springboot.FirstAPI.entities.EmployeeEntity;
import com.springboot.FirstAPI.service.EmployeeService;
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

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/{employeeId}")
    public EmployeeDTO getEmployeeById(@PathVariable(name = "employeeId") Long id){

        return employeeService.getEmployeeById(id);
    }

    @GetMapping
    public List<EmployeeDTO> getEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){


        return  employeeService.getEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){

        return employeeService.createNewEmployee(inputEmployee);
    }



}
