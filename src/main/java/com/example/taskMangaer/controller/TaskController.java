package com.example.taskMangaer.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.taskMangaer.model.*;
import com.example.taskMangaer.service.*;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;



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

    @GetMapping("/OverdueTasks/PersonId/{personId}")
    public List getOverDuePersonEmail(@PathVariable String personId) {
        return taskService.getOverDueTasksPersonId(personId);
    }

    @GetMapping("/PendingTasks/PersonId/{personId}")
    public List getPendingPersonEmail(@PathVariable String personId) {
        return taskService.getPendingTasksPersonId(personId);
    }

    @GetMapping("/CompletedTasks/PersonId/{personId}")
    public List getCompletedTasksPersonId(@PathVariable String personId) {
        return taskService.getCompletedTasksPersonId(personId);
    }

    @GetMapping("/TasksDetails/PersonId/{personId}")
    public HashMap<String,Integer> getTasksEfficiency(@PathVariable String personId) {
        return taskService.getTasksEfficiency(personId);
    }
    

}
