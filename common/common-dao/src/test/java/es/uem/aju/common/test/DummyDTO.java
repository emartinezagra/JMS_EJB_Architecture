package es.uem.aju.common.test;

import es.uem.aju.common.dto.BaseDTO;

public class DummyDTO extends BaseDTO {

	private String name;
	
	public DummyDTO(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}		
}
