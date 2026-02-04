package clients;
import vehicles.*;

//Assignment 1
//Written by Carson Johnston 40312846

/**
 * Represents a client who leases vehicles.
 * Stores the client's name and an array of leased vehicles.
 * Provides methods for managing leased vehicles.
 * @author Carson Johnston 40312846
 * @version 1.0
 */
public class Client {
	/** stores the clients name*/
	private String name;
	/** array that stores the vehicles leased to the client*/
	private Vehicle[] leased;
	
	/**
     * Default constructor initializing name to "none".
     */
	public Client () {
		this("none");
	}
	
	/**
     * Constructs a client with a specified name.
     * @param name the name of the client
     */
	public Client(String name) {
		this.name = name;
	}
	
	/**
     * Copy constructor that creates a deep copy of a given client.
     * @param client the client to copy
     */
	public Client (Client client) {
		this(String.valueOf(client.getName()));
		leased = new Vehicle[client.getVehicles().length];
		for (int i = 0; i < leased.length; i++) {
			leased[i] = new Vehicle(client.getVehicle(i));
		}
	}
	
	/**
     * Sets the client's name.
     * @param name the new name
     */
	public void setName (String name) {
		this.name = String.valueOf(name);
	}
	
	/**
     * Gets the client's name.
     * @return the name of the client
     */
	public String getName() {
		return String.valueOf(name);
	}
	
	/**
     * Returns a deep copy of the leased vehicles array.
     * @return an array of leased vehicles
     */
	public Vehicle[] getVehicles() {
		Vehicle[] vehicles;
		if (leased == null)
			return new Vehicle[0];
		// create a temporary array for vehicles
		vehicles = new Vehicle[leased.length];
		// loop adds all vehicles from leased array to temporary vehicles array
		for (int i = 0; i < vehicles.length; i++) {
			vehicles[i] = new Vehicle(leased[i]);
		}
		
		return vehicles;
	}
	
	/**
     * Gets the vehicle at the specified index.
     * @param index the index of the vehicle
     * @return the vehicle at the specified index
     */
	public Vehicle getVehicle(int index) {
		return leased[index];
	}
	
	/**
     * Adds a vehicle to the client's leased vehicles list.
     * @param vehicle the vehicle to add
     */
	public void addVehicle(Vehicle vehicle) {
		//create a temporary array to store all vehicles from leased
		Vehicle[] newLeased;
		// if leased is not null copy all Vehicles from leased to newleased
		if (leased != null) {
			newLeased = new Vehicle[leased.length + 1];
			for (int i = 0; i < newLeased.length - 1; i++) {
				newLeased[i] = leased[i];
			}
		}
		// if leased is null, initialize newLeased to length = 1
		else {
			newLeased = new Vehicle[1];
		}
		
		//add the new vehicle to the array newLeased depending on vehicle type
		if (vehicle instanceof ElectricCar) {
			newLeased[newLeased.length - 1] = (ElectricCar) vehicle;
		}
		else if (vehicle instanceof GasCar) {
			newLeased[newLeased.length - 1] = (GasCar) vehicle;
		}
		else if (vehicle instanceof ElectricTruck) {
			newLeased[newLeased.length - 1] = (ElectricTruck) vehicle;
		}
		else if (vehicle instanceof DieselTruck) {
			newLeased[newLeased.length - 1] = (DieselTruck) vehicle;
		}
		//have leased point to newLeased
		leased = newLeased;
	}
	
	/**
     * Removes a vehicle at the specified index and returns it.
     * @param index the index of the vehicle to remove
     * @return the removed vehicle
     */
	public Vehicle removeVehicle(int index) {
		// create temporary array with one less vehicle than leased[]
		Vehicle[] tempVehicles = new Vehicle[leased.length - 1];

		// start looping through leased and adding vehicle to tempVehicles[]
		for (int i = 0, k = 0; i < leased.length && k < tempVehicles.length; i++, k++) {
			// when i matches the index of the vehicle to remove, decrement k to prevent if from
			// skipping and index in tempVehciles and continue the loop
			if (i == index) {
				k--;
				continue;
			}
			
			// copy all leased vehicles using index i (one value will be skipped) to tempVehicles
			// using index k 
			tempVehicles[k] = leased[i];
		}
		
		// create a copy of leased to return the removed vehicle
		Vehicle[] copyLeased = leased;
		
		// set leased to point to new array with one less vehicle
		leased = tempVehicles;
		
		// returns the copied vehicle
		return copyLeased[index];
	}
	
	/**
     * Returns a string representation of the client and their leased vehicles.
     * @return a string describing the client and their vehicles
     */
	@Override
	public String toString() {
		String vehiclesLeised = "Name: " + name + "\n";
		if (leased.length == 0)
			return vehiclesLeised + "No Vehicles being leised";
		else {
			vehiclesLeised += "Current Vehicles being leised by " + name + ":\n";
			for (int i = 0; i < leased.length; i++) {
				vehiclesLeised += leased[i].toString() + "\n";
			}
			return vehiclesLeised;
		}
	}
	
	/**
     * Checks whether this client is equal to another object.
     * @param obj the object to compare with
     * @return true if they are equal, false otherwise
     */
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		else if (obj.getClass() != getClass())
			return false;
		else {
			Client client = (Client)obj;
			// check if leased[] is null
			if (leased == null) {
				//if cleint.leised[] isn't null, return false
				if (client.getVehicles() != null)
					return false;
			}
			// first check if clients share the same name
			else if (!client.name.equalsIgnoreCase(name))
				return false;
			// then check if they have same amount of Vehicles
			else if (client.getVehicles().length != leased.length)
				return false;
			// check if each Vehicle is equal
			else {
				for (int i = 0; i < leased.length; i++) {
					if (!leased[i].equals(client.getVehicle(i)))
						return false;
				}
			}
			return true;
		}
	}
}
