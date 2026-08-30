package com.codeshuttle.Module2Homework.controller;

import com.codeshuttle.Module2Homework.dto.DepartmentDTO;
import com.codeshuttle.Module2Homework.service.DepartmentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Department")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }


    @GetMapping
    public List<DepartmentDTO> getDepartments(){

        return departmentService.getDepartments();

    }

    @PostMapping
    public DepartmentDTO creatDepartment(@RequestBody DepartmentDTO departmentDTO){

       return departmentService.creatDepartment(departmentDTO);

    }

    @GetMapping("/{deptId}")
    public ResponseEntity<Optional<DepartmentDTO>> getDepartmentById(@PathVariable Long deptId){
       Optional<DepartmentDTO> departmentDTO= departmentService.getDepartmentById(deptId);
        return ResponseEntity.ok(departmentDTO);
    }

    @DeleteMapping(path = "/{id}")

    public boolean deleteDepartmentById(@PathVariable Long id){

        return departmentService.deleteDepartmentById(id);

    }


    @PutMapping(path = "/{deptId}")
    public DepartmentDTO updateDepartmentById(@PathVariable("deptId") Long id, @RequestBody @Valid DepartmentDTO departmentDTO ){

        return  departmentService.updateDepartmentById(id,departmentDTO);
    }









}
