package com.dao.impl.carinfo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.carinfo.CarInfoDao;
import com.domain.CarInfo;

public class CarInfoDaoImpl extends HibernateDaoSupport implements CarInfoDao {

	@Override
	public void insertCarInfo(CarInfo carInfo) {
		this.getHibernateTemplate().save(carInfo);
	}

	@Override
	public CarInfo findCarInfoById(Integer ciid) {
		ArrayList<CarInfo> carInfolist = new ArrayList<CarInfo>();
		carInfolist = (ArrayList<CarInfo>) this.getHibernateTemplate().find("from CarInfo where ciid=?", ciid);
		return carInfolist.get(0);	}

	@Override
	public void updateCarInfo(CarInfo carInfo) {
		this.getHibernateTemplate().update(carInfo);
	}

	@Override
	public void deleteCarInfo(CarInfo carInfo) {
		this.getHibernateTemplate().delete(carInfo);
	}

	@Override
	public List<CarInfo> findAllCarInfo() {
		ArrayList<CarInfo> carInfolist = new ArrayList<CarInfo>();
		carInfolist = (ArrayList<CarInfo>) this.getHibernateTemplate().find("from CarInfo");
		return carInfolist;
	}

}
