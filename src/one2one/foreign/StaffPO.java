package one2one.foreign;

import java.io.Serializable;

public class StaffPO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String name;
	private StaffType type;
	private HotelPO hotel;

	public StaffPO() {
		// TODO Auto-generated constructor stub
	}

	public StaffPO(String username, String password, String name, StaffType type, HotelPO hotel) {
		super();
		this.username = username;
		this.password = password;
		this.name = name;
		this.type = type;
		this.hotel = hotel;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StaffType getType() {
		return type;
	}

	public void setType(StaffType type) {
		this.type = type;
	}

	public HotelPO getHotel() {
		return hotel;
	}

	public void setHotel(HotelPO hotel) {
		this.hotel = hotel;
	}

}
