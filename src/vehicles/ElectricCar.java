package vehicles;

//Assignment 1
//Written by Carson Johnston 40312846

/**
 * The ElectricCar class represents an electric car, extending the Car class.
 * It includes attributes specific to electric cars, such as driving range and a unique plate number format.
 * @author Carson Johnston 40312846
 * @version 1.0
 */
public class ElectricCar extends Car{
	/** The driving range of the electric car in kilometers. */
	protected int range;
	/** The prefix for electric car plate numbers. */
	public static final String ELECTRICCARPLATE = "EC";
	/** The static counter for generating unique electric car plate numbers. */
	protected static int eCarPlateNum = 1000;
	
	/**
     * Default constructor initializing an electric car with default values.
     */
	public ElectricCar() {
		super();
		range = 0;
	}
	
	/**
     * Parameterized constructor to initialize an electric car with specified range, max passengers, make, model, and year.
     * @param range The driving range of the electric car in kilometers.
     * @param maxPassengers The maximum number of passengers the car can accommodate.
     * @param make The make (brand) of the car.
     * @param model The model of the car.
     * @param yearProduced The year the car was produced.
     */
	public ElectricCar(int range, int maxPassengers, String make, String model, int yearProduced) {
		super(maxPassengers, make, model, yearProduced);
		setPlateNumber(++eCarPlateNum);
		this.range = range;
	}
	
	/**
     * Copy constructor that creates a new ElectricCar object as a copy of another electric car.
     * @param eCar The electric car object to be copied.
     */
	public ElectricCar(ElectricCar eCar) {
		this(eCar.range, eCar.maxPassengers, eCar.getMake(), eCar.getModel(), eCar.yearProduced);
	}
	
	/**
     * Gets the driving range of the electric car.
     * @return The driving range in kilometers.
     */
	public int getRange() {
		return range;
	}
	
	/**
     * Sets the driving range of the electric car.
     * @param range The new driving range in kilometers.
     */
	public void setRange(int range) {
		this.range = range;
	}
	
	/**
     * Returns a string representation of the electric car.
     * @return A string containing electric car details, including range and plate number.
     */
	@Override
	public String toString() {
		return "Electric " + super.toString() + "Range: " + range + "\nPlate Number: " + ELECTRICCARPLATE + plateNumber;
	}
	
	/**
     * Compares this electric car with another object for equality.
     * @param obj The object to be compared.
     * @return true if the objects are equal, false otherwise.
     */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (obj.getClass() != getClass())
			return false;
		else {
			ElectricCar eCar = (ElectricCar)obj;
			return super.equals(eCar) && eCar.range == range;
		}
	}
}
