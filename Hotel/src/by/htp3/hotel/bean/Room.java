package by.htp3.hotel.bean;

public class Room {
	private String number;
	private String kind;
	private String isValid;
	private String type;
	private String price_a_day;

	public Room() {
	}

	public Room(String number, String price_a_day, String type, String kind, String isValid) {
		this.number = number;
		this.type = type;
		this.kind = kind;
		this.price_a_day = price_a_day;
		this.isValid = isValid;
	}

	public Room(String price_a_day, String type, String kind) {

		this.type = type;
		this.kind = kind;
		this.price_a_day = price_a_day;

	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPrice_a_day() {
		return price_a_day;
	}

	public void setPrice_a_day(String price_a_day) {
		this.price_a_day = price_a_day;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

}
