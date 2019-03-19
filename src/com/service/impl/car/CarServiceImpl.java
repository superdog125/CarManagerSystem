package com.service.impl.car;

import java.util.List;

import com.dao.car.CarDao;
import com.domain.Car;
import com.service.car.CarService;

public class CarServiceImpl implements CarService {

	public CarDao carDao;
	
	
	public CarDao getCarDao() {
		return carDao;
	}

	public void setCarDao(CarDao carDao) {
		this.carDao = carDao;
	}

	@Override
	public void addCar(Car car) {
		carDao.insertCar(car);
	}

	@Override
	public void QueryCarById(Integer cid) {
		carDao.findCarById(cid);

	}

	@Override
	public void changeCar(Car car) {
		carDao.updateCar(car);
	}

	@Override
	public void dropCar(Car car) {
		carDao.deleteCar(car);

	}

	@Override
	public List<Car> QueryAllCar() {
		return carDao.findAllCar();
	}

}
