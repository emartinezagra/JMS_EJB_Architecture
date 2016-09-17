package es.uem.aju.rp.business;

import es.uem.aju.common.dto.EquipmentDTO;
import es.uem.aju.common.dto.EquipmentListDTO;

public interface EquipmentServiceRemote {
	
	public EquipmentDTO find(Integer pk);
	
	public EquipmentListDTO findAll();
}
