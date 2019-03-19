package com.dao.driver;

import java.util.List;

import com.domain.Car;
import com.domain.Driver;

public interface DriverDao {
	public void insertDriver(Driver driver);

	public Driver findDriverById(Integer did);
	
	public List<Driver> findAllDriver();

	public void updateDriver(Driver driver);

	public void deleteDriver(Driver driver);

}
