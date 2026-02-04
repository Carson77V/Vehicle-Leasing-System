package vehicles;

// Assignment 1
//Written by Carson Johnston 40312846

/**
 * A class that represents a general vehicle that can/should be expanded upon with children class.
 * @author Carson Johnston 40312846
 * @version 1.0
 */
public class Vehicle {
	/** license plate numerical digits. */
	protected int plateNumber;
	/** make(brand) of vehicle. */
	private String make;
	/** model of the vehicle. */
	private String model;
	/** year the vehicle was produced. */ 
	protected int yearProduced;
	
	/** default constructor initializing Vehicle with default values */
	public Vehicle() {
		this("none","none",0);
	}
	
	/**
	 * Parameterized constructor initializing Vehicle with all its variables.
	 * @param make make(brand) of the vehicle
	 * @param model model of the vehicle
	 * @param yearProduced year the vehicle was produced
	 */
	public Vehicle(String make, String model, int yearProduced) {
		this.make = make;
		this.model = model;
		this.yearProduced = yearProduced;
	}
	
	/**
	 * the copy constructor for copying a Vehicle.
	 * @param vehicle an object of type Vehicle
	 */
	public Vehicle(Vehicle vehicle) {
		this(vehicle.getMake(), vehicle.getModel(), vehicle.yearProduced);
	}
	
	/**
	 * sets a new plate number for Vehicle object. This method should never be used and might be deleted.
	 * @param num number of the new license plate
	 */
	public void setPlateNumber(int num) {
		plateNumber = num;
	}
	
	/**
	 * sets a new make for the Vehicle object.
	 * @param make make(brand) of the vehicle
	 */
	public void setMake(String make) {
		this.make = make;
	}
	
	/**
	 * sets a new model for the Vehicle object.
	 * @param model model of the vehicle
	 */
	public void setModel(String model) {
		this.model = model;
	}
	
	/**
	 * sets the year the vehicle was produced.
	 * @param yearProduced year when vehicle was produced
	 */
	public void setYearProduced(int yearProduced) {
		this.yearProduced = yearProduced;
	}
	
	/**
	 * gets the plate number of the vehicle.
	 * @return the plate number of vehicle 
	 */
	public int getPlateNumber() {
		return this.plateNumber;
	}
	
	/**
	 * gets the make(brand) of the vehicle.
	 * @return the make(brand) of the vehicle
	 */
	public String getMake() {
		return String.valueOf(make);
	}
	
	/**
	 * gets the model of the vehicle.
	 * @return the model of the vehicle
	 */
	public String getModel() {
		return String.valueOf(model);
	}
	
	/**
	 * gets the year the vehicle was produced.
	 * @return year the vehicle was produced
	 */
	public int getYearProduced() {
		return this.yearProduced;
	}
	
	/**
	 * returns a string with the vehicle make, model and yearProduced.
	 * @return a string with all the vehicles variables
	 */
	@Override
	public String toString(){
		return "Vehicle\nMake: " + make + "\nModel: " + model + "\nYear Produced: "
				+ yearProduced + "\n";
	}
	
	/**
	 * Checks if the passed parameter can be converted to type Vehicle, then compare the variables
	 * from obj to this variables. If parameters share the same value, return true.
	 * @param obj and object that should be a Vehicle or subclass of Vehicle
	 * @return return true if object variables are same as this Vehicle, otherwise return false
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (obj.getClass() != getClass())
			return false;
		else {
			Vehicle vehicle = (Vehicle)obj;
			return make.equalsIgnoreCase(vehicle.getMake()) && model.equalsIgnoreCase(vehicle.getModel()) &&
				   yearProduced == vehicle.yearProduced;
		}
	}
	
	/**
	 * creates a deep copy of each vehicle passed into the method and copies them to a new array
	 * to be returned by the method.
	 * @param vehicles the array of vehicles to be copied
	 * @return returns a new array of Vehicles that were copied from parameter
	 */
	public static Vehicle[] copyVehicles(Vehicle[] vehicles) {
		
		//initialize the array to be returned
		Vehicle[] tempVehicles = new Vehicle[vehicles.length];
		
		// check what type of vehicle array was passed and initialize variables into tempVehicles accordingly
		for (int i = 0; i < vehicles.length; i++) {
			if (vehicles[i] instanceof ElectricTruck) {
				tempVehicles[i] = new ElectricTruck((ElectricTruck) vehicles[i]);
			}
			else if (vehicles[i] instanceof DieselTruck) {
				tempVehicles[i] = new DieselTruck((DieselTruck) vehicles[i]);
			}
			else if (vehicles[i] instanceof ElectricCar) {
				tempVehicles[i] = new ElectricCar((ElectricCar) vehicles[i]);
			}
			else if (vehicles[i] instanceof GasCar) {
				tempVehicles[i] = new GasCar((GasCar) vehicles[i]);
			}
		}
		
		return tempVehicles;
	}
}
