package vehicles;

//Assignment 1
//Written by Carson Johnston 40312846

/**
 * The DieselTruck class represents a diesel-powered truck. It extends the Truck class
 * and adds attributes specific to diesel trucks, such as fuel capacity and a unique plate number format.
 * @author Carson Johnston 40312846
 * @version 1.0
 */
public class DieselTruck extends Truck{
	/** The fuel capacity of the diesel truck in liters. */
	private int fuelCapacity;
	/** The prefix for diesel truck plate numbers. */
	public static final String DIESELTRUCKPLATE = "DT";
	/** The static counter for generating unique diesel truck plate numbers. */
	protected static int dTruckPlateNum = 1000;
	
	/**
     * Default constructor initializing a diesel truck with default values.
     */
	public DieselTruck() {
		super();
		fuelCapacity = 0;
	}
	
	/**
     * Parameterized constructor to initialize a diesel truck with specified fuel capacity, capacity, make, model, and year.
     * @param fuelCapacity The fuel capacity of the diesel truck in liters.
     * @param capacity The load capacity of the diesel truck.
     * @param make The make (brand) of the truck.
     * @param model The model of the truck.
     * @param yearProduced The year the truck was produced.
     */
	public DieselTruck (int fuelCapacity, int capacity, String make, String model, int yearProduced) {
		super(capacity, make, model, yearProduced);
		setPlateNumber(++dTruckPlateNum);
		this.fuelCapacity = fuelCapacity;
	}
	
	/**
     * Copy constructor that creates a new DieselTruck object as a copy of another diesel truck.
     * @param dTruck The diesel truck object to be copied.
     */
	public DieselTruck (DieselTruck dTruck) {
		this(dTruck.fuelCapacity, dTruck.capacity, dTruck.getMake(), dTruck.getModel(), dTruck.yearProduced);
	}
	
	/**
     * Gets the fuel capacity of the diesel truck.
     * @return The fuel capacity of the diesel truck in liters.
     */
	public int getFuelCapacity() {
		return fuelCapacity;
	}
	
	/**
     * Sets the fuel capacity of the diesel truck.
     * @param fuelCapacity The new fuel capacity to be assigned.
     */
	public void setFuelCapacity(int fuelCapcity) {
		this.fuelCapacity = fuelCapcity;
	}
	
	/**
     * Compares this diesel truck with another object for equality.
     * @param obj The object to be compared.
     * @return true if the objects are equal, false otherwise.
     */
	@Override
	public boolean equals (Object obj) {
		if (obj == null)
			return false;
		else if (obj.getClass() != getClass())
			return false;
		else {
			DieselTruck dTruck = (DieselTruck)obj;
			return dTruck.getFuelCapacity() == fuelCapacity && super.equals(dTruck);
		}
	}
	
	/**
     * Returns a string representation of the diesel truck.
     * @return A string containing diesel truck details, including fuel capacity and plate number.
     */
	@Override
	public String toString() {
		return "Diesel " + super.toString() + "Fuel Capacity: " + fuelCapacity + "\nPlate Number: " + DIESELTRUCKPLATE + getPlateNumber();
	}
}
