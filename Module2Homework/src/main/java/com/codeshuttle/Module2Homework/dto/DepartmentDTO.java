package com.codeshuttle.Module2Homework.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDTO {

    private Long deptId;
    @NotNull(message = "Title cannot be null")
    private String title;
    @JsonProperty("isActive" )
    @NotNull
    private Boolean isActive;
//    @PastOrPresent()
    private LocalDate createdAt;

}
