package es.uem.aju.common.dto;

import java.util.List;

public class LocationListDTO extends BaseDTO{
	
	private static final long serialVersionUID = 8267117846105345346L;

	private List<LocationDTO> results;

	public LocationListDTO(List<LocationDTO> results) {
		super();
		this.results = results;
	}

	public List<LocationDTO> getResults() {
		return results;
	}
		
}
