package es.uem.aju.common.dto;

import java.util.List;

public class CompanyListDTO extends BaseDTO{

	private static final long serialVersionUID = -5079714949097758956L;
	
	private List<CompanyDTO> results;

	public CompanyListDTO(List<CompanyDTO> results) {
		super();
		this.results = results;
	}

	public List<CompanyDTO> getResults() {
		return results;
	}

}
