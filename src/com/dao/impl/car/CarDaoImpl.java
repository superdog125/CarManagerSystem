package com.dao.impl.car;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.car.CarDao;
import com.domain.Car;

public class CarDaoImpl extends HibernateDaoSupport implements CarDao {

	@Override
	public void insertCar(Car car) {
		this.getHibernateTemplate().save(car);
	}

	@Override
	public Car findCarById(Integer cid) {
		ArrayList<Car> carlist = new ArrayList<Car>();
		carlist = (ArrayList<Car>) this.getHibernateTemplate().find("from Car where cid=?", cid);
		return carlist.get(0);	}

	@Override
	public void updateCar(Car car) {
		this.getHibernateTemplate().update(car);
	}

	@Override
	public void deleteCar(Car car) {
		this.getHibernateTemplate().delete(car);
	}

	@Override
	public List<Car> findAllCar() {
		ArrayList<Car> carlist = new ArrayList<Car>();
		carlist = (ArrayList<Car>) this.getHibernateTemplate().find("from Car");
		return carlist;
	}

}
