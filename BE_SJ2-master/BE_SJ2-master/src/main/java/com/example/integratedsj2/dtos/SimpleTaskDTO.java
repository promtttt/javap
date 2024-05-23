package com.example.integratedsj2.dtos;

import com.example.integratedsj2.entities.Status;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SimpleTaskDTO {
    private Integer id;
    private String title;
    private String assignees;
    private Status status;
}
