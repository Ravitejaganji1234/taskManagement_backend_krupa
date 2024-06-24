package com.example.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.*;
  import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.example.task.model.*;
  import com.example.task.service.*;



  @RestController

  @CrossOrigin
  @RequestMapping("apis/employees")
public class TaskController {
    @Autowired 
    public TaskJpaService taskService;

    @GetMapping("/tasks")
    public ArrayList<Task> gettTasks(){
        return taskService.getTasks();
    }

    @GetMapping("/tasks/{taskId}")

    public Task getTaskById(@PathVariable int taskId){
      return taskService.getTaskById(taskId);
    }

    @GetMapping("/tasksAssignedBy/{email}")

    public List<Task> getTaskAssignedBy(@PathVariable String email){
      return taskService.getTasksAssignedForm(email);
    }

    @GetMapping("/tasksAssignedTo/{email}")

    public List<Task> getTaskAssignedTo(@PathVariable String email){
      return taskService.getTasksAssignedTo(email);
    }

    @GetMapping("/tasksCount/{email}")

    public int countOfTasks(@PathVariable String email){
      return taskService.countOfTasks(email);
    }

    @PostMapping("/tasks")

    public Task addTask(@RequestBody Task task){
      return taskService.addTask(task);
    }

    @PutMapping("/tasks/{taskId}")

    public Task updateTask(@PathVariable int taskId,@RequestBody Task task){
      return taskService.updateTask(taskId,task);
    }

    @DeleteMapping("/tasks/{taskId}")

    public void deleteTask(@PathVariable int taskId){
      taskService.deleteTask(taskId);
    }

    @GetMapping("/OverdueTasks/AssignedFrom/{email}")
    public List getOverDueTasksAssignedFrom(@PathVariable String email) {
        return taskService.getOverDueTasksAssignedFrom(email);
    }

    @GetMapping("/PendingTasks/AssignedFrom/{email}")
    public List getPendingTasksAssignedFrom(@PathVariable String email) {
        return taskService.getPendingTasksAssignedFrom(email);
    }

    @GetMapping("/CompletedTasks/AssignedFrom/{email}")
    public List getCompletedTasksAssignedFrom(@PathVariable String email) {
        return taskService.getCompletedTasksAssignedFrom(email);
    }

    @GetMapping("/OverdueTasks/PersonEmail/{email}")
    public List getOverDuePersonEmail(@PathVariable String email) {
        return taskService.getOverDueTasksPersonEmail(email);
    }

    @GetMapping("/PendingTasks/PersonEmail/{email}")
    public List getPendingPersonEmail(@PathVariable String email) {
        return taskService.getPendingTasksPersonEmail(email);
    }

    @GetMapping("/CompletedTasks/PersonEmail/{email}")
    public List getCompletedTasksPersonEmail(@PathVariable String email) {
        return taskService.getCompletedTasksPersonEmail(email);
    }
    

}
