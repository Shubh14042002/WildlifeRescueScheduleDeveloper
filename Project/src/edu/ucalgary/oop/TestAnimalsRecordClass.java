package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;


import java.util.ArrayList;
import java.util.regex.*;

public class TestAnimalsRecordClass {
	@Test
	//Test for AnimalRecords Class Constructor
	public void TestAnimalRecordsConstructor() {
		HashMap<Integer, Animal> animalList = new HashMap<>();
		//Creating  animal object and putting them into  animal hashmap 
		animalList.put(1, new Animal(1, "Mike", "coyote"));
		animalList.put(2, new Animal(2, "Potter", "fox"));
		HashMap<Integer, Task> taskList = new HashMap<>();
		//Creating  task object and putting them task  hashmap
		taskList.put(3, new Task(1111, "Killing", 10, 2));
		taskList.put(4, new Task(2222, "Chopping", 5, 1));
		HashMap<Integer, Treatment> treatmentList = new HashMap<>();
		//Creating  treatment object and putting them task  hashmap
		treatmentList.put(5, new Treatment(33,1, 1111, 3));
		treatmentList.put(6, new Treatment(44, 2, 2222, 4));
		AnimalRecords animrec = new AnimalRecords(animalList, treatmentList, taskList);
		assertEquals("Wrong AnimalRecords animalList", animalList, animrec.getAnimalList());
		assertEquals("Wrong AnimalRecords taskList", taskList, animrec.getTaskList());
		assertEquals("Wrong AnimalRecords treatmentList", treatmentList, animrec.getTreatmentList());

	}
	
	@Test
	public void testAnimalRecordsGetAnimalList() {
		HashMap<Integer, Animal> animalList = new HashMap<>();
		animalList.put(1, new Animal(1, "Mike", "coyote"));
		animalList.put(2, new Animal(2, "Potter", "fox"));
		HashMap<Integer, Task> taskList = new HashMap<>();
		taskList.put(3, new Task(1111, "Killing", 10, 2));
		taskList.put(4, new Task(2222, "Chopping", 5, 1));
		HashMap<Integer, Treatment> treatmentList = new HashMap<>();
		treatmentList.put(5, new Treatment(33,3, 3333, 3));
		treatmentList.put(6, new Treatment(44, 4, 4444, 4));
		new AnimalRecords(animalList, treatmentList, taskList);
		HashMap<Integer, Animal> expected = animalList; 
		HashMap<Integer, Animal> actual = AnimalRecords.getAnimalList();
		assertEquals("Wrong AnimalRecords animalList", expected, actual);
	}
	
	@Test
	public void testAnimalRecordsGetTaskList() {
		HashMap<Integer, Animal> animalList = new HashMap<>();
		animalList.put(1, new Animal(1, "Mike", "coyote"));
		animalList.put(2, new Animal(2, "Potter", "fox"));
		HashMap<Integer, Task> taskList = new HashMap<>();
		taskList.put(3, new Task(1111, "Killing", 10, 2));
		taskList.put(4, new Task(2222, "Chopping", 5, 1));
		HashMap<Integer, Treatment> treatmentList = new HashMap<>();
		treatmentList.put(5, new Treatment(33,3, 3333, 3));
		treatmentList.put(6, new Treatment(44, 4, 4444, 4));
		new AnimalRecords(animalList, treatmentList, taskList);
		HashMap<Integer, Task> expected = taskList; 
		HashMap<Integer, Task> actual = AnimalRecords.getTaskList();
		assertEquals("Wrong AnimalRecords taskList", expected, actual);
	}
	
	@Test
	public void testAnimalRecordsSetAnimalList() {
		HashMap<Integer, Animal> animalList = new HashMap<>();
		animalList.put(1, new Animal(1, "Mike", "coyote"));
		animalList.put(2, new Animal(2, "Potter", "fox"));
		HashMap<Integer, Task> taskList = new HashMap<>();
		taskList.put(3, new Task(1111, "Killing", 10, 2));
		taskList.put(4, new Task(2222, "Chopping", 5, 1));
		HashMap<Integer, Treatment> treatmentList = new HashMap<>();
		treatmentList.put(5, new Treatment(33,3, 3333, 3));
		treatmentList.put(6, new Treatment(44, 4, 4444, 4));
		AnimalRecords animalRecords = new AnimalRecords(animalList, treatmentList, taskList);
		HashMap<Integer, Animal> newAnimalList = new HashMap<>();
		newAnimalList.put(10, new Animal(10, "Mike10", "coyote"));
		newAnimalList.put(2, new Animal(2, "Potter10", "fox"));
		HashMap<Integer, Animal> expected = newAnimalList;
		animalRecords.setAnimalList(newAnimalList);
		HashMap<Integer, Animal> actual = animalRecords.getAnimalList();
		assertEquals("Wrong AnimalRecords animalList", expected, actual);
	}
	
	@Test
	public void testAnimalRecordsSetTaskList() {
		HashMap<Integer, Animal> animalList = new HashMap<>();
		animalList.put(1, new Animal(1, "Mike", "coyote"));
		animalList.put(2, new Animal(2, "Potter", "fox"));
		HashMap<Integer, Task> taskList = new HashMap<>();
		taskList.put(3, new Task(1111, "Killing", 10, 2));
		taskList.put(4, new Task(2222, "Chopping", 5, 1));
		HashMap<Integer, Treatment> treatmentList = new HashMap<>();
		treatmentList.put(5, new Treatment(33,3, 3333, 3));
		treatmentList.put(6, new Treatment(44, 4, 4444, 4));
		AnimalRecords animalRecords = new AnimalRecords(animalList, treatmentList, taskList);
		HashMap<Integer, Task> newTaskList = new HashMap<>();
		newTaskList.put(11, new Task(8888, "Feeding", 20,12));
		newTaskList.put(12, new Task(9999, "Cleaning",10,10));
		HashMap<Integer, Task> expected = newTaskList;
		animalRecords.setTaskList(newTaskList);
		HashMap<Integer, Task> actual = animalRecords.getTaskList();
		assertEquals("Wrong AnimalRecords taskList", expected, actual);
	}
	
	@Test
	public void testAnimalRecordsSetTreatmentList() {
		HashMap<Integer, Animal> animalList = new HashMap<>();
		animalList.put(1, new Animal(1, "Mike", "coyote"));
		animalList.put(2, new Animal(2, "Potter", "fox"));
		HashMap<Integer, Task> taskList = new HashMap<>();
		taskList.put(3, new Task(1111, "Killing", 10, 2));
		taskList.put(4, new Task(2222, "Chopping", 5, 1));
		HashMap<Integer, Treatment> treatmentList = new HashMap<>();
		treatmentList.put(5, new Treatment(33,3, 3333, 3));
		treatmentList.put(6, new Treatment(44, 4, 4444, 4));
		AnimalRecords animalRecords = new AnimalRecords(animalList, treatmentList, taskList);
		HashMap<Integer, Treatment> newTreatmentList = new HashMap<>();
		newTreatmentList.put(15, new Treatment(66, 6, 6666, 15 ));
		newTreatmentList.put(16, new Treatment(77, 7, 7777, 20 ));
		HashMap<Integer, Treatment> expected = newTreatmentList;
		animalRecords.setTreatmentList(newTreatmentList);
		HashMap<Integer, Treatment> actual = animalRecords.getTreatmentList();
		assertEquals("Wrong AnimalRecords treatmentList", expected, actual);
	}
	
	@Test
	public void testAnimalRecordsGetTreatmentList() {
		HashMap<Integer, Animal> animalList = new HashMap<>();
		animalList.put(1, new Animal(1, "Mike", "coyote"));
		animalList.put(2, new Animal(2, "Potter", "fox"));
		HashMap<Integer, Task> taskList = new HashMap<>();
		taskList.put(3, new Task(1111, "Killing", 10, 2));
		taskList.put(4, new Task(2222, "Chopping", 5, 1));
		HashMap<Integer, Treatment> treatmentList = new HashMap<>();
		treatmentList.put(5, new Treatment(33,3, 3333, 3));
		treatmentList.put(6, new Treatment(44, 4, 4444, 4));
		new AnimalRecords(animalList, treatmentList, taskList);
		HashMap<Integer, Treatment> expected = treatmentList; 
		HashMap<Integer, Treatment> actual = AnimalRecords.getTreatmentList();;
		assertEquals("Wrong AnimalRecords treatmentList", expected, actual);
	}
}
