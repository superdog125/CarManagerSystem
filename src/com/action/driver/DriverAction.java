package com.action.driver;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.apache.struts2.ServletActionContext;

import com.domain.Car;
import com.domain.Driver;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.driver.DriverService;

public class DriverAction extends ActionSupport implements ModelDriven<Driver>{

	private static final long serialVersionUID = 1L;
	private Driver driver;
	private DriverService driverService;

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public DriverService getDriverService() {
		return driverService;
	}

	public void setDriverService(DriverService driverService) {
		this.driverService = driverService;
	}

	@Override
	public Driver getModel() {
		return driver;
	}
	
	public String add(){
		try{
			System.out.println("����˾��" + driver);
			driverService.addDriver(driver);
		}catch (Exception e){
			System.out.println("add���������");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";

	}

	public String delete(){
		try{
			driverService.dropDriver(driver);
		}catch (Exception e){
			System.out.println("delete���������");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";

	}
	
	public String update(){
		try{
			System.out.println("˾����Ϣ�䶯" + driver);
			driverService.changeDriver(driver);
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
			System.out.println("��ѯȫ��˾����Ϣ��...");
			System.out.println("���ܿͻ�����Ϣ:" + driver);
			ArrayList<Driver> driverlist = new ArrayList<Driver>();
			driverlist = (ArrayList<Driver>) driverService.QueryAllDriver();
			System.out.println("��ѯ���:" + driverlist);
//			Map session = ActionContext.getContext().getSession();  
//			session.put("carlist", carlist);
//			String driverString = new Gson().toJson(driverlist);
//			System.out.println("jsonת�����" + driverString);
			
			List driverlist1 = new ArrayList();  // ���jsonת����Ԫ��
			List noinfolist = new ArrayList();   	// ��Ų���jsonת����Ԫ��carinfo_ciid  ��������Ԫ��
			for (Driver driver1: driverlist){
				Driver driver2 = new Driver();
				driver2.setDid(driver1.getDid());
				driver2.setDname(driver1.getDname());
				driver2.setDphone(driver1.getDphone());
				driver2.setDpassword(driver1.getDpassword());
				driver2.setDworkyear(driver1.getDworkyear());
				driver2.setDsex(driver1.getDsex());
				driver2.setDage(driver1.getDage());
				driverlist1.add(driver2);
				noinfolist.add(driver1.getCarinfo());
			}
			JSONArray result = JSONArray.fromObject(driverlist1);
			System.out.println("jsonת�����" + result);
			
			out.println(result);
		}catch (Exception e){
			System.out.println("find���������");
			System.out.println(e.getMessage());
		}
	    out.flush();
	    out.close();
	}
}
