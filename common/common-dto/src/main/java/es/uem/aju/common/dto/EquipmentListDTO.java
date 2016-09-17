package es.uem.aju.common.dto;

import java.util.List;

public class EquipmentListDTO extends BaseDTO{
		
	private static final long serialVersionUID = 1964293248691814150L;
	
	private List<EquipmentDTO> results;

	public EquipmentListDTO(List<EquipmentDTO> results) {
		super();
		this.results = results;
	}

	public List<EquipmentDTO> getResults() {
		return results;
	}
		
}
