package com.action.techer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.domain.Techer;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.service.techer.TecherService;

public class TecherAction extends ActionSupport implements ModelDriven<Techer>{

	private static final long serialVersionUID = 1L;
	private Techer techer;
	private TecherService techerService;
	
	public Techer getTecher() {
		return techer;
	}

	public void setTecher(Techer techer) {
		this.techer = techer;
	}

	public TecherService getTecherService() {
		return techerService;
	}

	public void setTecherService(TecherService techerService) {
		this.techerService = techerService;
	}

	@Override
	public Techer getModel() {
		return techer;
	}
	
	public String add(){
		try{
			System.out.println("������ʦ" + techer);
			techerService.addTecher(techer);
		}catch (Exception e){
			System.out.println("add���������");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";

	}

	public String delete(){
		try{
			System.out.println("��ʦ��Ϣɾ��" + techer);
			techerService.dropTecher(techer);
		}catch (Exception e){
			System.out.println("delete���������");
			System.out.println(e.getMessage());
			return "input";
		}
		return "success";

	}
	
	public String update(){
		System.out.println("update��������");
		try{
			System.out.println("��ʦ��Ϣ�䶯" + techer);
			techerService.changeTecher(techer);
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
			System.out.println("��ѯȫ����ʦ��Ϣ��...");
			System.out.println("���ܿͻ�����Ϣ:" + techer);
			ArrayList<Techer> techerlist = new ArrayList<Techer>();
			techerlist = (ArrayList<Techer>) techerService.QueryAllTecher();
			System.out.println("��ѯ���:" + techerlist);
//			Map session = ActionContext.getContext().getSession();  
//			session.put("techerlist", techerlist);
			String techerString = new Gson().toJson(techerlist);
			System.out.println("jsonת�����" + techerString);
			out.print(techerString);
		}catch (Exception e){
			System.out.println("find���������");
			System.out.println(e.getMessage());
		}
	    out.flush();
	    out.close();
	}
}
