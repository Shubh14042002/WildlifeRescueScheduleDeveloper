package edu.ucalgary.oop;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.HashMap;
import java.util.Map;


import java.util.ArrayList;
import java.util.regex.*;

public class TestAnimalClass {

	@Test
	public void testAnimalConstructor() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		assertEquals("Wrong Animal AnimalID",1, testAnimal.getAnimalID());
		assertEquals("Wrong Animal AnimalNickName","TestedAnimal", testAnimal.getAnimalNickname());
		assertEquals("Wrong Animal AnimalType","coyote", testAnimal.getAnimalType());
		
		assertEquals("Wrong Animal FeedingStartHour",19, testAnimal.getFeedingStartHour());
		assertEquals("Wrong Animal FeedingPreparationTime", 10, testAnimal.getFeedPrepDuration());
		assertEquals("Wrong Animal AnimalSpecies","crepuscular", testAnimal.getAnimalSpecies());
		assertEquals("Wrong Animal AnimalFeedEndHour",22, testAnimal.calculateFeedEndHour());
		assertFalse(testAnimal.isOrphanAnimal());	
	}

	@Test
	public void testAnimalCalculateFeedEndHour() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		int expected = testAnimal.getFeedingStartHour() + 3;
		int actual = testAnimal.calculateFeedEndHour();
		assertEquals("Wrong Animal FeedEndHour", expected, actual);
	}
	
	@Test 
	public void testAnimalGetAnimalID() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		int expected = 1;
		int actual = testAnimal.getAnimalID();
		assertEquals("Wrong Animal AnimalID", expected, actual);
	}
	
	@Test
	public void testAnimalGetAnimalNickname() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		String expected = "TestedAnimal";
		String actual = testAnimal.getAnimalNickname();
		assertEquals("Wrong Animal AnimalNickname", expected, actual);
	}
	
	@Test
	public void testAnimalGetAnimalSpecies() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		String expected = "crepuscular";
		String actual = testAnimal.getAnimalSpecies();
		assertEquals("Wrong Animal AnimalSpecies", expected, actual);
	}
	
	@Test
	public void testAnimalGetTasks() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		Task[] tasks = new Task[1];
		tasks[0] = new Task(1111, "Cleaning", 10, 3);
		testAnimal.setTasks(tasks);
		Task[] expected = tasks;
		Task[] actual = testAnimal.getTasks();
		assertArrayEquals("Wrong Animal Tasks", expected, actual);
	}
	
	@Test
	public void testAnimalGetTreatments() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		Treatment[] treatments = new Treatment[1];
		treatments[0] = new Treatment(11, testAnimal.getAnimalID(),2222,4);
		testAnimal.setTreatments(treatments);
		Treatment[] expected = treatments;
		Treatment[] actual = testAnimal.getTreatments();
		assertArrayEquals("Wrong Animal Treatments", expected, actual);
	}
	
	@Test
	public void testAnimalSetAnimalID() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		testAnimal.setAnimalID(5);
		int expected = 5;
		int actual = testAnimal.getAnimalID();
		assertEquals("Wrong Animal AnimalID", expected, actual);
	}
	
	@Test
	public void testAnimalSetAnimalNickname() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		testAnimal.setAnimalNickname("new nickname");
		String expected = "new nickname";
		String actual = testAnimal.getAnimalNickname();
		assertEquals("Wrong Animal AnimalNickname", expected, actual);	
	}
	
	@Test
	public void testAnimalSetAnimalType() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		testAnimal.setAnimalType("fox");
		String expected = "fox";
		String actual = testAnimal.getAnimalType();
		assertEquals("Wrong Animal AnimalType", expected, actual);
	}

	@Test
	public void testAnimalSetTasks() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		Task[] tasks = new Task[1];
		tasks[0] = new Task(1111, "Cleaning", 10, 3);
		testAnimal.setTasks(tasks);
		Task[] expected = tasks;
		Task[] actual = testAnimal.getTasks();
		assertArrayEquals("Wrong Animal Tasks", expected, actual);
	}
	@Test
	public void testAnimalSetTreatments() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		Treatment[] treatments = new Treatment[1];
		treatments[0] = new Treatment(11, testAnimal.getAnimalID(),2222,4);
		testAnimal.setTreatments(treatments);
		Treatment[] expected = treatments;
		Treatment[] actual = testAnimal.getTreatments();
		assertArrayEquals("Wrong Animal Treatments", expected, actual);
	}
	
	@Test
	public void testAnimalSetAnimalSpecies() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		String expected = "porcupine";
		testAnimal.setAnimalSpecies(expected);
		String actual = testAnimal.getAnimalSpecies();
		assertEquals("Wrong Animal AnimalSpecies", expected, actual);
	}
	
	@Test
	public void testAnimalGetCageCleanDuration() {
		Animal testAnimal = new Animal(1,"TestedAnimal","porcupine");
		int expected = 10;
		int actual = testAnimal.getCageCleanDuration();
		assertEquals("Wrong Animal CageCleanDuration", expected, actual);
	}
	
	@Test
	public void testAnimalGetFeedingDuration() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		int expected = 5;
		int actual = testAnimal.getFeedingDuration();
		assertEquals("Wrong Animal FeedingDuration", expected, actual);
	}
	
	@Test
	public void testAnimalGetFeedingStartHour() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		int expected = 19;
		int actual = testAnimal.getFeedingStartHour();
		assertEquals("Wrong Animal FeedingStartHour", expected, actual);
	}
	
	@Test
	public void testAnimalGetFeedPrepDuration() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		int expected = 10;
		int actual = testAnimal.getFeedPrepDuration();
		assertEquals("Wrong Animal FeedPrepTime", expected, actual);
	}
	
	@Test
	public void testAnimalIsBeenFed() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		testAnimal.setBeenFed(false);
		assertFalse("not fed", testAnimal.isBeenFed());
		testAnimal.setBeenFed(true);
		assertTrue("Been fed", testAnimal.isBeenFed());
	}
	
	@Test
	public void testAnimalGetAnimalType() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		String expected = "coyote";
		String actual = testAnimal.getAnimalType();
		assertEquals("Wrong Animal AnimalType", expected, actual);
	}
	
	@Test
	public void testAnimalIsCageCleaned() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		testAnimal.setCageCleaned(false);
		assertFalse("Not cleaned", testAnimal.isCageCleaned());
		testAnimal.setCageCleaned(true);
		assertTrue("Cleaned", testAnimal.isCageCleaned());
	}
	
	@Test
	public void testAnimalSetBeenFed() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		testAnimal.setBeenFed(false);
		assertFalse("Not fed", testAnimal.isBeenFed());
		testAnimal.setBeenFed(true);
		assertTrue("Fed", testAnimal.isBeenFed());
	}
	
	@Test
	public void testAnimalSetCageCleanDuration() {
		Animal testAnimal = new Animal(1,"TestedAnimal","porcupine");
		int expected = 50;
		testAnimal.setCageCleanDuration(expected);
		int actual = testAnimal.getCageCleanDuration();
		assertEquals("Wrong Animal CageCleanDuration", expected, actual);
	}
	
	@Test
	public void testAnimalSetCageCleaned() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		testAnimal.setCageCleaned(false);
		assertFalse("Not cleaned", testAnimal.isCageCleaned());
		testAnimal.setCageCleaned(true);
		assertTrue("Cleaned", testAnimal.isCageCleaned());
	}
	
	@Test
	public void testAnimalSetFeedingStartHour() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		int expected = 30;
		testAnimal.setFeedingStartHour(expected);
		int actual = testAnimal.getFeedingStartHour();
		assertEquals("Wrong Animal FeedingStartHour", expected, actual);
	}
	
	@Test
	public void testAnimalSetFeedPrepDuration() {
		Animal testAnimal = new Animal(1,"TestedAnimal","coyote");
		int expected = 20;
		testAnimal.setFeedPrepDuration(expected);
		int actual = testAnimal.getFeedPrepDuration();
		assertEquals("Wrong Animal FeedPrepTime", expected, actual);
	}
	
	@Test
	public void testAnimalIsOrphanAnimal() {
		Animal testAnimal1 = new Animal(1,"Annie, Oliver and Mowgli","coyote");
		Treatment treat = new Treatment(1, 1 ,1 ,1);
		Task task = new Task(1, "feeding", 2, 2);
		HashMap<Integer,Animal> animlist = new HashMap<>();
		animlist.put(1, testAnimal1);
		HashMap<Integer,Task> tasklist = new HashMap<>();
		tasklist.put(1, task);
		HashMap<Integer,Treatment> treatlist = new HashMap<>();
		treatlist.put(1, treat);
		AnimalRecords animrec = new AnimalRecords(animlist, treatlist, tasklist);

		assertTrue("Is orphan", testAnimal1.isOrphanAnimal());
		// Animal testAnimal2 = new Animal(1,"TestedAnimal","coyote");
		// assertFalse("Not orphan", testAnimal2.isOrphanAnimal());
	}
	
	
		
}
