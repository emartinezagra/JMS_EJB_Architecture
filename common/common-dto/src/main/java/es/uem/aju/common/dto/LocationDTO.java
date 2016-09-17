package es.uem.aju.common.dto;

public class LocationDTO extends BaseDTO {

	private static final long serialVersionUID = -4963938507145833569L;

	private int id;
	private String name;
	private int coordinateX;
	private int coordinateY;
	private int locationId;

	public LocationDTO(int id, String name, int coordinateX, int coordinateY, int locationId) {
		super();
		this.id = id;
		this.name = name;
		this.coordinateX = coordinateX;
		this.coordinateY = coordinateY;
		this.locationId = locationId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getCoordinateX() {
		return coordinateX;
	}

	public int getCoordinateY() {
		return coordinateY;
	}

	public int getLocationId() {
		return locationId;
	}

}
