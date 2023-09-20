package com.jspiders.cardekho_case_study_hibernate.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.jspiders.cardekho_case_study_hibernate.dto.CarDTO;

public class CarDAO {
	private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;
    private static EntityTransaction entityTransaction;
    
    private static void openConnection() {
    	entityManagerFactory = Persistence.createEntityManagerFactory("car");
    	entityManager = entityManagerFactory.createEntityManager();
   	    entityTransaction = entityManager.getTransaction();
    }
    
    private static void closeConnection() 
    {
   	 if(entityManagerFactory != null) {
   		 entityManagerFactory.close();
   	 }
   	 if(entityManager != null) {
   		 entityManager.close();
   	 }
   	 if(entityTransaction != null) {
   		 if(entityTransaction.isActive()) {
   			 entityTransaction.rollback();
   		 }
   	 }
    }
    
    public void addCar(CarDTO car) {
        openConnection();
        entityTransaction.begin();
        
        entityManager.persist(car);
        
        entityTransaction.commit();
        closeConnection();
    }

    public CarDTO searchAllCar(int car_id) {
        openConnection();
        entityTransaction.begin();
        CarDTO car = entityManager.find(CarDTO.class, car_id);
        System.out.println(car);
        entityTransaction.commit();
        closeConnection();
        return car;
    }
    public CarDTO searchByName(String name) {
        openConnection();
        entityTransaction.begin();
        CarDTO car = entityManager.find(CarDTO.class, name);
        System.out.println(car);
        entityTransaction.commit();
        closeConnection();
        return car;
    }
    public CarDTO searchByModel(String model) {
        openConnection();
        entityTransaction.begin();
        CarDTO car = entityManager.find(CarDTO.class, model);
        System.out.println(car);
        entityTransaction.commit();
        closeConnection();
        return car;
    }
    public CarDTO searchByFuelType(String fuel_type) {
        openConnection();
        entityTransaction.begin();
        CarDTO car = entityManager.find(CarDTO.class, fuel_type);
        System.out.println(car);
        entityTransaction.commit();
        closeConnection();
        return car;
    }

    public void updateCar(CarDTO carToUpdate) {
        openConnection();
        entityTransaction.begin();
		CarDTO car1 = entityManager.find(CarDTO.class, carToUpdate);
        entityManager.persist(car1);
        entityTransaction.commit();
        closeConnection();
    }

    public void deleteCar(int carId) {
        openConnection();
        entityTransaction.begin();
        
        CarDTO car = entityManager.find(CarDTO.class, carId);
        if (car != null) {
            entityManager.remove(car);
        }
        
        entityTransaction.commit();
        closeConnection();
    }
}
