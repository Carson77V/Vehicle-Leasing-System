package vehicles;

//Assignment 1
//Written by Carson Johnston 40312846

/**
 * The GasCar class represents a gasoline-powered car, extending the Car class.
 * It includes a unique plate number format for gas cars.
 * @author Carson Johnston 40312846
 * @version 1.0
 */
public class GasCar extends Car{
	/** The prefix for gas car plate numbers. */
	public static final String GASCARPLATE = "GC";
	/** The static counter for generating unique gas car plate numbers. */
	protected static int gCarPlateNum = 1000;
	
	/**
     * Default constructor initializing a gas car with default values.
     */
	public GasCar() {
		super();
	}
	
	/**
     * Parameterized constructor to initialize a gas car with specified max passengers, make, model, and year.
     * @param maxPassengers The maximum number of passengers the car can accommodate.
     * @param make The make (brand) of the car.
     * @param model The model of the car.
     * @param yearProduced The year the car was produced.
     */
	public GasCar(int maxPassengers, String make, String model, int yearProduced) {
		super(maxPassengers, make, model, yearProduced);
		setPlateNumber(++gCarPlateNum);
		
	}
	
	/**
     * Copy constructor that creates a new GasCar object as a copy of another gas car.
     * @param car The gas car object to be copied.
     */
	public GasCar(GasCar car) {
		this(car.maxPassengers, car.getMake(), car.getModel(), car.yearProduced);
	}
	
	/**
     * Returns a string representation of the gas car.
     * @return A string containing gas car details, including plate number.
     */
	@Override
	public String toString() {
		return "Gas " + super.toString() + "Plate Number: " + GASCARPLATE + plateNumber;
	}
	
	/**
     * Compares this gas car with another object for equality.
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
			GasCar gCar = (GasCar)obj;
			return super.equals(gCar);
		}
	}
}
