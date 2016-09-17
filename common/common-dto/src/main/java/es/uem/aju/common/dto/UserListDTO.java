package es.uem.aju.common.dto;

import java.util.List;

public class UserListDTO extends BaseDTO {
	
	private static final long serialVersionUID = -6970155793987815481L;
	
	private List<UserDTO> results;

	public UserListDTO(List<UserDTO> results) {
		super();
		this.results = results;
	}

	public List<UserDTO> getResults() {
		return results;
	}
}
