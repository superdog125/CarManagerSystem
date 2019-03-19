package com.dao.impl.techer;

import java.util.ArrayList;
import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.dao.techer.TecherDao;
import com.domain.Car;
import com.domain.Techer;

public class TecherDaoImpl extends HibernateDaoSupport implements TecherDao {

	@Override
	public void insertTecher(Techer techer) {
		this.getHibernateTemplate().save(techer);

	}

	@Override
	public Techer findTecherById(Integer tid) {
		ArrayList<Techer> techerlist = new ArrayList<Techer>();
		techerlist = (ArrayList<Techer>) this.getHibernateTemplate().find("from Techer where tid=?", tid);
		return techerlist.get(0);
	}

	@Override
	public List<Techer> findAllTecher() {
		ArrayList<Techer> techerlist = new ArrayList<Techer>();
		techerlist = (ArrayList<Techer>) this.getHibernateTemplate().find("from Techer");
		return techerlist;
	}

	@Override
	public void updateTecher(Techer techer) {
		System.out.println("repeat:" + techer);
		this.getHibernateTemplate().update(techer);

	}

	@Override
	public void deleteTecher(Techer techer) {
		this.getHibernateTemplate().delete(techer);

	}

}
