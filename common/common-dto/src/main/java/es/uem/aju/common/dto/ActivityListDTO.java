package es.uem.aju.common.dto;

import java.util.List;

public class ActivityListDTO extends BaseDTO {
	
	private static final long serialVersionUID = 3194595732630215510L;
	
	private List<ActivityDTO> results;

	public ActivityListDTO(List<ActivityDTO> results) {
		super();
		this.results = results;
	}

	public List<ActivityDTO> getResults() {
		return results;
	}
}
