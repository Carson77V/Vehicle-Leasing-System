package main;
import vehicles.*;
import clients.*;
import java.util.Scanner;

//Assignment 1
//Written by Carson Johnston 40312846

/**
 * RoyalRentals is a vehicle rental management system.
 * This program allows users to manage vehicles, clients, and leasing operations.
 * Assignment 1
 * Written by Carson Johnston 40312846
 */
public class RoyalRentals {
	static Scanner scanner = new Scanner(System.in);
	/** stores the user's choice throughout the program*/
	static int userChoice;
	/** an array that stores all ElectricCar objects*/
	static ElectricCar[] eCars = new ElectricCar[0];
	/** an array that stores all GasCar objects*/
	static GasCar[] gCars = new GasCar[0];
	/** an array that stores all ElectricTruck objects*/
	static ElectricTruck[] eTrucks = new ElectricTruck[0];
	/** an array that stores all DieselTruck objects*/
	static DieselTruck[] dTrucks = new DieselTruck[0];
	/** an array that stores all the clients*/
	static Client[] clients = new Client[0];
	
	/** an array that stores a deep copy of ElectricTruck objects*/
	static Vehicle[] deepCopyETruck =  new Vehicle[0];
	
	/**
     * Main method to start the program.
     * It presents the user with options to manually control the program
     * or to initialize predefined values.
     * @param args Command-line arguments (not used).
     */
	public static void main(String[] args) {
		
		preDefined();
		System.out.println("\n\n\n------------Welcome to Royal Rentals-----------");
		
		/*
		
		do {
			// in order for program to function correctly, select 2 as the first option to set up
			// pre defined values
			System.out.println("Select an option (select option 2 first to load pre set values)");
			System.out.println("  1. Control Program manually");
			System.out.println("  2. Initiate hard-coded values in program");
			userChoice = scanner.nextInt();
			scanner.nextLine();
			
			if (userChoice < 1 || userChoice > 2) {
				System.out.println("Please input either number 1 or 2");
			}
			else if (userChoice == 2)
				// sets up the program with pre defined values, mandatory to use program correctly
				preDefined();
		}while (userChoice < 1 || userChoice > 2);
		
		*/
		
		System.out.println("\npre defined assets have been loaded into the program to test functionality\n");
		
		//if user choice is 1, program prompts user to select from menu
		while (true) {
			System.out.println("What would you like to do?");	
			System.out.println("  1. Vehicle Management");
			System.out.println("  2. Client Management");
			System.out.println("  3. Leasing Operations");
			System.out.println("  4. Additional Operations");
			System.out.println("  5. Terminate Program");
			userChoice = scanner.nextInt();
			scanner.nextLine();
			
			switch(userChoice) {
			
			case 1: vehicleManagement();	
			break;
			
			case 2: clientManagement();
			break;
			
			case 3: leasingOperations();
				
			break;
				
			case 4: additionalOptions();
					
			break;
			
			case 5: System.out.println("Terminating Program");
					scanner.close();
					System.exit(0);
				
			break;
			
			default: System.out.println("Please enter a number between 1-5");
			}
			
		}
		
	}
	
	/** prints options for vehicle management and lets user choose an option. */
	private static void vehicleManagement() {
		System.out.println("Select an option");
		System.out.println("  1. Add a vehicle");
		System.out.println("  2. Delete a vehicle");
		System.out.println("  3. Update vehicle information");
		System.out.println("  4. List all vehicles by category");
		System.out.println("  5. Return to main menu");
		userChoice = scanner.nextInt();
		scanner.nextLine();
		
		switch(userChoice) {
		
		case 1: addVehicle();
		break;
		
		case 2: deleteVehicle();
		break;
		
		case 3: updateVehicleInfo();
		break;
			
		case 4: listVehicles();		
		break;
		
		case 5: return;
		
		// re calls method when user inputs invalid number
		default: System.out.println("Please enter a number between 1-5");
				 vehicleManagement();
		}
	}
	
	/** lets user add a vehicle to one of the 4 pre-defined Vehicle arrays. */
	private static void addVehicle() {
		System.out.println("What kind of vehicle do you want to add?");
		System.out.println("  1. Electric Car");
		System.out.println("  2. Gas Car");
		System.out.println("  3. Electric Truck");
		System.out.println("  4. Diesel Truck");
		userChoice = scanner.nextInt();
		scanner.nextLine();
		
		// variab)les for Vehicle
		String make;
		String model;
		int yearProduced;
		
		// variables for Truck(s)
		int capacity;
		int fuelCapacity;
		
		//variables for Car(s)
		int maxPassengers;
		
		//variables for electric Vehicles
		int range;
		
		//Begin by gathering variables for Vehicle
		System.out.println("Enter make of vehicle");
		make = scanner.nextLine();
		System.out.println("Enter model of vehicle");
		model = scanner.nextLine();
		System.out.println("Enter year produced");
		yearProduced = scanner.nextInt();
		scanner.nextLine();
		
		switch(userChoice) {
		//Electric Car
		case 1: System.out.println("Enter max passengers car can hold");
				maxPassengers = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter range of car");
				range = scanner.nextInt();
				scanner.nextLine();
				
				ElectricCar[] tempECar;
				if (eCars == null)
					tempECar = new ElectricCar[1];
				else {
					tempECar = new ElectricCar[eCars.length + 1];
				}
				
				//copy all eCars to tempECar
				for (int i = 0; i < eCars.length; i++) {
					tempECar[i] = eCars[i];
				}
				
				// add new eCar to temp array then make eCars[] point to temp array
				tempECar[tempECar.length - 1] = new ElectricCar(range, maxPassengers, make, model, yearProduced);
				eCars = tempECar;
			
		break;
		
		// Gas Car
		case 2: System.out.println("Enter max passengers car can hold");
				maxPassengers = scanner.nextInt();
				scanner.nextLine();
				
				GasCar[] tempGCar;
				if(gCars == null)
					tempGCar = new GasCar[1];
				else {
					tempGCar = new GasCar[gCars.length + 1];
				}
				
				//copy all gCars to tempGCar
				for (int i = 0; i < gCars.length; i++) {
					tempGCar[i] = gCars[i];
				}
				
				// add new gCar to temp array then make gCars[] point to temp array
				tempGCar[tempGCar.length - 1] = new GasCar(maxPassengers, make, model, yearProduced);
				gCars = tempGCar;
			
		break;
		
		// Electric Truck
		case 3: System.out.println("Enter capacity of Truck");
				capacity = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter range of truck");
				range = scanner.nextInt();
				scanner.nextLine();
				
				ElectricTruck[] tempETruck;
				if(eTrucks == null)
					tempETruck = new ElectricTruck[1];
				else {
					tempETruck = new ElectricTruck[eTrucks.length + 1];
				}
				
				//copy all eTrucks to tempETruck
				for (int i = 0; i < eTrucks.length; i++) {
					tempETruck[i] = eTrucks[i];
				}
				
				// add new eTruck to temp array then make eTrucks[] point to temp array
				tempETruck[tempETruck.length - 1] = new ElectricTruck(range, capacity, make, model, yearProduced);
				eTrucks = tempETruck;
			
		break;
			
		//Diesel Truck
		case 4: System.out.println("Enter capacity of Truck");
				capacity = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Enter fuel capacity");
				fuelCapacity = scanner.nextInt();
				scanner.nextLine();
				
				DieselTruck[] tempDTruck;
				if(dTrucks == null)
					tempDTruck = new DieselTruck[1];
				else {
					tempDTruck = new DieselTruck[dTrucks.length + 1];
				}
				
				//copy all dTrucks to tempDTruck
				for (int i = 0; i < dTrucks.length; i++) {
					tempDTruck[i] = dTrucks[i];
				}
				
				// add new dTruck to temp array then make dTrucks[] point to temp array
				tempDTruck[tempDTruck.length - 1] = new DieselTruck(fuelCapacity, capacity, make, model, yearProduced);
				dTrucks = tempDTruck;
				
		break;
		
		// re calls method when user input invalid number
		default: System.out.println("Please enter a number between 1-4");
				 addVehicle();
		}	
	}
	
	/** lets user choose a vehicle to delete/remove from one of the four vehicle arrays. */
	private static void deleteVehicle() {
		System.out.println("Which type of vehicle do you want to delete?");
		System.out.println("  1. Electric Car");
		System.out.println("  2. Gas Car");
		System.out.println("  3. Electric Truck");
		System.out.println("  4. Diesel Truck");
		userChoice = scanner.nextInt();
		scanner.nextLine();
		
		switch(userChoice) {
		
		case 1: listElectricCars();
				System.out.println("Here are the current electric cars, enter index to delete car");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				
				removeECar(userChoice);
			
		break;
		
		case 2: listGasCars();
				System.out.println("Here are the current gas cars, enter index to delete car");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				
				removeGCar(userChoice);
			
		break;
		
		case 3: listElectricTrucks();
				System.out.println("Here are the current electric trucks, enter index to delete truck");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				
				removeETruck(userChoice);
			
		break;
		
		case 4: listDieselTrucks();
				System.out.println("Here are the current electric trucks, enter index to delete truck");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				
				removeDTruck(userChoice);
			
		break;
		
		default: System.out.println("Enter a valid number between 1-4");
				 deleteVehicle();
		}
	}
	
	/** lets user update vehicle information for one vehicle from one of the four Vehicle arrays. */
	private static void updateVehicleInfo() {
		System.out.println("Which type of vehicle do you want to update?");
		System.out.println("  1. Electric Car");
		System.out.println("  2. Gas Car");
		System.out.println("  3. Electric Truck");
		System.out.println("  4. Diesel Truck");
		userChoice = scanner.nextInt();
		scanner.nextLine();
		
		switch(userChoice) {
		
		case 1: listElectricCars();
				System.out.println("Here are the current electric cars, enter index to edit car");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Enter vehicle information:");
				System.out.println("Enter range");
				eCars[userChoice].setRange(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter max passengers");
				eCars[userChoice].setMaxPassengers(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter make");
				eCars[userChoice].setMake(scanner.nextLine());
				System.out.println("Enter model");
				eCars[userChoice].setModel(scanner.nextLine());
				System.out.println("Enter year produced");
				eCars[userChoice].setYearProduced(scanner.nextInt());
				scanner.nextLine();
			
		break;
		
		case 2: listGasCars();
				System.out.println("Here are the current gas cars, enter index to edit car");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Enter vehicle information:");
				System.out.println("Enter max passengers");
				gCars[userChoice].setMaxPassengers(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter make");
				gCars[userChoice].setMake(scanner.nextLine());
				System.out.println("Enter model");
				gCars[userChoice].setModel(scanner.nextLine());
				System.out.println("Enter year produced");
				gCars[userChoice].setYearProduced(scanner.nextInt());
				scanner.nextLine();
			
		break;
		
		case 3: listElectricTrucks();
				System.out.println("Here are the current electric trucks, enter index to edit car");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Enter vehicle information:");
				System.out.println("Enter range");
				eTrucks[userChoice].setRange(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter capacity");
				eTrucks[userChoice].setCapacity(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter make");
				eTrucks[userChoice].setMake(scanner.nextLine());
				System.out.println("Enter model");
				eTrucks[userChoice].setModel(scanner.nextLine());
				System.out.println("Enter year produced");
				eTrucks[userChoice].setYearProduced(scanner.nextInt());
				scanner.nextLine();
			
		break;
		
		case 4: listDieselTrucks();
				System.out.println("Here are the current diesel trucks, enter index to edit car");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("Enter vehicle information:");
				System.out.println("Enter fuel range");
				dTrucks[userChoice].setFuelCapacity(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter capacity");
				dTrucks[userChoice].setCapacity(scanner.nextInt());
				scanner.nextLine();
				System.out.println("Enter make");
				dTrucks[userChoice].setMake(scanner.nextLine());
				System.out.println("Enter model");
				dTrucks[userChoice].setModel(scanner.nextLine());
				System.out.println("Enter year produced");
				dTrucks[userChoice].setYearProduced(scanner.nextInt());
				scanner.nextLine();
					
		break;
		
		default: System.out.println("Enter a valid number between 1-4");
				 updateVehicleInfo();
		}
	}
	
	/** 
	 * allows user to choose from two pre-defined options
	 * 1. display truck with largest capacity (carrying capacity)
	 * 2. create a deep copy of the eTrucks array.
	 */
	private static void additionalOptions() {
		System.out.println("Select an Option");
		System.out.println("  1. Display the truck with the largest capacity");
		System.out.println("  2. Create a copy of the electric trucks array");
		System.out.println("  3. Return to main menu");
		userChoice = scanner.nextInt();
		scanner.nextLine();
		
		switch(userChoice) {
		
		case 1: System.out.println(Truck.getLargestTruck(dTrucks).toString());
			
		break;
		
		case 2: deepCopyETruck = Vehicle.copyVehicles(eTrucks);
				System.out.println("Electric Trucks copied to " + deepCopyETruck);
			
		break;
		
		case 3: return;
		
		// re calls method when user inputs invalid number
		default: System.out.println("Please enter a number between 1-5");
				 vehicleManagement();
		}
	}
	
	/** prints options for user to manage clients. */
	private static void clientManagement() {
		System.out.println("Select an option");
		System.out.println("  1. Add a client");
		System.out.println("  2. Edit a client");
		System.out.println("  3. Delete a client");
		System.out.println("  4. Return to main menu");
		userChoice = scanner.nextInt();
		scanner.nextLine();
		
		switch(userChoice) {
		
		case 1: addClient();
		break;
		
		case 2: editClient();
		break;
		
		case 3: deleteClient();	
		break;
			
		case 4: return;
		
		// re calls method when user inputs invalid number
		default: System.out.println("Please enter a number between 1-3");
				 clientManagement();
		}
	}
	
	/** lets user add a new client to the clients array. */
	private static void addClient() {
		Client[] tempClient;
		System.out.println("Enter new clients name");
		String name = scanner.nextLine();
		if (clients == null)
			tempClient = new Client[1];
		else {
			tempClient = new Client[clients.length + 1];
		}
		
		// copy clients[] to tempClient[]
		for (int i = 0; i < clients.length; i++) {
			tempClient[i] = clients[i];
		}
		
		// add new client to tempClient[] then have clients[] point to tempClient
		tempClient[tempClient.length - 1] = new Client(String.valueOf(name));
		clients = tempClient;
	}
	
	/** lets user edit a client's information. */
	private static void editClient() {
		for (int i = 0; i < clients.length; i++) {
			System.out.println("Index: " + i + "Name: " + clients[i].getName());
		}
		System.out.println("Here is the list of clients, enter index of client you want to update");
		userChoice = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("What is the new name of the client");
		clients[userChoice].setName(scanner.nextLine());
	}
	
	/** lets user delete/remove a client from the clients array. */
	private static void deleteClient() {
		for (int i = 0; i < clients.length; i++) {
			System.out.println("Index: " + i + "Name: " + clients[i].getName());
		}
		System.out.println("Here is the list of clients, enter index of client you want to delete");
		userChoice = scanner.nextInt();
		scanner.nextLine();
		
		Client[] tempClients = new Client[clients.length - 1];
		for (int i = 0, k = 0; i < clients.length && k < tempClients.length; i++, k++) {
			//decrementing k will prevent it from being incremented when the deleted user is matched
			// this prevents tempClients from going out of range
			if (userChoice == i) {
				k--;
				continue;
			}
			tempClients[k] = clients[i];
		}
		
		// set clients[] to the new array tempClients[] witch has the deleted client removed
		clients = tempClients;
		
	}
	
	/** prints leasing operations for user to choose from. */
	private static void leasingOperations() {
		System.out.println("Select an option");
		System.out.println("  1. Lease a vehicle to a client");
		System.out.println("  2. Return a vehicle from a client");
		System.out.println("  3. Show all vehicles leased by a clinent");
		System.out.println("  4. Show all leased vehciles");
		System.out.println("  5. Return to main menu");
		userChoice = scanner.nextInt();
		scanner.nextLine();
		
		switch(userChoice) {
		
		case 1: leaseVehicle();
		break;
		
		case 2: returnVehicle();
		break;
		
		case 3: showAllVehiclesLeasedByClient();	
		break;
			
		case 4: showAllLeasedVehicles();
		break;
		
		case 5: return;
		
		// re calls method when user inputs invalid number
		default: System.out.println("Please enter a number between 1-5");
				 clientManagement();
		}
	}
	
	/** lets user lease a vehicle to a client. */
	private static void leaseVehicle() {
		int clientIndex;
		System.out.println("Enter number associated to the client you want to lease a vehicle to");
		for (int i = 0; i < clients.length; i++) {
			System.out.println(i + ". " + clients[i].getName());
		}
		clientIndex = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Enter number associated with type of vehicle that will be leased");
		System.out.println("  1. Electric Car");
		System.out.println("  2. Gas Car");
		System.out.println("  3. Electric Truck");
		System.out.println("  4. Diesel Truck");
		userChoice = scanner.nextInt();
		scanner.nextLine();
		
		switch(userChoice) {
		
		case 1: System.out.println("Here's a list of all Electric Cars available");
				listElectricCars();
				System.out.println("Select number associated to vehicle you want to lease");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				
				clients[clientIndex].addVehicle(eCars[userChoice]);
				removeECar(userChoice);
				
		break;
			
		case 2: System.out.println("Here's a list of all Gas Cars available");
				listGasCars();
				System.out.println("Select number associated to vehicle you want to lease");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				
				clients[clientIndex].addVehicle(gCars[userChoice]);
				removeGCar(userChoice);
			
		break;
			
		case 3: System.out.println("Here's a list of all Electric Trucks available");
				listElectricTrucks();
				System.out.println("Select number associated to vehicle you want to lease");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				
				clients[clientIndex].addVehicle(eTrucks[userChoice]);
				removeETruck(userChoice);
			
		break;
			
		case 4: System.out.println("Here's a list of all Diesel Trucks available");
				listDieselTrucks();
				System.out.println("Select number associated to vehicle you want to lease");
				userChoice = scanner.nextInt();
				scanner.nextLine();
				
				clients[clientIndex].addVehicle(dTrucks[userChoice]);
				removeDTruck(userChoice);
			
		break;
			
		default: System.out.println("Please enter valid inputs");
				 leaseVehicle();
		}
	}
	
	
	/** 
	 * lets user return a vehicle to one of the four Vehicle arrays and removes the vehicle
	 * from the client's leased array.
	 */
	private static void returnVehicle() {
		int clientIndex;
		System.out.println("Here's a list of all the clients");
		for (int i = 0; i < clients.length; i++) {
			System.out.println(i + ". " + clients[i].getName());
		}
		System.out.println("Enter the number of the client that wants to return a vehicle");
		clientIndex = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("Here's a list of all vehicles leased by the client");
		System.out.println("\n" + clients[clientIndex].toString());
		System.out.println("Enter the number of the vehicle you want to return (the first vehicle being 0");
		userChoice = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println(clients[clientIndex].getVehicle(userChoice).getClass());
		
		if (clients[clientIndex].getVehicle(userChoice) instanceof ElectricCar) {
			ElectricCar[] tempECars = new ElectricCar[eCars.length + 1];
			tempECars[eCars.length] = (ElectricCar) clients[clientIndex].removeVehicle(userChoice);
			eCars = tempECars;
		}
		else if (clients[clientIndex].getVehicle(userChoice) instanceof GasCar) {
			GasCar[] tempGCars = new GasCar[gCars.length + 1];
			tempGCars[gCars.length] = (GasCar) clients[clientIndex].removeVehicle(userChoice);
			gCars = tempGCars;
		}
		else if (clients[clientIndex].getVehicle(userChoice) instanceof ElectricTruck) {
			ElectricTruck[] tempETrucks = new ElectricTruck[eTrucks.length + 1];
			tempETrucks[eTrucks.length] = (ElectricTruck) clients[clientIndex].removeVehicle(userChoice);
			eTrucks = tempETrucks;
		}
		else if (clients[clientIndex].getVehicle(userChoice) instanceof DieselTruck) {
			DieselTruck[] tempDTrucks = new DieselTruck[dTrucks.length + 1];
			tempDTrucks[dTrucks.length] = (DieselTruck) clients[clientIndex].removeVehicle(userChoice);
			dTrucks = tempDTrucks;
		}
			
	}
	
	/** prints all vehicle leased by the client the user chooses. */
	//prompt user to choose a client and display all vehicles leased by the client
	private static void showAllVehiclesLeasedByClient() {
		System.out.println("Enter number associated to client you want to view");
		for (int i = 0; i < clients.length; i++) {
			System.out.println(i + ". " + clients[i].getName());
		}
		userChoice = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("\n" + clients[userChoice].toString());
	}
	
	/** prints all leased vehicles by every client. */
	private static void showAllLeasedVehicles() {
		System.out.println("All leased vehicles");
		for (int i = 0; i < clients.length; i++) {
			System.out.println(clients[i].toString());
		}
	}
	
	/**
	 * removes an ElectricCar from the eCars array
	 * @param index index of car to be removed in eCars array
	 */
	private static void removeECar(int index) {
		// create temporary array with 1 less space than eCars
		// when index i matches userChoice, decrement k so k doens't skip an index in tempECar[]
		ElectricCar[] tempECar = new ElectricCar[eCars.length - 1];
		for (int i = 0, k = 0; i < eCars.length && k < tempECar.length; i++, k++) {
			// don't add the gCar that the user chooses
			if (i == index) {
				k--;
				continue;
			}
			
			else {
				tempECar[k] = eCars[i];
			}
		}
		
		// make gCars[] point to the new array with a car removed
		eCars = tempECar;
		return;
	}
	
	/**
	 * removes a GasCar from the gCars array
	 * @param index index of the car to be removed in gCars array
	 */
	private static void removeGCar(int index) {
		// create temporary array with 1 less space than gCars
		// when index i matches userChoice, decrement k so k doens't skip an index in tempGCar[]
		GasCar[] tempGCar = new GasCar[gCars.length - 1];
		for (int i = 0, k = 0; i < gCars.length && k < tempGCar.length; i++, k++) {
			// don't add the gCar that the user chooses
			if (i == index) {
				k--;
				continue;
			}
			
			else {
				tempGCar[k] = gCars[i];
			}
		}
		
		// make gCars[] point to the new array with a car removed
		gCars = tempGCar;
		return;
	}
	
	/**
	 * removes an ElectricTruck from the eTrucks array
	 * @param index index of the truck to be removed in eTrucks array
	 */
	private static void removeETruck(int index) {
		// create temporary array with 1 less space than eTrucks
		// when index i matches userChoice, decrement k so k doens't skip an index in tempGCar[]
		ElectricTruck[] tempETruck = new ElectricTruck[eTrucks.length - 1];
		for (int i = 0, k = 0; i < eTrucks.length && k < tempETruck.length; i++, k++) {
			// don't add the eTruck that the user chooses
			if (i == index) {
				k--;
				continue;
			}
			
			else {
				tempETruck[k] = eTrucks[i];
			}
		}
		
		// make eTrucks[] point to the new array with a car removed
		eTrucks = tempETruck;
		return;
	}
	
	/**
	 * removes a DieselTruck from the dTrucks array
	 * @param index index of the truck to be removed in dTrucks array
	 */
	private static void removeDTruck(int index) {
		// create temporary array with 1 less space than dTrucks
		// when index i matches userChoice, decrement k so k doens't skip an index in tempGCar[]
		DieselTruck[] tempDTruck = new DieselTruck[dTrucks.length - 1];
		for (int i = 0, k = 0; i < dTrucks.length && k < tempDTruck.length; i++, k++) {
			// don't add the dTruck that the user chooses
			if (i == index) {
				k--;
				continue;
			}
			
			else {
				tempDTruck[k] = dTrucks[i];
			}
		}
		
		// make dTrucks[] point to the new array with a car removed
		dTrucks = tempDTruck;
		return;
	}
	
	
	/** prints all vehicles that can be leased. */
	// lists all vehicles split into categories
	private static void listVehicles() {
		listElectricCars();
		listGasCars();
		listElectricTrucks();
		listDieselTrucks();
	}
	
	/** prints all ElectricCars that can be leased. */
	
	private static void listElectricCars() {
		System.out.println("All Electric Cars:\n");
		for (int i = 0; i < eCars.length; i++) {
			System.out.println("Index: " + i + "\n" + eCars[i].toString() + "\n");
		}
	}
	
	/** prints all GasCars that can be leased. */
	
	private static void listGasCars() {
		System.out.println("All Gas Cars\n");
		for (int i = 0; i < gCars.length; i++) {
			System.out.println("Index" + i + "\n" + gCars[i].toString() + "\n");
		}
	}
	
	/** prints all ElectricTrucks that can be leased. */
	
	private static void listElectricTrucks() {
		System.out.println("All Electric Trucks\n");
		for (int i = 0; i < eTrucks.length; i++) {
			System.out.println("Index: " + i + "\n" + eTrucks[i].toString() + "\n");
		}
	}
	
	/** prints all DieselTrucks that can be leased. */
	
	private static void listDieselTrucks() {
		System.out.println("All Diesel Trucks");
		for (int i = 0; i < dTrucks.length; i++) {
			System.out.println("Index: " + i + "\n" + dTrucks[i].toString() + "\n");
		}
	}
	
	
	/** the pre-defined option for testing code. */
	public static void preDefined() {
		ElectricTruck eTruck1 = new ElectricTruck(500, 10000, "Ford", "F-150", 2022);
		ElectricTruck eTruck2 = new ElectricTruck(500, 10000, "Ford", "F-150", 2022);
		ElectricTruck eTruck3 = new ElectricTruck(520, 11000, "Tesla", "Cybertruck", 2024);
		
		DieselTruck dTruck1 = new DieselTruck(100, 20000, "Ford", "F-350", 2023);
		DieselTruck dTruck2 = new DieselTruck(100, 20000, "Ford", "F-350", 2023);
		DieselTruck dTruck3 = new DieselTruck(110, 21000, "Dodge", "Ram-2500", 2024);
		
		ElectricCar eCar1 = new ElectricCar(501, 5, "Tesla", "Model S", 2023);
		ElectricCar eCar2 = new ElectricCar(501, 5, "Tesla", "Model S", 2023);
		ElectricCar eCar3 = new ElectricCar(550, 5, "Lucid", "Air", 2024);
		
		GasCar gCar1 = new GasCar(5, "Toyota", "Corolla", 2025);
		GasCar gCar2 = new GasCar(5, "Toyota", "Corolla", 2025);
		GasCar gCar3 = new GasCar(4, "Honda", "Civic", 2023);
		
		clients = new Client[3];
		clients[0] = new Client("Tom");
		clients[1] = new Client("Tom");
		clients[2] = new Client("Stella");
		
		clients[0].addVehicle(eTruck1);
		clients[1].addVehicle(eTruck1);
		clients[2].addVehicle(gCar3);
		
		System.out.println("eTruck1 equals dTruck1 " + eTruck1.equals(dTruck1));
		System.out.println("eCar1 equals eCar3 " + eCar1.equals(eCar3));
		System.out.println("eCar1 equals eCar2 " + eCar1.equals(eCar2));
		System.out.println("client1 equals client2 " + clients[0].equals(clients[1]));
		System.out.println("client 1 equals client3 " + clients[0].equals(clients[2]));
		
		clients[0].addVehicle(gCar1);
		
		System.out.println("new client 1 equals client2 " + clients[1].equals(clients[0]));		
		
		eTrucks = new ElectricTruck[3];
		eTrucks[0] = new ElectricTruck(eTruck1);
		eTrucks[1] = new ElectricTruck(eTruck2);
		eTrucks[2] = new ElectricTruck(eTruck1);
		
		dTrucks = new DieselTruck[3];
		dTrucks[0] = new DieselTruck(dTruck1);
		dTrucks[1] = new DieselTruck(dTruck2);
		dTrucks[2] = new DieselTruck(dTruck3);
		
		eCars = new ElectricCar[3];
		eCars[0] = new ElectricCar(eCar1);
		eCars[1] = new ElectricCar(eCar2);
		eCars[2] = new ElectricCar(eCar3);
		
		gCars = new GasCar[3];
		gCars[0] = new GasCar(gCar1);
		gCars[1] = new GasCar(gCar2);
		gCars[2] = new GasCar(gCar3);
		
		Vehicle[] vehicles = new Vehicle[6];
		vehicles[0] = new ElectricCar(eCar1);
		vehicles[1] = new ElectricCar(eCar2);
		vehicles[2] = new GasCar(gCar1);
		vehicles[3] = new DieselTruck(dTruck1);
		vehicles[4] = new ElectricTruck(eTruck1);
		vehicles[5] = new ElectricTruck(eTruck3);
		// check if polymorphism is working
		System.out.println("vehicles[0] = vehicles[1] " + vehicles[0].equals(vehicles[1]));
		System.out.println("vehicles[0] = vehicles[2] " + vehicles[0].equals(vehicles[2]));
		
		System.out.println(Truck.getLargestTruck(dTrucks).toString());
		
		deepCopyETruck = Vehicle.copyVehicles(eTrucks);
		
		System.out.println("eTruck equals electricTrucks " + (eTrucks == deepCopyETruck));
		System.out.println("eTruck[0] equals electricTrucks[0] "+ eTrucks[0].equals(deepCopyETruck[0]));
		System.out.println(deepCopyETruck[0].toString());
		
	}
	

}
