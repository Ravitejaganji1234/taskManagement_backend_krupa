package com.example.task.model;

import jakarta.persistence.*;
import java.util.*;


@Entity 

public class Task {
    @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="taskid")
    int taskId;
    @Column (name="taskAssignedFrom")
    String taskAssignedFrom;
    @Column(name="personName")
    String personName;
    @Column(name="personEmail")
    String personEmail;
    @Column (name="taskName")
    String taskName;
    @Column (name="taskDetails")
    String taskDetails;
    @Temporal(TemporalType.DATE)
    @Column (name ="effectiveDate")
    Date effectiveDate;
    @Temporal(TemporalType.DATE)
    @Column (name="dueDate")
    Date dueDate;
    @Column (name="taskStatus")
    boolean taskStatus;
    public Task(){}

    public Task(int taskId, String taskAssignedFrom, String personName, String personEmail, String taskName, String taskDetails, Date effectiveDate, Date dueDate, boolean taskStatus){
        this.taskId=taskId;
        this.taskAssignedFrom=taskAssignedFrom;
        this.personName=personName;
        this.personEmail=personEmail;
        this.taskName=taskName;
        this.taskDetails=taskDetails;
        this.effectiveDate=effectiveDate;
        this.dueDate=this.dueDate;
        this.taskStatus=taskStatus;
    }

    public int getTaskId(){
        return taskId;
    }

    public void setTaskId(int taskId){
        this.taskId=taskId;
    }

    public String getTaskAssignedFrom(){
        return taskAssignedFrom;
    }

    public void setTaskAssignedFrom(String taskAssignedFrom){
        this.taskAssignedFrom=taskAssignedFrom;
    }

    public String getPersonName(){
        return personName;
    }

    public void setPersonName(String personName){
        this.personName=personName;
    }

    public String getPersonEmail(){
        return personEmail;
    }

    public void setPersonEmail(String personEmail){
        this.personEmail=personEmail;
    }

    public String getTaskName(){
        return taskName;
    }

    public void setTaskName(String taskName){
        this.taskName=taskName;
    }

    public String getTaskDetails(){
        return taskDetails;
    }

    public void setTaskDetails(String taskDetails){
        this.taskDetails=taskDetails;
    }

    public Date getEffectiveDate(){
        return effectiveDate;
    }

    public void setEffectiveDate(Date effectiveDate){
        this.effectiveDate=effectiveDate;
    }

    public Date getDueDate(){
        return dueDate;
    }

    public void setDueDate(Date dueDate){
        this.dueDate=dueDate;
    }

    public boolean getTaskStatus(){
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus){
        this.taskStatus=taskStatus;
    }

}
