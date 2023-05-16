package com.java.app;

import java.time.LocalDate;

public class Task {
	private static Integer id=1;
	private Integer taskId;
	private String taskName,description;
	private LocalDate taskDate;
	private ENUM status;
	private Boolean active;
	
	public enum ENUM{
		PENDING,INPROGRESS,COMPLETED
	}

	public Task(String taskName, String description, LocalDate taskDate) {
		this.taskId=id++;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = ENUM.PENDING;
		this.active = true;
	}
	
	public Task(Integer taskId, String taskName, String description, LocalDate taskDate, ENUM status) {
		this.taskId=taskId;
		this.taskName = taskName;
		this.description = description;
		this.taskDate = taskDate;
		this.status = status;
		this.active = true;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public Integer getTaskId() {
		return taskId;
	}

	public LocalDate getTaskDate() {
		return taskDate;
	}

	public ENUM getStatus() {
		return status;
	}

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", description=" + description + ", taskDate="
				+ taskDate + ", status=" + status + ", active=" + active + "]";
	}
		
}
