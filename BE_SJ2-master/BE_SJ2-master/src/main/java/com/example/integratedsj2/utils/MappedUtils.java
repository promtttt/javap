package com.example.integratedsj2.utils;

import com.example.integratedsj2.dtos.AddTasksDTO;
import com.example.integratedsj2.entities.Status;

public class MappedUtils {
    public static void mappedUtilsTask(AddTasksDTO addTasksDTO) {
        if (addTasksDTO.getDescription() != null) {
            addTasksDTO.setDescription(addTasksDTO.getDescription().isEmpty() ? null : addTasksDTO.getDescription());
        }
        if (addTasksDTO.getAssignees() != null) {
            addTasksDTO.setAssignees(addTasksDTO.getAssignees().isEmpty() ? null : addTasksDTO.getAssignees());
        }
        addTasksDTO.setStatus(addTasksDTO.getStatus() == null ? Status.NO_STATUS : addTasksDTO.getStatus());
    }
}
