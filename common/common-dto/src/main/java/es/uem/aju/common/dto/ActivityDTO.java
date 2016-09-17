package es.uem.aju.common.dto;

import java.sql.Timestamp;

public class ActivityDTO extends BaseDTO {

	private static final long serialVersionUID = -3314658174116776954L;

	private int id;
	private int user;
	private int equipment;
	private Timestamp date;
	private boolean entering;

	public ActivityDTO(int id, int user, int equipment, Timestamp date, boolean entering) {
		super();
		this.id = id;
		this.user = user;
		this.equipment = equipment;
		this.date = date;
		this.entering = entering;
	}

	public int getId() {
		return id;
	}

	public int getUser() {
		return user;
	}

	public int getEquipment() {
		return equipment;
	}

	public Timestamp getDate() {
		return date;
	}

	public boolean isEntering() {
		return entering;
	}
}
