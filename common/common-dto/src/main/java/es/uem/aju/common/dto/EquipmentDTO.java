package es.uem.aju.common.dto;

public class EquipmentDTO extends BaseDTO {

	private static final long serialVersionUID = -8826189597846229208L;

	private int id;
	private int locationID;
	private String status;

	public EquipmentDTO(int id, int locationID, String status) {
		super();
		this.id = id;
		this.locationID = locationID;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public int getLocationID() {
		return locationID;
	}

	public String getStatus() {
		return status;
	}

}
