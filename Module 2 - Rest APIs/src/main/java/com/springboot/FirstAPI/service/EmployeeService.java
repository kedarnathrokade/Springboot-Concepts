package com.springboot.FirstAPI.service;

import com.springboot.FirstAPI.dto.EmployeeDTO;
import com.springboot.FirstAPI.entities.EmployeeEntity;
import com.springboot.FirstAPI.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private  final EmployeeRepository employeeRepository;
    private  final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public EmployeeDTO getEmployeeById(Long id) {

        EmployeeEntity employeeEntity =  employeeRepository.findById(id).orElse(null);
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }

    public List<EmployeeDTO> getEmployees() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();
        return   employeeEntities
                .stream()
                .map(employeeEntity ->  modelMapper.map(employeeEntity,EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployee) {
        EmployeeEntity toSaveEntity = modelMapper.map(inputEmployee, EmployeeEntity.class);
        EmployeeEntity employeeEntity = employeeRepository.save(toSaveEntity);
        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }
}
