package com.example.integratedsj2.dtos;

import com.example.integratedsj2.entities.Status;
import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class AddTasksDTO {
    @Column(name = "taskID", nullable = false)
    private Integer id;
    @Column(name = "taskTitle", nullable = false, length = 100)
    private String title;
    @Column(name = "taskDescription", length = 500)
    private String description;
    @Column(name = "taskAssignees", length = 30)
    private String assignees;
    @Column(name = "taskStatus")
    private Status status;

    public String getTitle() {
        return title.trim();
    }

    public String getDescription() {
        return description ==null ? null : description.trim();
    }
}
