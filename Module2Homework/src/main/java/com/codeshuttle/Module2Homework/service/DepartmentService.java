package com.codeshuttle.Module2Homework.service;

import com.codeshuttle.Module2Homework.dto.DepartmentDTO;
import com.codeshuttle.Module2Homework.entity.DepartmentEntity;
import com.codeshuttle.Module2Homework.exceptions.ResourceNotFoundException;
import com.codeshuttle.Module2Homework.repository.DepartmentRepository;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    private final ModelMapper modelMapper;

    public DepartmentService(DepartmentRepository departmentRepository, ModelMapper modelMapper) {
        this.departmentRepository = departmentRepository;
        this.modelMapper = modelMapper;
    }


    public List<DepartmentDTO> getDepartments() {

        List<DepartmentEntity> deptList = departmentRepository.findAll();

        return
                deptList.stream()
                        .map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class))
                .collect(Collectors.toList());

    }


    public DepartmentDTO creatDepartment(DepartmentDTO departmentDTO) {
        DepartmentEntity saveDepartment = modelMapper.map(departmentDTO, DepartmentEntity.class);
        DepartmentEntity departmentEntity = departmentRepository.save(saveDepartment);
        return modelMapper.map(departmentEntity, DepartmentDTO.class);

    }

    public Optional<DepartmentDTO> getDepartmentById(Long deptId) {

        return departmentRepository.findById(deptId).map(departmentEntity -> modelMapper.map(departmentEntity, DepartmentDTO.class));
    }


    public boolean deleteDepartmentById(Long id) {
        isExist(id);

        departmentRepository.deleteById(id);
        return true;

    }

    public boolean isExist(Long id){
        boolean isExist = departmentRepository.existsById(id);

        if(!isExist) throw new ResourceNotFoundException("Department not found with id : "+id);

        return true;
    }

    public DepartmentDTO updateDepartmentById(Long id, @Valid DepartmentDTO departmentDTO) {

        isExist(id);
        DepartmentEntity departmentEntity = modelMapper.map(departmentDTO, DepartmentEntity.class);

        departmentEntity.setDeptId(id);
        DepartmentEntity saveddepartmentEntity = departmentRepository.save(departmentEntity);

        return modelMapper.map(saveddepartmentEntity, DepartmentDTO.class);

    }



}
