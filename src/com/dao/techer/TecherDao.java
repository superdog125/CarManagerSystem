package com.dao.techer;

import java.util.List;

import com.domain.Techer;

public interface TecherDao {
	public void insertTecher(Techer techer);

	public Techer findTecherById(Integer tid);
	
	public List<Techer> findAllTecher();

	public void updateTecher(Techer techer);

	public void deleteTecher(Techer techer);
}
