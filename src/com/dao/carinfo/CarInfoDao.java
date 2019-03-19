package com.dao.carinfo;

import java.util.List;

import com.domain.CarInfo;

public interface CarInfoDao {
	public void insertCarInfo(CarInfo carInfo);

	public CarInfo findCarInfoById(Integer cid);
	
	public List<CarInfo> findAllCarInfo();

	public void updateCarInfo(CarInfo carInfo);

	public void deleteCarInfo(CarInfo carInfo);
}
