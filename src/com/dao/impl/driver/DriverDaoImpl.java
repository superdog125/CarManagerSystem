package com.dao.impl.driver;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.driver.DriverDao;
import com.domain.Car;
import com.domain.Driver;

public class DriverDaoImpl extends HibernateDaoSupport implements DriverDao{

	@Override
	public void insertDriver(Driver driver) {
		this.getHibernateTemplate().save(driver);
		
	}

	@Override
	public Driver findDriverById(Integer tid) {
		ArrayList<Driver> driverlist = new ArrayList<Driver>();
		driverlist = (ArrayList<Driver>) this.getHibernateTemplate().find("from Driver where tid=?", tid);
		return driverlist.get(0);
	}

	@Override
	public List<Driver> findAllDriver() {
		ArrayList<Driver> driverlist = new ArrayList<Driver>();
		driverlist = (ArrayList<Driver>) this.getHibernateTemplate().find("from Driver");
		return driverlist;
	}

	@Override
	public void updateDriver(Driver driver) {
		this.getHibernateTemplate().update(driver);
	}

	@Override
	public void deleteDriver(Driver driver) {
		this.getHibernateTemplate().delete(driver);
	}

}
