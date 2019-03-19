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
			System.out.println("新增车辆行驶信息" + carInfo);
			carInfoService.addCarInfo(carInfo);
		}catch (Exception e){
			System.out.println("add这里出错啦");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";

	}

	public String delete(){
		try{
			carInfoService.dropCarInfo(carInfo);
		}catch (Exception e){
			System.out.println("delete这里出错啦");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";

	}
	
	public String update(){
		try{
			System.out.println("车辆行驶信息变动" + carInfo);
			carInfoService.changeCarInfo(carInfo);
		}catch (Exception e){
			System.out.println("update这里出错啦");
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
			System.out.println("查询全部车辆行驶信息中...");
			System.out.println("接受客户端消息:" + carInfo);
			ArrayList<CarInfo> carInfolist = new ArrayList<CarInfo>();
			carInfolist = (ArrayList<CarInfo>) carInfoService.QueryAllCarInfo();
			System.out.println("查询结果:" + carInfolist);
			
			// 转换日期格式
//			Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
//			Gson gson = new Gson();
//			String carInfoString = gson.toJson(carInfolist);
//			System.out.println("json转换结果" + carInfoString);
//			System.out.println("476686897");
//			out.println(carInfoString);
//			out.println(carInfolist);
			List carInfolist1 = new ArrayList();  // 存放json转化的元素
			List nocarlist = new ArrayList();   	// 存放不可json转化的元素car_cname  即多表关联元素
			List nodriverlist = new ArrayList();   	// 存放不可json转化的元素driver_did  即多表关联元素
			// Step1: 将查询到的实体类数组循环去掉含关联外键的字段，重新组成一个实体类数据(就是少了些字段)
			for (CarInfo carinfo1: carInfolist){
				CarInfo carinfo2 = new CarInfo();
				carinfo2.setCiid(carinfo1.getCiid());
				carinfo2.setCistart(carinfo1.getCistart());
				carinfo2.setCiend(carinfo1.getCiend());
				carinfo2.setCioil(carinfo1.getCioil());
				carinfo2.setCicost(carinfo1.getCicost());
				carinfo2.setCitime(carinfo1.getCitime());
				nocarlist.add(carinfo1.getCar().getCnumber());  // 数组中添加的都是具体的字段
				nodriverlist.add(carinfo1.getDriver().getDid());
				carInfolist1.add(carinfo2);
			}
			// Step2: 将新实体类数据转化为Json数组
			JSONArray result = JSONArray.fromObject(carInfolist1);
			// Step2: 将Json数组迭代添加
			if(result.size()>0){
				  for(int i=0;i<result.size();i++){
				    JSONObject job = result.getJSONObject(i);  // 遍历 jsonarray 数组，把每一个对象转成 json 对象
				    job.put("cnumber",nocarlist.get(i));
				    job.put("did",nodriverlist.get(i));
				  }
				}
			System.out.println("json转换结果" + result);
			out.print(result.toString());
			
		}catch (Exception e){
			System.out.println("find这里出错啦");
			System.out.println(e.getMessage());
		}
	    out.flush();
	    out.close();
	}
}
