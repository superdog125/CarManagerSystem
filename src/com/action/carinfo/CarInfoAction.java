package com.action.carinfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

import com.domain.CarInfo;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.carinfo.CarInfoService;

public class CarInfoAction extends ActionSupport implements ModelDriven<CarInfo>{

	private static final long serialVersionUID = 1L;
	private CarInfo carInfo;;
	private CarInfoService carInfoService;
	
	public CarInfo getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(CarInfo carInfo) {
		this.carInfo = carInfo;
	}

	public CarInfoService getCarInfoService() {
		return carInfoService;
	}

	public void setCarInfoService(CarInfoService carInfoService) {
		this.carInfoService = carInfoService;
	}

	@Override
	public CarInfo getModel() {
		return carInfo;
	}
	
	public String add(){
		try{
			System.out.println("����������ʻ��Ϣ" + carInfo);
			carInfoService.addCarInfo(carInfo);
		}catch (Exception e){
			System.out.println("add���������");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";

	}

	public String delete(){
		try{
			carInfoService.dropCarInfo(carInfo);
		}catch (Exception e){
			System.out.println("delete���������");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";

	}
	
	public String update(){
		try{
			System.out.println("������ʻ��Ϣ�䶯" + carInfo);
			carInfoService.changeCarInfo(carInfo);
		}catch (Exception e){
			System.out.println("update���������");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";
	}
	
	public void find() throws IOException{
		HttpServletResponse response= ServletActionContext.getResponse();
		response.setContentType("text/plain; charset=UTF-8");
		response.setHeader("Access-Control-Allow-Origin", "*"); 		  
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,Content-Length, Authorization, Accept,X-Requested-With");  
        response.setHeader("Access-Control-Allow-Methods","PUT,POST,GET,DELETE,OPTIONS");  	
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
		try{
			System.out.println("��ѯȫ��������ʻ��Ϣ��...");
			System.out.println("���ܿͻ�����Ϣ:" + carInfo);
			ArrayList<CarInfo> carInfolist = new ArrayList<CarInfo>();
			carInfolist = (ArrayList<CarInfo>) carInfoService.QueryAllCarInfo();
			System.out.println("��ѯ���:" + carInfolist);
			
			// ת�����ڸ�ʽ
//			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//			Gson gson = new Gson();
//			String carInfoString = gson.toJson(carInfolist);
//			System.out.println("jsonת�����" + carInfoString);
//			System.out.println("476686897");
//			out.println(carInfoString);
//			out.println(carInfolist);
			List carInfolist1 = new ArrayList();  // ���jsonת����Ԫ��
			List nocarlist = new ArrayList();   	// ��Ų���jsonת����Ԫ��car_cname  ��������Ԫ��
			List nodriverlist = new ArrayList();   	// ��Ų���jsonת����Ԫ��driver_did  ��������Ԫ��
			// Step1: ����ѯ����ʵ��������ѭ��ȥ��������������ֶΣ��������һ��ʵ��������(��������Щ�ֶ�)
			for (CarInfo carinfo1: carInfolist){
				CarInfo carinfo2 = new CarInfo();
				carinfo2.setCiid(carinfo1.getCiid());
				carinfo2.setCistart(carinfo1.getCistart());
				carinfo2.setCiend(carinfo1.getCiend());
				carinfo2.setCioil(carinfo1.getCioil());
				carinfo2.setCicost(carinfo1.getCicost());
				carinfo2.setCitime(carinfo1.getCitime());
				nocarlist.add(carinfo1.getCar().getCnumber());  // ��������ӵĶ��Ǿ�����ֶ�
				nodriverlist.add(carinfo1.getDriver().getDid());
				carInfolist1.add(carinfo2);
			}
			// Step2: ����ʵ��������ת��ΪJson����
			JSONArray result = JSONArray.fromObject(carInfolist1);
			// Step2: ��Json����������
			if(result.size()>0){
				  for(int i=0;i<result.size();i++){
				    JSONObject job = result.getJSONObject(i);  // ���� jsonarray ���飬��ÿһ������ת�� json ����
				    job.put("cnumber",nocarlist.get(i));
				    job.put("did",nodriverlist.get(i));
				  }
				}
			System.out.println("jsonת�����" + result);
			out.print(result.toString());
			
		}catch (Exception e){
			System.out.println("find���������");
			System.out.println(e.getMessage());
		}
	    out.flush();
	    out.close();
	}
}
