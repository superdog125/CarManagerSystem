package com.service.driver;

import java.util.List;

import com.domain.Driver;

public interface DriverService {
	public void addDriver(Driver driver);
	
	public void QueryDriverById(Integer tid);
	
	public List<Driver> QueryAllDriver();
	
	public void changeDriver(Driver driver);
	
	public void dropDriver(Driver driver);
}
