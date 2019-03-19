package com.service.impl.driver;

import java.util.List;

import com.dao.driver.DriverDao;
import com.domain.Driver;
import com.service.driver.DriverService;

public class DriverServiceImpl implements DriverService{
	public DriverDao driverDao;
	
	
	public DriverDao getDriverDao() {
		return driverDao;
	}

	public void setDriverDao(DriverDao driverDao) {
		this.driverDao = driverDao;
	}

	@Override
	public void addDriver(Driver driver) {
		driverDao.insertDriver(driver);
	}

	@Override
	public void QueryDriverById(Integer tid) {
		driverDao.findDriverById(tid);

	}

	@Override
	public void changeDriver(Driver driver) {
		driverDao.updateDriver(driver);
	}

	@Override
	public void dropDriver(Driver driver) {
		driverDao.deleteDriver(driver);

	}

	@Override
	public List<Driver> QueryAllDriver() {
		return driverDao.findAllDriver();
	}

}
