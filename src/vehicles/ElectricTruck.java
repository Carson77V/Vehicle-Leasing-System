package vehicles;

//Assignment 1
//Written by Carson Johnston 40312846

/**
 * The Electric Truck class represents an electric-powered truck. It extends the Truck class
 * and adds attributes specific to electric trucks, such as range and a unique plate number format.
 * @author Carson Johnston 40312846
 * @version 1.0
 */
public class ElectricTruck extends Truck{
	/** The range of the electric truck in kilometers. */
	protected int range;
	/** The prefix for electric truck plate numbers. */
	public static final String ELECTRICTRUCKPLATE = "ET";
	/** The static counter for generating unique electric truck plate numbers. */
	protected static int eTruckPlateNum = 1000;
	
	/**
     * Default constructor initializing an electric truck with default values.
     */
	public ElectricTruck() {
		super();
		range = 0;
	}
	
	/**
     * Parameterized constructor to initialize an electric truck with specified range, capacity, make, model, and year.
     * @param range The range of the electric truck in kilometers.
     * @param capacity The load capacity of the electric truck.
     * @param make The make (brand) of the truck.
     * @param model The model of the truck.
     * @param yearProduced The year the truck was produced.
     */
	public ElectricTruck (int range, int capacity, String make, String model, int yearProduced) {
		super(capacity, make, model, yearProduced);
		setPlateNumber(++eTruckPlateNum);
		this.range = range;
	}
	
	/**
     * Copy constructor that creates a new Electric Truck object as a copy of another electric truck.
     * @param eTruck The electric truck object to be copied.
     */
	public ElectricTruck (ElectricTruck eTruck) {
		this(eTruck.range, eTruck.capacity, eTruck.getMake(), eTruck.getModel(), eTruck.yearProduced);
	}
	
	/**
     * Gets the range of the electric truck.
     * @return The range of the electric truck in kilometers.
     */
	public int getRange() {
		return range;
	}
	
	/**
     * Sets the range of the electric truck.
     * @param range The new range to be assigned.
     */
	public void setRange(int range) {
		this.range = range;
	}
	
	/**
     * Compares this electric truck with another object for equality.
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
			ElectricTruck eTruck = (ElectricTruck)obj;
			return eTruck.range == range && super.equals(eTruck);
		}
	}
	
	/**
     * Returns a string representation of the electric truck.
     * @return A string containing electric truck details, including range and plate number.
     */
	@Override
	public String toString() {
		return "Electric " + super.toString() + "Range: " + range + "\nPlate Number: " + ELECTRICTRUCKPLATE + plateNumber;
	}
}
