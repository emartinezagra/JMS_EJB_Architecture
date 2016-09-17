package es.uem.aju.common.dto;

public class UserDTO extends BaseDTO {

	private static final long serialVersionUID = -4405066142186922525L;

	private int id;
	private String name;
	private String email;
	private String phone;
	private int companyId;

	public UserDTO(int id, String name, String email, String phone, int companyId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.companyId = companyId;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public int getCompanyId() {
		return companyId;
	}

}
