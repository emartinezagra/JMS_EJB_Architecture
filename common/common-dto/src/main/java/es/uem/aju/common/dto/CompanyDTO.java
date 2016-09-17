package es.uem.aju.common.dto;

public class CompanyDTO extends BaseDTO {

	private static final long serialVersionUID = 8475363337986697006L;

	private int id;
	private String name;
	private int locationId;

	public CompanyDTO(int id, String name, int locationId) {
		this.id = id;
		this.name = name;
		this.locationId = locationId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getLocationId() {
		return locationId;
	}

}
