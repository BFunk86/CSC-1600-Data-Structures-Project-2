/**
 * CSC 1600
 * Data Structures
 *
 * The VehicleException exception is used to throw an error when invalid input is entered
 * while creating a Vehicle.
 *
 * @author Brandon Young
 */
// File Name: VehicleException.java
public class VehicleException extends Exception {

    /**
     * The VehicleException constructor
     * @param s String: The information for the error displayed to the console
     */
    public VehicleException (String s) {
        System.out.print("VehicleException: " + s);
    }

}
