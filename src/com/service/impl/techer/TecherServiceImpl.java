package com.service.impl.techer;

import java.util.List;

import com.dao.techer.TecherDao;
import com.domain.Techer;
import com.service.techer.TecherService;

public class TecherServiceImpl implements TecherService {

	public TecherDao techerDao;
	
	
	public TecherDao getTecherDao() {
		return techerDao;
	}

	public void setTecherDao(TecherDao techerDao) {
		this.techerDao = techerDao;
	}

	@Override
	public void addTecher(Techer techer) {
		techerDao.insertTecher(techer);
	}

	@Override
	public void QueryTecherById(Integer cid) {
		techerDao.findTecherById(cid);

	}

	@Override
	public void changeTecher(Techer techer) {
		techerDao.updateTecher(techer);
	}

	@Override
	public void dropTecher(Techer techer) {
		techerDao.deleteTecher(techer);

	}

	@Override
	public List<Techer> QueryAllTecher() {
		return techerDao.findAllTecher();
	}


}
