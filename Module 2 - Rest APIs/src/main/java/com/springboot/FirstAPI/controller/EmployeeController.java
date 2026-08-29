package com.springboot.FirstAPI.controller;

import com.springboot.FirstAPI.dto.EmployeeDTO;
import com.springboot.FirstAPI.entities.EmployeeEntity;
import com.springboot.FirstAPI.exceptions.ResourceNotfoundException;
import com.springboot.FirstAPI.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

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
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable(name = "employeeId") Long id){

        Optional<EmployeeDTO> employeeDTO =  employeeService.getEmployeeById(id);
        return
                employeeDTO.map(employeeDTO1 -> ResponseEntity.ok(employeeDTO1))
                        .orElseThrow(() -> new ResourceNotfoundException("Employee not found with id: "+id));
    }


    @GetMapping
    public List<EmployeeDTO> getEmployees(@RequestParam(required = false) Integer age, @RequestParam(required = false) String sortBy){


        return  employeeService.getEmployees();
    }

    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody @Valid EmployeeDTO inputEmployee){

        return employeeService.createNewEmployee(inputEmployee);
    }

    @PutMapping(path = "{employeeId}")
    public  EmployeeDTO updateEmployeeById(@PathVariable Long employeeId, @RequestBody @Valid EmployeeDTO employeeDTO){

        return employeeService.updateEmployeeById(employeeId, employeeDTO);
    }

    @DeleteMapping(path = "{employeeId}")
    public boolean deleteEmployeeById(@PathVariable Long employeeId){

        return employeeService.deleteEmployeeById(employeeId);

    }

//    @PatchMapping(path = "{employeeId}")
//    public EmployeeDTO updatePartialEmployeeById(@RequestBody Map<String, Object> updates, @PathVariable Long employeeId){
//
//        return employeeService.updatePartialEmployeeById(employeeId, updates);
//
//    }


}
