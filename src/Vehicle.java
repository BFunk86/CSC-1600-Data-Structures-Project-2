/**
 * CSC 1600
 * Data Structures
 *
 * The Vehicle class represents a Vehicle.
 *
 * @author Brandon Young
 */
// File Name: Vehicle.java
public class Vehicle {

    // The length of the vehicle
    private int length;
    // The vin number of the vehicle
    private String vin;
    // The Type of Vehicle
    private VehicleType type;

    /**
     * Default constructor for the Vehicle class
     * Precondition: none
     * Post Condition: Creates a vehicle object
     * @param vin String: The vin number of the Vehicle
     * @param length int: The length of the vehicle
     * @throws VehicleException: If one of the arguments are incorrect
     */
    public Vehicle(String vin, int length, VehicleType type) throws VehicleException {
        try {
            setVin(vin);
            setLength(length);
            setVin(vin);
        } catch (VehicleException e) {
            System.out.println(e);
        } // end try catch
    } // end constructor    xc

    /**
     * The getLength method returns the length of the vehicle
     * Precondition: none
     * Post Condition: Returns the length of the Vehicle
     * @return (int): The length of the Vehicle.
     */
    public int getLength() {
        return length;
    } // end getLength

    /**
     * The setLength method sets the length of the vehicle
     * Precondition: length > 0
     * Post Condition: Sets the length of the Vehicle
     * @param length int: The length of the Vehicle
     * @throws VehicleException: If length <= 0
     */
    private void setLength(int length) throws VehicleException{
        if (length > 0) {
            this.length = length;
        } else {
            throw new VehicleException("The vehicle length must be greater than 0.");
        } // end if else
    } // end setLength

    /**
     * The getVin method returns the vin number of the Vehicle
     * Precondition: None
     * Post Condition: Returns the vin number of the Vehicle
     * @return (String): The vin number of the Vehicle
     */
    public String getVin() {
        return vin;
    } // end getVin

    /**
     * The setVin number sets the Vehicles vin number which is 3 integers
     * Precondition: vin.length == 3
     * Post Condition: Sets the vin number of the Vehicle
     * @param vin String: The vehicle vin number
     * @throws VehicleException: if vin.length does not == 3
     */
    private void setVin(String vin) throws VehicleException{
        if (vin.length() == 3) {
            this.vin = vin;
        } else {
            throw new VehicleException("The vin number must be a length of 3");
        } // end if else
    } // end setVin

    /**
     * The getType method returns the type of the vehicle
     * Precondition: none
     * Post Condition: Returns the type of vehicle
     * @return (VehicleType): The type of the vehicle
     */
    public VehicleType getType() {
        return type;
    } // end setVin

    /**
     * The setType method sets the Type of Vehicle.
     * Precondition: none
     * Post Condition: Sets the type of Vehicle
     * @param type VehicleType: The type of vehicle
     */
    private void setType(VehicleType type) {
        this.type = type;
    } // end setType

} // end Vehicle Class
