package edu.ucalgary.oop;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.*;

public class Main {
    //For Testing Purposes
    public static void main(String[] args) throws IllegalScheduleException {
        DatabaseConnector dc = new DatabaseConnector();

        new GUI();
    }
}
