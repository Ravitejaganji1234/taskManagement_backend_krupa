package com.example.task.service;
import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.http.HttpStatus;
  import org.springframework.stereotype.Service;
  import org.springframework.web.server.ResponseStatusException;
  import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
  import java.util.*;
  import com.example.task.model.*;
  import com.example.task.repository.*;

  @Service 
public class TaskJpaService implements TaskRepository {
    @Autowired 
    public TaskJpaRepository taskRepository;
    @Autowired
    private JavaMailSender emailSender;


    @Override 

    public void deleteTask(int taskId){
      try{
        taskRepository.deleteById(taskId);
      }catch (Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
    }

    @Override 

    public Task updateTask(int taskId, Task task){
      try{
        Task newTask=taskRepository.findById(taskId).get();
        if(task.getTaskAssignedFrom()!=null){
          newTask.setTaskAssignedFrom(task.getTaskAssignedFrom());
        }
        if(task.getPersonName()!=null){
            newTask.setPersonName(task.getPersonName());
          }
          if(task.getPersonEmail()!=null){
            newTask.setPersonEmail(task.getPersonEmail());
          }

          if(task.getTaskName()!=null){
            newTask.setTaskName(task.getTaskName());
          }
          if(task.getTaskDetails()!=null){
            newTask.setTaskDetails(task.getTaskDetails());
          }
          if(task.getEffectiveDate()!=null){
            newTask.setEffectiveDate(task.getEffectiveDate());
          }
          if(task.getDueDate()!=null){
            newTask.setDueDate(task.getDueDate());
          }
          
            newTask.setTaskStatus(task.getTaskStatus());
          
        taskRepository.save(newTask);
        return newTask;
      }catch (Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
    }

    @Override 

    public Task addTask(Task task){
      taskRepository.save(task);

      String text="Dear "+task.getPersonName()+"\n Please open My tasks in employee portal to view task details";

      SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(task.getPersonEmail());
        message.setSubject("New task");
        message.setText(text);
        emailSender.send(message);

      return task;
    }

    

    

    @Override 

    public Task getTaskById(int taskId){
      try{
        return taskRepository.findById(taskId).get();
      }
      catch (Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
      }
    }

    @Override 
    public ArrayList <Task> getTasks(){
        return (ArrayList<Task>) taskRepository.findAll();
    }

    @Override 
    public List <Task> getTasksAssignedForm(String email){
        return (List<Task>) taskRepository.findAllByTaskAssignedFrom(email);
    }

    @Override 
    public List <Task> getTasksAssignedTo(String email){
        return (List<Task>) taskRepository.findAllByPersonEmail(email);
    }

    @Override
    public int countOfTasks(String email){
      return taskRepository.countByPersonEmailAndTaskStatus(email, false);
    }

    @Override
    public List getOverDueTasksAssignedFrom(String email){
      return taskRepository.allOverDueTasksAssignedFrom(email);
    }

    @Override
    public List getPendingTasksAssignedFrom(String email){
      return taskRepository.allPendingTasksAssignedFrom(email);
    }

    @Override
    public List getCompletedTasksAssignedFrom(String email){
      return taskRepository.allCompletedTasksAssignedFrom(email);
    }

    @Override
    public List getOverDueTasksPersonEmail(String email){
      return taskRepository.allOverDueTasksPersonEmail(email);
    }

    @Override
    public List getPendingTasksPersonEmail(String email){
      return taskRepository.allPendingTasksPersonEmail(email);
    }

    @Override
    public List getCompletedTasksPersonEmail(String email){
      return taskRepository.allCompletedTasksPersonEmail(email);
    }

}
