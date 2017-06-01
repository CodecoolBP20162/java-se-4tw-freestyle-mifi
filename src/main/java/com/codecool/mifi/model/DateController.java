package com.codecool.mifi.model;

import com.codecool.mifi.dao.Implementation.StudentDaoMem;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Created by marti on 2017.05.31..
 */
public class DateController {

    private User user;
    private Stack femaleStack;
    private Stack maleStack;
    private Location place;
    private DateTime time;
    private Student partner;
    private List<DateTime> dateTimeList = new ArrayList<>();
    private List<Location> locationList = new ArrayList<>();
    public static List<Student> studentList = new ArrayList<>();

    public DateController(User user) throws FileNotFoundException {
        this.user = user;
        time = generateDateTime();
        partner = generatePartner(user);
        place = generateLocation();
    }

    private void populatedateTimeList() {
        dateTimeList.add(new DateTime("Monday 3am"));
        dateTimeList.add(new DateTime("Tuesday, 1pm"));
        dateTimeList.add(new DateTime("Wednesday, 5pm"));
        dateTimeList.add(new DateTime("Thursday, 9pm"));
        dateTimeList.add(new DateTime("Friday, midnight"));
    }

    private void populateLocationList() {
        locationList.add(new Location("Felni"));
        locationList.add(new Location("Roof Terrace"));
        locationList.add(new Location("White Room"));
        locationList.add(new Location("Red Room"));
        locationList.add(new Location("Blue Room"));
        locationList.add(new Location("Garage"));
        locationList.add(new Location("Kitchen"));
        locationList.add(new Location("Meeting Room"));
    }
    
    private DateTime generateDateTime() {
        populatedateTimeList();
        Random random = new Random();
        int randomDateTime = random.nextInt(dateTimeList.size());
        return dateTimeList.get(randomDateTime);
        
    }
    
    private Location generateLocation() {
        populateLocationList();
        Random random = new Random();
        int randomLocation = random.nextInt(locationList.size());
        return locationList.get(randomLocation);
    }

    public static String read(String filePath) throws FileNotFoundException {
        String content = new Scanner(new File(filePath)).useDelimiter("\\Z").next();
        return content;
    }

    public static List<Student> getStudentList() throws FileNotFoundException {
        String lines = read("Students.csv");
        String[] splitLines = lines.split("\n");
        for (String student : splitLines) {
            String name = student.split(",")[0];
            String gender = student.split(",")[1];
            studentList.add(new Student(name,gender,new CcClass("Budapest",2)));
        }
        return studentList;
    }

    private StudentDaoMem populateStack(List<Student> studentList) {
        StudentDaoMem studentDaoMem = new StudentDaoMem();
        Random random = new Random();
        List<Integer> randomIndexList = new ArrayList<>();
        int counter = 0;
        while (counter < studentList.size()-1) {
            int randomIndex = random.nextInt(studentList.size());
            if (!randomIndexList.contains(randomIndex)) {
                randomIndexList.add(randomIndex);
                if (studentList.get(randomIndex).getGender().equals("female")) {
                    studentDaoMem.add(studentList.get(randomIndex), studentDaoMem.getAll("female"));
                    counter++;
                }else{
                    studentDaoMem.add(studentList.get(randomIndex), studentDaoMem.getAll("male"));
                    counter++;
                }
            }else {
                continue;
            }
        }
        return studentDaoMem;
    }

    private Student generatePartner(User user) throws FileNotFoundException {
        populateStack(getStudentList());
        Stack partnerStack;
        if (user.getGender() == "female"){
            partnerStack = populateStack(getStudentList()).getAll("male");
        }else{
            partnerStack = populateStack(getStudentList()).getAll("female");
        }
        Random random = new Random();
        int randomPartner = random.nextInt(partnerStack.size());
        return (Student) partnerStack.get(randomPartner);
    }

    @Override
    public String toString() {
        return "date{" +
                "you =" + user.getName() +
                ", place =" + place.toString() +
                ", time =" + time.toString() +
                ", your partner =" + partner.getName() +
                '}';
    }
}
