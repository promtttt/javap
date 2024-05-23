package com.example.integratedsj2.services;

import com.example.integratedsj2.dtos.AddTasksDTO;
import com.example.integratedsj2.dtos.SimpleTaskDTO;
import com.example.integratedsj2.entities.Status;
import com.example.integratedsj2.entities.Tasks;
import com.example.integratedsj2.utils.MappedUtils;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import com.example.integratedsj2.repositories.TaskRepository;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Tasks findByID(Integer id){
        return repository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,
                "Task id " + id +  " does not exist !!!"));
    }

    public List<Tasks> findAllTask() {
        return repository.findAll();
    }
    @Transactional
    public AddTasksDTO addTasks(AddTasksDTO addTasksDTO) {
        if (addTasksDTO.getTitle() == null || addTasksDTO.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Please add the required");
        }
        MappedUtils.mappedUtilsTask(addTasksDTO);
        return modelMapper.map(repository.save(modelMapper.map(addTasksDTO, Tasks.class)), AddTasksDTO.class);
    }
    @Transactional
    public SimpleTaskDTO deleteTasks(Integer id){
         Tasks tasks = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND"));
         repository.delete(tasks);
         return modelMapper.map(tasks, SimpleTaskDTO.class);
    }
    @Transactional
    public AddTasksDTO updateTasks(Integer id, AddTasksDTO addTasksDTO){
        if (addTasksDTO.getTitle() == null || addTasksDTO.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Please add the required");
        }
        repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "NOT FOUND"));
        addTasksDTO.setId(id);
        MappedUtils.mappedUtilsTask(addTasksDTO);
        return modelMapper.map(repository.save(modelMapper.map(addTasksDTO, Tasks.class)), AddTasksDTO.class);
    }
}
