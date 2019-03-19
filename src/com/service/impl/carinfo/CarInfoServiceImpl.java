package com.service.impl.carinfo;

import java.util.List;

import com.dao.carinfo.CarInfoDao;
import com.domain.CarInfo;
import com.service.carinfo.CarInfoService;

public class CarInfoServiceImpl implements CarInfoService{
	public CarInfoDao carInfoDao;
	
	
	public CarInfoDao getCarInfoDao() {
		return carInfoDao;
	}

	public void setCarInfoDao(CarInfoDao carInfoDao) {
		this.carInfoDao = carInfoDao;
	}

	@Override
	public void addCarInfo(CarInfo carInfo) {
		carInfoDao.insertCarInfo(carInfo);
	}

	@Override
	public void QueryCarInfoById(Integer cid) {
		carInfoDao.findCarInfoById(cid);

	}

	@Override
	public void changeCarInfo(CarInfo carInfo) {
		carInfoDao.updateCarInfo(carInfo);
	}

	@Override
	public void dropCarInfo(CarInfo carInfo) {
		carInfoDao.deleteCarInfo(carInfo);

	}

	@Override
	public List<CarInfo> QueryAllCarInfo() {
		return carInfoDao.findAllCarInfo();
	}
}
