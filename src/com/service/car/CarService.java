package com.service.car;

import java.util.List;

import com.domain.Car;

public interface CarService {
	
	public void addCar(Car car);
	
	public void QueryCarById(Integer cid);
	
	public List<Car> QueryAllCar();
	
	public void changeCar(Car car);
	
	public void dropCar(Car car);
}
