/**
 * @Title: Coin Change Program
 * @Author: Vernice
 * Date: 11 October 2024
 * File Name: Client.java
 * Purpose: This class will collect input from user and perform various calculations.
 * Pre Assumptions and Post Assumptions: Names are one-word strings, and coin values are divisible by 5.
**/

import java.util.Scanner;

public class Client {
    // Maximum number of persons we will store
    private static final int MAX_PERSONS = 10;

    public static void StudentInfo() {
        System.out.println("Name: Vernice Foong");
        System.out.println("Student number: CT0378555");
        System.out.println("Mode of enrolment: Part Time");
        System.out.println("Tutor name: Jaikishin Kishinchand Lakhyani\n");
    }

    public static void main(String[] args) {

        // The array to store up to MAX_PERSONS Change objects
        Change[] changeRecords = new Change[MAX_PERSONS];
        int numRecords = 0;  // Track how many records stored

        Scanner scanner = new Scanner(System.in);
        boolean moreData = true;

        // Display my student info
        StudentInfo();

        // Test Data !!
        // numRecords = TestData.RunTestRecords(changeRecords);

        // Input loop to add data
        while (moreData && numRecords < MAX_PERSONS) {
            System.out.print("Enter the name of the person: ");
            String name = scanner.next();

            System.out.print("Enter the coin value in cents (In multiple of 5): ");
            String inputValue = scanner.next();
            int coinValue = Utils.ParseIntOrNull(inputValue);
            if (coinValue > 0) {
                // Validate that the coin value is divisible by 5
                if (coinValue % 5 != 0) {
                    System.out.println("Invalid coin value. In multiple of 5.");
                    continue;
                }

                // Check if the person already exists in the array
                boolean found = false;
                for (int v = 0; v < numRecords; v++) {
                    if (changeRecords[v].getName().equals(name)) {
                        // If person exists, so the coin value is added to their total
                        changeRecords[v].addAmount(coinValue);
                        found = true;
                        break;
                    }
                }

                // If person is new, add a new Change object
                if (!found) {
                    changeRecords[numRecords] = new Change(name, coinValue);  // Create new object
                    numRecords++;
                }

                // Ask if the user wants to add more data
                System.out.print("Do you want to add more data (Y/N)? ");
                moreData = scanner.next().equalsIgnoreCase("Y");
            } else {
                // Invalid Coin Value
                System.out.print("Invalid Coin value! \n");
            }
        }

        // Menu for operations like displaying breakdowns, finding largest/smallest total, etc.
        boolean exit = false;
        while (!exit) {
            System.out.println("\nMenu:");
            System.out.println("1. Display breakdown by name");
            System.out.println("2. Find name with largest total");
            System.out.println("3. Find name with smallest total");
            System.out.println("4. Calculate total number of coins per denomination");
            System.out.println("5. Display total amount");
            System.out.println("6. Exit\n");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            //Switch statement to support the user menu choices
            switch (choice) {
                case 1:
                    System.out.print("Enter the name: ");
                    String searchName = scanner.next();
                    Change person = Utils.searchName(numRecords, changeRecords, searchName);
                    if (person != null) {
                        person.displayChangeBreakdown();
                    } else {
                        System.out.println("Name " + searchName + " not found.");
                    }
                    break;

                case 2:
                    // Find person with largest total
                    Change largest = Change.CalculateLargestTotal(numRecords, changeRecords);
                    if (largest != null) {
                         System.out.print("Largest total for " + largest.getName() + "\n");
                        largest.displayChangeBreakdown();
                    } else {
                        System.out.println("No largest record found!");
                    }
                    break;

                case 3:
                    // Find person with smallest total
                    Change smallest = Change.CalculateSmallestTotal(numRecords, changeRecords);
                    if (smallest != null) {
                        System.out.print("Smallest total for " + smallest.getName() + "\n");
                        smallest.displayChangeBreakdown();
                    } else {
                        System.out.println("No smallest record found!");
                    }
                    break;

                case 4:
                    Change denomination = new Change();
                    denomination.calculateTotalCoinsPerDenomination(changeRecords,numRecords);
                    break;

                case 5:
                    Change.CalculateTotalAmount(numRecords,changeRecords);
                    break;

                case 6:
                    System.out.println("Exiting. Have a nice day!:) ");
                    exit = true;
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }

        scanner.close();
    }

}
