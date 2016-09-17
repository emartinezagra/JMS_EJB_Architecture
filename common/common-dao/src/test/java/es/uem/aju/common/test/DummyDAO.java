package es.uem.aju.common.test;

import java.util.List;

import es.uem.aju.common.dao.base.GenericDAO;

public interface DummyDAO extends GenericDAO<DummyDTO, Long>{
	
	public List<DummyDTO> findDummies ();
}