package com.example.task.repository;
import java.util.*;
import com.example.task.model.*;

public interface TaskRepository {
    ArrayList <Task> getTasks();
    Task getTaskById(int taskId);
    Task addTask(Task task);
    Task updateTask(int taskId, Task task);
    void deleteTask(int taskId);
    int countOfTasks(String email);
    List <Task> getTasksAssignedForm(String email);
    List <Task> getTasksAssignedTo(String email);
    List<Task> getOverDueTasksAssignedFrom(String email);
    List<Task> getPendingTasksAssignedFrom(String email);
    List<Task> getCompletedTasksAssignedFrom(String email);
    List<Task> getOverDueTasksPersonEmail(String email);
    List<Task> getPendingTasksPersonEmail(String email);
    List<Task> getCompletedTasksPersonEmail(String email);
}
