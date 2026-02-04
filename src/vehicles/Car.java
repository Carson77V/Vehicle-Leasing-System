package vehicles;

//Assignment 1
//Written by Carson Johnston 40312846

/**
 * The Car class represents a general car. It extends the Vehicle class
 * and includes an attribute for the maximum number of passengers the car can accommodate.
 * @author Carson Johnston 40312846
 * @version 1.0
 */
public class Car extends Vehicle{
	/** The maximum number of passengers the car can accommodate. */
	protected int maxPassengers;
	
	/**
     * Default constructor initializing a car with default values.
     */
	public Car() {
		super();
		maxPassengers = 0;
	}
	
	/**
     * Parameterized constructor to initialize a car with specified maximum passengers, make, model, and year.
     * @param maxPassengers The maximum number of passengers the car can accommodate.
     * @param make The make (brand) of the car.
     * @param model The model of the car.
     * @param yearProduced The year the car was produced.
     */
	public Car (int maxPassengers, String make, String model, int yearProduced) {
		super(make, model, yearProduced);
		this.maxPassengers = maxPassengers;
	}
	
	/**
     * Copy constructor that creates a new Car object as a copy of another car.
     * @param car The car object to be copied.
     */
	public Car (Car car) {
		this(car.maxPassengers, car.getMake(), car.getModel(), car.yearProduced);
	}
	
	/**
     * Gets the maximum number of passengers the car can accommodate.
     * @return The maximum number of passengers.
     */
	public int getMaxPassengers() {
		return maxPassengers;
	}
	
	/**
     * Sets the maximum number of passengers the car can accommodate.
     * @param max The new maximum number of passengers.
     */
	public void setMaxPassengers(int max) {
		this.maxPassengers = max;
	}
	
	/**
     * Compares this car with another object for equality.
     * @param obj The object to be compared.
     * @return true if the objects are equal, false otherwise.
     */
	@Override
	public boolean equals (Object obj) {
		if (obj == null)
			return false;
		else if (getClass() != obj.getClass())
			return false;
		else {
			Car car = (Car)obj;
			return car.maxPassengers == maxPassengers && super.equals(car);
		}
	}
	
	/**
     * Returns a string representation of the car.
     * @return A string containing car details, including maximum passengers.
     */
	@Override
	public String toString() {
		return "Car, " + super.toString() + "Max Passengers: " + maxPassengers + "\n";
	}
}
