package one2one.primary;
import java.io.Serializable;

public class HotelPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int star;
	private double score;
	private LocationPO location;
	private CommercialCirclePO commercialCircle;
	private String profile;
	private String service;
	private StaffPO staff;
	private String street;

	public HotelPO() {
		// TODO Auto-generated constructor stub
	}

	public HotelPO(String name, int star, double score, LocationPO location, CommercialCirclePO commercialCircle,
			String profile, String service) {
		super();
		this.name = name;
		this.star = star;
		this.score = score;
		this.location = location;
		this.commercialCircle = commercialCircle;
		this.profile = profile;
		this.service = service;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStar() {
		return star;
	}

	public void setStar(int star) {
		this.star = star;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public LocationPO getLocation() {
		return location;
	}

	public void setLocation(LocationPO location) {
		this.location = location;
	}

	public CommercialCirclePO getCommercialCircle() {
		return commercialCircle;
	}

	public void setCommercialCircle(CommercialCirclePO commercialCircle) {
		this.commercialCircle = commercialCircle;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public StaffPO getStaff() {
		return staff;
	}

	public void setStaff(StaffPO staff) {
		this.staff = staff;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

}
