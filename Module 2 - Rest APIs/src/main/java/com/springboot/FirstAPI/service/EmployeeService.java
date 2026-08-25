package com.springboot.FirstAPI.service;

import com.springboot.FirstAPI.dto.EmployeeDTO;
import com.springboot.FirstAPI.entities.EmployeeEntity;
import com.springboot.FirstAPI.repository.EmployeeRepository;
import org.apache.el.util.ReflectionUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private  final EmployeeRepository employeeRepository;
    private  final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository, ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }


    public Optional<EmployeeDTO> getEmployeeById(Long id) {

        return employeeRepository.findById(id).map(employeeEntity -> modelMapper.map(employeeEntity, EmployeeDTO.class));
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

    public EmployeeDTO updateEmployeeById(Long employeeId, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
        return modelMapper.map(savedEmployee, EmployeeDTO.class);


    }

    public boolean isExists(Long employeeId){
        return employeeRepository.existsById(employeeId);

    }

    public boolean deleteEmployeeById(Long employeeId) {
        boolean exists = employeeRepository.existsById(employeeId);
        if(!exists) return false;
        employeeRepository.deleteById(employeeId);
        return true;
    }


//    public EmployeeDTO updatePartialEmployeeById(Long employeeId, Map<String, Object> updates) {
//        boolean exists = isExists(employeeId);
//        if(!exists) return null;
//        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId).get();
//        updates.forEach((field, value) ->{
//            Field fieldToBeUpdated = ReflectionUtil.findRequiredField(EmployeeEntity.class, field);
//            fieldToBeUpdated.setAccessible(true);
//            ReflectionUtil.setField(fieldToBeUpdated, employeeEntity, value);
//
//        });
//
//       return  modelMapper.map(employeeRepository.save(employeeEntity), EmployeeDTO.class);
//    }

}
