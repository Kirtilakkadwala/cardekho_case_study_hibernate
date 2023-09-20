package com.jspiders.cardekho_case_study_hibernate.main;

import java.util.Scanner;

import com.jspiders.cardekho_case_study_hibernate.dao.CarDAO;
import com.jspiders.cardekho_case_study_hibernate.dto.CarDTO;

public class CarMain {
 public static void main(String[] args) {
	 CarDAO carDAO = new CarDAO();
     Scanner scanner = new Scanner(System.in);

     boolean exit = true;

     while (exit) {
    	System.out.println("\n================== Menu =======================");
 		System.out.println("1.Add Car Details");
 		System.out.println("2.Search Car Details");
 		System.out.println("3.Upadte Car Details");
 		System.out.println("4.Delete Car Details");
 		System.out.println("5.Exit");

         int choice = scanner.nextInt();

         switch (choice) {
             case 1:
             CarDTO carDto= new CarDTO();
             System.out.print("Enter Car ID: ");
             carDto.setCar_id(scanner.nextInt());
             System.out.print("Enter Car Name: ");
             carDto.setName(scanner.next());
             System.out.print("Enter Car Brand: ");
             carDto.setBrand(scanner.next());
             System.out.print("Enter Fuel Type: ");
             carDto.setFuel_type(scanner.next());
             System.out.print("Enter Price: ");
             carDto.setPrice(scanner.nextInt());

             carDAO.addCar(carDto);
             System.out.println("Car Added Successfully.");
             break;

         case 2:
        	 System.out.println("=======Menu======\n" 
                      + "1.Search Car By Name \n" 
			           + "2.Search Car By Brand \n"
			           + "3.Search Car By Fuel Type \n" 
			           + "4.All Cars ");
        	int choice2 = scanner.nextInt();
 			switch (choice2) {
 			case 1:
 				System.out.print("Enter Car Name: ");
 	             String car_name= scanner.next();
 	             CarDTO getCar_name = carDAO.searchByName(car_name);
 	             if (getCar_name != null) {
 	                 System.out.println("get Car details: " + getCar_name);
 	             } else {
 	                 System.out.println("Car Not Found.");
 	             }
 	             break;
 			case 2:
 				System.out.print("Enter Car Model: ");
 				String car_model= scanner.next();
	             CarDTO getCar_model = carDAO.searchByName(car_model);
	             if (getCar_model != null) {
	                 System.out.println("get Car details: " + getCar_model);
	             } else {
	                 System.out.println("Car Not Found.");
	             }
	             break;
 			case 3:
 				System.out.print("Enter Car Fuel Type: ");
 				String fuel_type= scanner.next();
	             CarDTO getCar_fuel= carDAO.searchByFuelType(fuel_type);
	             if (getCar_fuel != null) {
	                 System.out.println("get Car details: " + getCar_fuel);
	             } else {
	                 System.out.println("Car Not Found.");
	             }
	             break;
 			case 4:
 				System.out.print("Enter Car Id: ");
                int car_id= scanner.nextInt();
                CarDTO getCar = carDAO.searchAllCar(car_id);
                if (getCar != null) {
                  System.out.println("get Car details: " + getCar);
                } else {
                  System.out.println("Car Not Found.");
                }
                break;
 			default: {
				System.out.println("Invaild choice");
			}
				break;
			}
			break;

         case 3:
             System.out.print("Enter Car Id: ");
             int car_id = scanner.nextInt();
             CarDTO carToUpdate = carDAO.searchAllCar(car_id);
             if (carToUpdate != null) {
                 System.out.print("Enter Car Name: ");
                 carToUpdate.setName(scanner.next());
                 System.out.print("Enter Car Brand: ");
                 carToUpdate.setBrand(scanner.next());
                 System.out.print("Enter Fuel Type: ");
                 carToUpdate.setFuel_type(scanner.next());
                 System.out.print("Enter Price: ");
                 carToUpdate.setPrice(scanner.nextInt());
                 carDAO.updateCar(carToUpdate);
                 System.out.println("Car Updated Successfully.");
             } else {
                 System.out.println("Car Not Found.");
             }
             break;

            case 4:
             System.out.print("Enter Car Id: ");
             int car_id2= scanner.nextInt();
             carDAO.deleteCar(car_id2);
             System.out.println("Car Deleted Successfully.");
             break;

             case 5:
            	 System.out.println("Thank you..!!");
     			exit = false;
     			scanner.close();
     			break;
             default:
     			System.out.println("\nInvalid choice. Try again..!!");
     			break;
     		}

     }

     scanner.close();
 }
}

