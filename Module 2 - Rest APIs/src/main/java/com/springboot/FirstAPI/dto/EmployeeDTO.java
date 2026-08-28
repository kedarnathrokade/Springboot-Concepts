package com.springboot.FirstAPI.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.FirstAPI.annotations.EmployeeRoleValidationAnnotation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {

    private Long id;
    @NotBlank(message = "Name cannot be Blank")
    @Size(min = 3, max = 10, message = "Name should be in the range [3,10]")
    private String name;

    @NotNull(message = "email is cannot null")
    @Email(message = "Email should be valid email")
    private String email;


    @NotNull(message = "age is cannot null")
    @Max(value = 80 , message = "Age cannot be more than 80")
    @Min(value = 18, message = "Age is cannot be below 18")
    private Integer age;

    @NotBlank(message = "User cannot be null")
 //   @Pattern(regexp = "^(USER|ADMIN)", message = "User is not valid, User is either ADMIN or USER")
    @EmployeeRoleValidationAnnotation
    private String role;

    @NotNull(message = "Date of joining cannot null")
    @PastOrPresent(message = "Date of joining must be past date")
    private LocalDate dateOfJoining;

    @AssertTrue(message = "Employee should be active")
    @JsonProperty("isActive")
    private Boolean isActive;

    @NotNull(message = "Salary of employee must be a not null")
    @Positive(message = "Salary of employee must be a positive number")
    @Digits(integer = 7, fraction = 4, message = "Salary should in XXXXXXX.YYYY format")
    @DecimalMax(value = "100000.9999", message = "Salary should not be more than 100000.9999")
    @DecimalMin(value = "100.9999", message = "Salary should not be less than 100.9999")
    private Double salary;



}
