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
			System.out.println("��������" + car);
			carService.addCar(car);
		}catch (Exception e){
			System.out.println("add���������");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";

	}

	public String delete(){
		try{
			carService.dropCar(car);
		}catch (Exception e){
			System.out.println("delete���������");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";

	}
	
	public String update(){
		try{
			System.out.println("������Ϣ�䶯" + car);
			carService.changeCar(car);
		}catch (Exception e){
			System.out.println("update���������");
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
			System.out.println("��ѯȫ��������Ϣ��...");
			System.out.println("���ܿͻ�����Ϣ:" + car);
			ArrayList<Car> carlist = new ArrayList<Car>();
			carlist = (ArrayList<Car>) carService.QueryAllCar();
			System.out.println("��ѯ���:" + carlist);
//			String carString = new Gson().toJson(carlist);
//			System.out.println("jsonת�����" + carString);
			
			List carlist1 = new ArrayList();  // ���jsonת����Ԫ��
			List noinfolist = new ArrayList();   	// ��Ų���jsonת����Ԫ��carinfo_ciid  ��������Ԫ��
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
			System.out.println("jsonת�����" + result);
			
			out.print(result);
		}catch (Exception e){
			System.out.println("find���������");
			System.out.println(e.getMessage());
		}
	    out.flush();
	    out.close();
	}
}
