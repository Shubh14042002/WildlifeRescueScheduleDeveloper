package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;


import java.util.ArrayList;
import java.util.regex.*;

public class TestTaskClass {
	
	@Test
	public void testTaskConstructor() {
		Task testTask = new Task(1,"Tested Task",5,1);
		assertEquals("Wrong Task TaskID", 1, testTask.getTaskID());
		assertEquals("Wrong Task TaskDescription" ,"Tested Task", testTask.getDescription());
		assertEquals("Wrong Task DurationTime", 5, testTask.getDuration());
		assertEquals("Wrong Task MaxWindow",1, testTask.getMaxWindow());
	}
	
	@Test
	public void testTaskGetTaskID() {
		Task testTask = new Task(1,"Tested Task",5,1);
		assertEquals("Wrong Task TaskID", 1, testTask.getTaskID());
	}
	
	@Test
	public void testTaskGetDuration() {
		Task testTask = new Task(1,"Tested Task",5,1);
		assertEquals("Wrong Task DurationTime", 5,testTask.getDuration());
	}
	
	@Test
	public void testTaskGetMaxWindow() {
		Task testTask = new Task(1,"Tested Task",5,1);
		assertEquals("Wrong Task MaxWindow", 1, testTask.getMaxWindow());
	}
	
	@Test
	public void testTaskGetDescription() {
		Task testTask = new Task(1,"Tested Task",5,1);
		assertEquals("Wrong Task TaskDescription", "Tested Task", testTask.getDescription());
	}
	
	@Test
	public void testTaskSetDescription() {
		Task testTask = new Task(1,"Tested Task",5,1);
		testTask.setDescription("New Tested Task Description");
		assertEquals("Wrong Task TaskDescription","New Tested Task Description", testTask.getDescription());
	}
	
	@Test
	public void testTaskSetTaskID() {
		Task testTask = new Task(1,"Tested Task",5,1);
		testTask.setTaskID(10);
		assertEquals("Wrong Task TaskID",10, testTask.getTaskID());
	}
	
	@Test
	public void testTaskSetDuration() {
		Task testTask = new Task(1,"Tested Task",5,1);
		testTask.setDuration(20);
		assertEquals("Wrong Task DurationTime",20, testTask.getDuration());
	}
	
	@Test
	public void testTaskSetMaxWindow() {
		Task testTask = new Task(1,"Tested Task",5,1);
		testTask.setMaxWindow(4);
		assertEquals("Wrong Task MaxWindow",4, testTask.getMaxWindow());
	}
	
}
