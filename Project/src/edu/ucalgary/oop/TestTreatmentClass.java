package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;


import java.util.ArrayList;
import java.util.regex.*;

public class TestTreatmentClass {
	
	@Test
	public void testTreatmentConstructor() {
		Treatment treatment = new Treatment(11,1,1111,4);
		assertEquals("Wrong Treatment TreatmentID", 11, treatment.getTreatmentID());
		assertEquals("Wrong Treatment AnimalID", 1, treatment.getAnimalID());
		assertEquals("Wrong Treatment TaskID", 1111, treatment.getTaskID());
		assertEquals("Wrong Treatment StartHour", 4, treatment.getStartHour());
	}

	@Test
	public void testTreatmentCalculateEndHour() {
		HashMap<Integer, Animal> animalList = new HashMap<>();
		animalList.put(1, new Animal(1, "Mike", "coyote"));
		HashMap<Integer, Task> taskList = new HashMap<>();
		taskList.put(1111, new Task(1111, "Killing", 10, 2));
		HashMap<Integer, Treatment> treatmentList = new HashMap<>();
		Treatment treat = new Treatment(5,1, 1111, 3);
		treatmentList.put(5,treat );
		AnimalRecords animrec = new AnimalRecords(animalList, treatmentList, taskList);
		int expected = 3 + 2;
		int actual = animrec.getTreatmentList().get(5).calculateEndHour();
		assertEquals("Wrong End Hour",expected,actual);
	}
	
	@Test
	public void testTreatmentSetTreatmentID() {
		Treatment treatment = new Treatment(11,1,1111,4);
		int expected = 22;
		treatment.setTreatmentID(expected);
		int actual = treatment.getTreatmentID();
		assertEquals("Treatment TreatmentID is wrong", expected, actual);
	}
	
	@Test
	public void testTreatmentSetAnimalID() {
		Treatment treatment = new Treatment(11,1,1111,4);
		int expected = 2;
		treatment.setAnimalID(expected);
		int actual = treatment.getAnimalID();
		assertEquals("Wrong Treatment AnimalID", expected, actual);
	}
	
	@Test
	public void  testTreatmentSetTaskID() {
		Treatment treatment = new Treatment(11,1,1111,4);
		int expected = 2222;
		treatment.setTaskID(expected);
		int actual = treatment.getTaskID();
		assertEquals("Wrong Treatment TaskID", expected, actual);
	}
	
	@Test
	public void testTreatmentSetStartHour() {
		Treatment treatment = new Treatment(11,1,1111,4);
		int expected = 8;
		treatment.setStartHour(expected);
		int actual = treatment.getStartHour();
		assertEquals("Wrong Treatment StartHour", expected, actual);
	}
	
	@Test
	public void testTreatmentGetTreatmentID() {
		Treatment treatment = new Treatment(11,1,1111,4);
		int expected = 11;
		int actual = treatment.getTreatmentID();
		assertEquals("Wrong Treatment TreatmentID", expected, actual);
	}
	
	@Test
	public void testTreatmentGetAnimalID() {
		Treatment treatment = new Treatment(11,1,1111,4);
		int expected = 1;
		int actual = treatment.getAnimalID();
		assertEquals("Wrong Treatment AnimalID", expected, actual);
	}
	
	@Test
	public void testTreatmentGetTaskID() {
		Treatment treatment = new Treatment(11,1,1111,4);
		int expected = 1111;
		int actual = treatment.getTaskID();
		assertEquals("Wrong Treatment TaskID", expected, actual);
	}
	
	@Test
	public void testTreatmentGetStartHour() {
		Treatment treatment = new Treatment(11,1,1111,4);
		int expected = 4;
		int actual = treatment.getStartHour();
		assertEquals("Wrong Treatment StartHour", expected, actual);
	}
}
