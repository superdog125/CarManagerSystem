package com.action.car;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.domain.Car;
import com.domain.CarInfo;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.car.CarService;

public class CarAction extends ActionSupport implements ModelDriven<Car>{

	private static final long serialVersionUID = 1L;
	private Car car;
	private CarService carService;
	
	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public CarService getCarService() {
		return carService;
	}

	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@Override
	public Car getModel() {
		return car;
	}
	
	public String add(){
		try{
			System.out.println("新增车辆" + car);
			carService.addCar(car);
		}catch (Exception e){
			System.out.println("add这里出错啦");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";

	}

	public String delete(){
		try{
			carService.dropCar(car);
		}catch (Exception e){
			System.out.println("delete这里出错啦");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";

	}
	
	public String update(){
		try{
			System.out.println("车辆信息变动" + car);
			carService.changeCar(car);
		}catch (Exception e){
			System.out.println("update这里出错啦");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";
	}
	
	public void find() throws IOException{
		HttpServletResponse response= ServletActionContext.getResponse();
		response.setHeader("Access-Control-Allow-Origin", "*"); 		  
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  	
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
		try{
			System.out.println("查询全部车辆信息中...");
			System.out.println("接受客户端消息:" + car);
			ArrayList<Car> carlist = new ArrayList<Car>();
			carlist = (ArrayList<Car>) carService.QueryAllCar();
			System.out.println("查询结果:" + carlist);
//			String carString = new Gson().toJson(carlist);
//			System.out.println("json转换结果" + carString);
			
			List carlist1 = new ArrayList();  // 存放json转化的元素
			List noinfolist = new ArrayList();   	// 存放不可json转化的元素carinfo_ciid  即多表关联元素
			for (Car car1: carlist){
				Car car2 = new Car();
				car2.setCid(car1.getCid());
				car2.setCbrand(car1.getCbrand());
				car2.setCnumber(car1.getCnumber());
				car2.setCfix(car1.getCfix());
				car2.setCproblem(car1.getCproblem());
				car2.setCcheck(car1.getCcheck());
				carlist1.add(car2);
				noinfolist.add(car1.getCarinfo());
			}
			JSONArray result = JSONArray.fromObject(carlist1);
			System.out.println("json转换结果" + result);
			
			out.print(result);
		}catch (Exception e){
			System.out.println("find这里出错啦");
			System.out.println(e.getMessage());
		}
	    out.flush();
	    out.close();
	}
}
