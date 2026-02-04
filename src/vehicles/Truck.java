package vehicles;

//Assignment 1
//Written by Carson Johnston 40312846

/**
 * The class represents different types of trucks. It extends the Vehicle class
 * and adds a capacity attribute to define the truck's load capacity.
 * @author Carson Johnston 40312846
 * @version 1.0
 */
public class Truck extends Vehicle{
	/** The load capacity of the truck. */
	protected int capacity;
	
	/** Default constructor initializing a truck with default values. */
	public Truck () {
		super();
		capacity = 0;
	}
	
	/**
     * Parameterized constructor to initialize a truck with specified capacity, make, model, and production year.
     * @param capacity The load capacity of the truck.
     * @param make The make (brand) of the truck.
     * @param model The model of the truck.
     * @param yearProduced The year the truck was produced.
     */
	public Truck(int capacity, String make, String model, int yearProduced) {
		super(make, model, yearProduced);
		this.capacity = capacity;
	}
	
	/**
     * Copy constructor that creates a new Truck object as a copy of another truck.
     * @param truck The truck object to be copied.
     */
	public Truck (Truck truck) {
		this(truck.capacity, truck.getMake(), truck.getModel(), truck.yearProduced);
	}
	
	/**
     * Gets the capacity of the truck.
     * @return The capacity of the truck.
     */
	public int getCapacity() {
		return capacity;
	}
	
	/**
     * Sets the capacity of the truck.
     * @param capacity The new capacity to be assigned.
     */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	/**
     * Returns a string representation of the truck.
     * @return A string containing truck details, including capacity.
     */
	@Override
	public String toString() {
		return "Truck, " + super.toString() + "Capacity: " + capacity + "\n";
	}
	
	/**
     * Compares this truck with another object for equality.
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
			Truck truck = (Truck)obj;
			return truck.capacity == capacity && super.equals(truck);
		}
	}
	
	/**
     * Finds the Truck with the largest capacity from an array of trucks.
     * @param truck The array of trucks to be searched.
     * @return The truck with the largest capacity.
     */
	public static Truck getLargestTruck(Truck[] truck) {
		//stores index of the Truck with largest capacity
		int largeCapIndex = 0;
		for (int i = 1; i < truck.length; i++) {
			// if truck[i] has a larger capacity than truck[largeCapIndex], change largeCapIndex to i
			if (truck[i].getCapacity() > truck[largeCapIndex].getCapacity())
				largeCapIndex = i;
		}
		return truck[largeCapIndex];
	}
	
}
