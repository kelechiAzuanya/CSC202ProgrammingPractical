/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlstructure;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author K.C
 */
public class ControlStructure {

    /**
     * @param args the command line arguments
     */
    public static Map<String, Integer> StudentRecord = new HashMap<>();
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        startUp();

    }

    public static void printStudentDetail() {
        System.out.println("STUDENT NAME" + "\t" + "STUDENT SCORE");
        int sum = 0;
        for (Map.Entry<String, Integer> entry : StudentRecord.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            sum += value;
            System.out.println(key + "       \t" + value);

        }
        //Get the sum of the whole numbers
        System.out.println("The total Sum of the Student Score =" + sum);
        //Get the Average of Student Score
        int mapCount = StudentRecord.size();
        float Average = sum / mapCount;
        System.out.println("Average of Students Score= " + Average);
    }

    public static void inputStudentDetail() {
        for (int i = 0; i < 2; i++) {
            String name;
            int score;
            System.out.println("Enter the Student Name");
            name = in.next();
            System.out.println("Enter Student Score");
            score = in.nextInt();
            StudentRecord.put(name, score);
        }
        printStudentDetail();
    }

    //Enhancement of this code
    public static void startUp() {
        System.out.println("***Welcome***" + "\n" + "To Record Students Detail Press 1" + "\n"
                + "To Search Students Detail Press 2 " + "\n"+ "To Exit Press 3 ");
        int option = in.nextInt();
        switch (option) {
            case 1:
                //call InputStudentDetail
                inputStudentDetail();
                startUp();
                break;
            case 2:
                //call searchStudentDetail
                searchStudentDetail();
                startUp();
                break;
            case 3:
                //exit
                System.exit(0);
            default:
                System.out.println("Enter the Correct Value");
                startUp();
        }

    }

    public static void searchStudentDetail() {
        System.out.println("Enter Student Name to Search");
        String name = in.next();
        System.out.println("Searching...");
        if (StudentRecord.containsKey(name)) {
            System.out.println("Detail found...Name: " + name + " " + "Score: "+StudentRecord.get(name));
        } else {
            System.out.println("name not found");
        }
    }
}
