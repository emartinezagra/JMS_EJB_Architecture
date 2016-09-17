package es.uem.aju.common.dao.interfaces;

import java.util.Date;
import java.util.List;

import es.uem.aju.common.dao.base.GenericDAO;
import es.uem.aju.common.dto.ActivityDTO;


public interface ActivityDAO extends GenericDAO<ActivityDTO, Integer>{

	public List<ActivityDTO> findActivityByDate(Date date, long intervalMillis);
}