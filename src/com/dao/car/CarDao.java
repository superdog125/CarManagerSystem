package com.dao.car;

import java.util.List;

import com.domain.Car;

public interface CarDao {
	
		public void insertCar(Car car);

		public Car findCarById(Integer cid);
		
		public List<Car> findAllCar();

		public void updateCar(Car car);

		public void deleteCar(Car car);
	
	
}
