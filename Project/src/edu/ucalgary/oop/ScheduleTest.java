package edu.ucalgary.oop;


import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.*;

public class ScheduleTest {
    @Test
    /*
    Two tasks with 45 minute duration and 2 hour window should be scheduled for the two separate hours
     */
    public void testTwoHourWindow() throws IllegalScheduleException {
        HashMap<Integer, Treatment> treatmentList = new HashMap<>();
        HashMap<Integer, Animal> animalList = new HashMap<>();
        HashMap<Integer, Task> taskList = new HashMap<>();

        taskList.put(1, new Task(1, "Task1", 45, 2));
        treatmentList.put(1, new Treatment(1, 1, 1, 12));
        treatmentList.put(2, new Treatment(2, 1, 1, 12));
        animalList.put(1, new Animal(1, "Bob", "coyote"));

        new AnimalRecords(animalList, treatmentList, taskList);
        boolean c1 = false;
        if (new Schedule().getTheSchedule().get(12).get(1).contains("Task1") && new Schedule().getTheSchedule().get(13).get(1).contains("Task1")){
            c1 = true;
        }
        assertTrue("Task isn't split between 2 hours ", c1);
    }

    @Test
    /*
    Two tasks with 45 minute duration and 1 hour window should be scheduled for the same hour and call backup volunteer
     */
    public void testBackupVolunteer() throws IllegalScheduleException {
        HashMap<Integer, Treatment> treatmentList = new HashMap<>();
        HashMap<Integer, Animal> animalList = new HashMap<>();
        HashMap<Integer, Task> taskList = new HashMap<>();

        taskList.put(1, new Task(1, "Task1", 45, 1));
        treatmentList.put(1, new Treatment(1, 1, 1, 12));
        treatmentList.put(2, new Treatment(2, 1, 1, 12));
        animalList.put(1, new Animal(1, "Bob", "coyote"));

        new AnimalRecords(animalList, treatmentList, taskList);
        boolean c1 = false;
        boolean c2 = false;
        if (new Schedule().getTheSchedule().get(12).get(1).contains("Task1") && new Schedule().getTheSchedule().get(12).get(2).contains("Task1")){
            c1 = true;
        }
        if (new Schedule().getTheSchedule().get(12).get(0).contains("backup")){
            c2 = true;
        }
        assertTrue("Task isn't split between 2 hours ", c1&&c2);
    }

    @Test
    /*
    Three tasks with 45 minute duration and 1 hour window should return
     */
    public void testThrowExceptionWithTooManyTreatments() {
        HashMap<Integer, Treatment> treatmentList = new HashMap<>();
        HashMap<Integer, Animal> animalList = new HashMap<>();
        HashMap<Integer, Task> taskList = new HashMap<>();

        taskList.put(1, new Task(1, "Task1", 45, 1));
        treatmentList.put(1, new Treatment(1, 1, 1, 12));
        treatmentList.put(2, new Treatment(2, 1, 1, 12));
        treatmentList.put(3, new Treatment(3, 1, 1, 12));
        animalList.put(1, new Animal(1, "Bob", "coyote"));

        new AnimalRecords(animalList, treatmentList, taskList);
        boolean c1 = false;
        try {
            new Schedule();
        }
        catch(IllegalScheduleException e){
            c1 = true;
        }
        catch(Exception e){
        }
        assertTrue("Schedule does not throw IllegalScheduleException when given treatments that cannot be all done within hour", c1);
    }

    @Test
    /*
    Check to see if treatmentID 1's animal is considered an orphan
     */
    public void testIsOrphan(){
        HashMap<Integer, Treatment> treatmentList = new HashMap<>();
        HashMap<Integer, Animal> animalList = new HashMap<>();
        HashMap<Integer, Task> taskList = new HashMap<>();

        taskList.put(1, new Task(1, "Task1", 45, 1));
        treatmentList.put(1, new Treatment(1, 1, 1, 12));
        animalList.put(1, new Animal(1, "Bob", "coyote"));

        new AnimalRecords(animalList, treatmentList, taskList);
        assertTrue("TreatmentID 1's animal is not considered an orphan", animalList.get(1).isOrphanAnimal());
    }
    @Test
    /*
    Check to see if orphan's feeding task is considered only a medical task
     */
    public void testOrphanNotConsideredFeedingTask(){
        HashMap<Integer, Treatment> treatmentList = new HashMap<>();
        HashMap<Integer, Animal> animalList = new HashMap<>();
        HashMap<Integer, Task> taskList = new HashMap<>();

        taskList.put(1, new Task(1, "Task1", 45, 1));
        treatmentList.put(1, new Treatment(1, 1, 1, 12));
        animalList.put(1, new Animal(1, "Bob", "coyote"));

        new AnimalRecords(animalList, treatmentList, taskList);

        boolean c1 = false;
        try {
            c1 = new Schedule().toString().contains("Feeding");
        }
        catch(Exception e){
        }
        assertFalse("Regular feeding task should not be in tasks for orphans", c1);
    }

    @Test
    /*
    Check if every animal's cage has been cleaned
     */
    public void allCagesCleaned(){
        HashMap<Integer, Treatment> treatmentList = new HashMap<>();
        HashMap<Integer, Animal> animalList = new HashMap<>();
        HashMap<Integer, Task> taskList = new HashMap<>();

        animalList.put(1, new Animal(1, "Bob", "coyote"));
        animalList.put(2, new Animal(2, "Bartholomew", "coyote"));
        animalList.put(3, new Animal(3, "Mark", "porcupine"));
        animalList.put(4, new Animal(4, "Josh", "beaver"));

        new AnimalRecords(animalList, treatmentList, taskList);

        boolean c1 = true;
        String theString = "";
        try {
            theString = new Schedule().toString();
        }
        catch(Exception e){
        }
        for(int i = 1; i <= 4; i++){
            if(!theString.contains("Cage Cleaning - " + animalList.get(i).getAnimalNickname())){
                c1 = false;
            }
        }
        assertTrue("Cage Cleaning Tasks for all Animals are not all added", c1);
    }

    @Test
    /*
    Check if every animal's cage has been cleaned
     */
    public void allTreatmentsDone(){
        HashMap<Integer, Treatment> treatmentList = new HashMap<>();
        HashMap<Integer, Animal> animalList = new HashMap<>();
        HashMap<Integer, Task> taskList = new HashMap<>();

        taskList.put(1, new Task(1, "Task1", 45, 2));
        taskList.put(2, new Task(2, "Task2", 45, 2));
        taskList.put(3, new Task(3, "Task3", 45, 2));
        treatmentList.put(1, new Treatment(1, 1, 1, 12));
        treatmentList.put(2, new Treatment(2, 2, 2, 13));
        treatmentList.put(3, new Treatment(3, 1, 3, 14));
        treatmentList.put(4, new Treatment(4, 2, 1, 15));
        treatmentList.put(5, new Treatment(5, 1, 2, 16));
        animalList.put(1, new Animal(1, "Bob", "coyote"));
        animalList.put(2, new Animal(2, "Bartholomew", "porcupine"));


        new AnimalRecords(animalList, treatmentList, taskList);

        boolean c1 = true;
        String theString = "";
        try {
            theString = new Schedule().toString();
        }
        catch(Exception e){
        }
        for(int i = 1; i <= 5; i++){
            if(!theString.contains(taskList.get(treatmentList.get(i).getTaskID()).getDescription())){
                c1 = false;
            }
        }
        assertTrue("Not all treatments added properly", c1);
    }
    @Test
    /*
    Check if every animal has been fed
     */
    public void allAnimalsFed(){
        HashMap<Integer, Treatment> treatmentList = new HashMap<>();
        HashMap<Integer, Animal> animalList = new HashMap<>();
        HashMap<Integer, Task> taskList = new HashMap<>();

        animalList.put(1, new Animal(1, "Bob", "coyote"));
        animalList.put(2, new Animal(2, "Bartholomew", "porcupine"));
        animalList.put(3, new Animal(3, "Barth", "porcupine"));
        animalList.put(4, new Animal(4, "Josh", "coyote"));
        animalList.put(5, new Animal(5, "Drake", "beaver"));
        animalList.put(6, new Animal(6, "George", "porcupine"));

        new AnimalRecords(animalList, treatmentList, taskList);

        boolean c1 = true;
        String theString = "";
        try {
            theString = new Schedule().toString();
        }
        catch(Exception e){
        }
        for(int i = 1; i <= 6; i++){
            theString = theString.replace("Cage Cleaning - " + animalList.get(i).getAnimalNickname(), "");
            if(!theString.contains(animalList.get(i).getAnimalNickname())){
                c1 = false;
            }
        }
        System.out.println(theString);
        assertTrue("Not all animal feeding tasks added properly", c1);
    }

    @Test
    /*
    Check if every animal has been fed
     */
    public void testThrowsExceptionWithTooManyFeeding(){
        HashMap<Integer, Treatment> treatmentList = new HashMap<>();
        HashMap<Integer, Animal> animalList = new HashMap<>();
        HashMap<Integer, Task> taskList = new HashMap<>();

        taskList.put(1, new Task(1, "Task1", 60, 1));
        taskList.put(2, new Task(2, "Task2", 30, 1));
        treatmentList.put(2, new Treatment(2, 1, 1, 19));
        treatmentList.put(3, new Treatment(3, 1, 1, 20));
        treatmentList.put(4, new Treatment(4, 1, 2, 21));

        animalList.put(1, new Animal(1, "Bob", "coyote"));
        animalList.put(2, new Animal(2, "Bartholomew", "coyote"));
        animalList.put(3, new Animal(3, "Bartholomew", "coyote"));
    }
}
