package com.service.techer;

import java.util.List;

import com.domain.Techer;

public interface TecherService {
	public void addTecher(Techer techer);
	
	public void QueryTecherById(Integer cid);
	
	public List<Techer> QueryAllTecher();
	
	public void changeTecher(Techer techer);
	
	public void dropTecher(Techer techer);
}
