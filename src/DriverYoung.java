import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileNotFoundException;

/**
 * CSC 1600 Data Structures
 * CH2 Programming Lab
 *
 * The DriverYoung class implements the NoDuplicatesQueueYoung class. It represents a problem where a ferry takes
 * vehicles across the river from the left side to the right. The input for the example comes from the test.txt
 * file. The first line represents the ferry length followed by the number of vehicles waiting. Each line after
 * represents each vehicle. Each line that represents a vehicle starts with the vehicle length followed by the side the
 * vehicle is on and then the type of vehicle (CAR, TRUCK, POLICE) and finally a 3 digit vin number. The vin number
 * helps in making it impossible for duplicate cars on the ferry at once. If the vehicle is of type POLICE, AMBULANCE,
 * or FIRETRUCK it gets pushed to the back of the line on its side since the it is only crossing for vehicle maintenance
 * and not an emergency. This way people going to work aren't held up by vehicles not. The Ferry always starts on the
 * left side of the river.
 *
 * Project Description:
 *
 * Consider a new kind of queue that allows only a single copy of an object in the queue. If an object is added to the
 * queue, but it is already there, leave the queue unchanged. This queue has another operation moveToBack that takes
 * an object in the queue and moves it to the back. If an object is not in the queue, the operation adds it at the back
 * of the queue. The size of queue should increase if it is full.
 * S
 * Create an interface NoDuplicatesQueueInterface that extends QueueInterface and save as
 * NoDuplicatesQueueInterfaceYourLastName.java. Then write an array-based implementation of NoDuplicatesQueue and save
 * as NoDuplicatesQueueYourLastName.java. Finally, write a program that adequately demonstrates your new class and save
 * as DriverYourLastName.java. *
 *
 * @author Brandon Young
 */
// File Name: DriverYoung.java
public class DriverYoung {
    public static void main(String[] args) {

        // Holds the name of the test file
        final String FILE_NAME = "test.txt";
        // Holds the current side the ferry is on from the file
        String ferrySide;
        // Holds the length of the ferry in feet
        int ferryLength;
        // Holds the length of the current car in feet
        int vehicleLength;
        // Holds the type of the current vehicle
        VehicleType vehicleType;
        // Holds the number of lines in the file
        int lines;
        // Holds the current side of the vehicle
        String vehicleSide;
        // Holds the vin number of the current Vehicle
        String vehicleVin;
        // Holds the leftLine
        NoDuplicatesQueueYoung leftLine = new NoDuplicatesQueueYoung();
        // Holds the right line
        NoDuplicatesQueueYoung rightLine = new NoDuplicatesQueueYoung();

        Scanner buffer;

        File fileIn = new File(FILE_NAME);
        if (!fileIn.exists()) {
            System.out.println("File does not exist. Please place the dictionary file in the root folder of the program.");
        } // end if

        try {
            buffer = new Scanner(fileIn);

            while(buffer.hasNext()) {
                // Gets the ferry length and number of cars waiting
                ferryLength = buffer.nextInt();
                lines = buffer.nextInt();
                // Holds the count to print the number of vehicles that actually crossed
                int count = 0;
                for (int index = 0; index < lines; index++) {

                    // Clears the left Queue for each sub problem
                    leftLine.clear();
                    // Clears the right Queue for each sub problem
                    rightLine.clear();
                    vehicleLength = buffer.nextInt();
                    vehicleSide = buffer.next();
                    // holds the temporary vehicle Type as a Sting to convert to Enum VehicleType
                    String type = buffer.next();
                    switch (type) {
                        case "CAR":
                            vehicleType = VehicleType.CAR;
                            break;
                        case "TRUCK":
                            vehicleType = VehicleType.TRUCK;
                            break;
                        case "VAN":
                            vehicleType = VehicleType.VAN;
                            break;
                        case "POLICE":
                            vehicleType = VehicleType.POLICE;
                            break;
                        case "FIRETRUCK":
                            vehicleType = VehicleType.FIRETRUCK;
                            break;
                        case "AMBULANCE":
                            vehicleType = VehicleType.AMBULANCE;
                            break;
                        default:
                            // used to stop possible error of vehicle type not being set
                            vehicleType = null;
                            System.out.println("Error: Vehicle Type not in file!");
                            break;
                    } // end switch
                    vehicleVin = buffer.nextLine();
                    Vehicle vehicle = new Vehicle(vehicleVin, vehicleLength, vehicleType);
                    // Checks the Vehicles side
                    if ( vehicleSide.equalsIgnoreCase("left") ) {
                        // If Vehicle is an AMBULANCE, POLICE, or FIRETRUCK move to the back of current Queue
                        if (vehicle.getType() == VehicleType.AMBULANCE || vehicle.getType() == VehicleType.FIRETRUCK ||
                                vehicle.getType() == VehicleType.POLICE) {
                            leftLine.moveToBack(vehicle);

                        } // end if
                        leftLine.enqueue(vehicle);
                        count++;

                    }

                } // end for loop


            } // end while loop
        } catch (FileNotFoundException e){
            System.out.println(e);
        } catch (VehicleException e) {
            System.out.println(e);
        } // end try catch statement

    } // end main

} // end DriverYoung
/*
 Sample Output:

 */
