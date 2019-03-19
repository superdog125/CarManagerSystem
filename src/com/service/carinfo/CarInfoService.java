package com.service.carinfo;

import java.util.List;

import com.domain.CarInfo;

public interface CarInfoService {
	public void addCarInfo(CarInfo carInfo);
	
	public void QueryCarInfoById(Integer cid);
	
	public List<CarInfo> QueryAllCarInfo();
	
	public void changeCarInfo(CarInfo carInfo);
	
	public void dropCarInfo(CarInfo carInfo);
}
