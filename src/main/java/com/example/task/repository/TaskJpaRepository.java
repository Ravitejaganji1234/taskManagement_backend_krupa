package com.example.task.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
  import com.example.task.model.*;
 import java.util.*;
import java.util.List;

@Repository

public interface TaskJpaRepository extends JpaRepository<Task,Integer>{
  @Query("SELECT COUNT(t) FROM Task t WHERE t.personEmail = :personEmail AND t.taskStatus = :taskStatus")
  int countByPersonEmailAndTaskStatus(@Param("personEmail") String personEmail, @Param("taskStatus") Boolean taskStatus);
  List<Task> findAllByTaskAssignedFrom(String taskAssignedFrom);
  List<Task> findAllByPersonEmail(String personEmail);


  @Query("SELECT t FROM Task t WHERE t.taskAssignedFrom = :taskAssignedFrom AND t.taskStatus=false AND t.dueDate < CURDATE()")
  List<Task> allOverDueTasksAssignedFrom(@Param ("taskAssignedFrom") String taskAssignedFrom);

  @Query("SELECT t FROM Task t WHERE t.taskAssignedFrom = :taskAssignedFrom AND t.taskStatus=false AND (t.dueDate >= CURDATE() OR t.dueDate IS NULL)")
  List<Task> allPendingTasksAssignedFrom(@Param ("taskAssignedFrom") String taskAssignedFrom);

  @Query("SELECT t FROM Task t WHERE t.taskAssignedFrom = :taskAssignedFrom AND t.taskStatus=true")
  List<Task> allCompletedTasksAssignedFrom(@Param ("taskAssignedFrom") String taskAssignedFrom);

  @Query("SELECT t FROM Task t WHERE t.personEmail = :personEmail AND t.taskStatus=false AND t.dueDate < CURDATE()")
  List<Task> allOverDueTasksPersonEmail(@Param ("personEmail") String personEmail);

  @Query("SELECT t FROM Task t WHERE t.personEmail = :personEmail AND t.taskStatus=false AND (t.dueDate >= CURDATE() OR t.dueDate IS NULL)")
  List<Task> allPendingTasksPersonEmail(@Param ("personEmail") String personEmail);

  @Query("SELECT t FROM Task t WHERE t.personEmail = :personEmail AND t.taskStatus=true")
  List<Task> allCompletedTasksPersonEmail(@Param ("personEmail") String personEmail);
}
