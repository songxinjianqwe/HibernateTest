package one2one.foreign;

public enum StaffType {
	HotelStaff, WebsiteAdminister, WebsiteMarketer;
	public static StaffType getStaffType(String type) {
		switch (type) {
		case "HotelStaff":
			return HotelStaff;
		case "WebsiteAdminister":
			return WebsiteAdminister;
		case "WebsiteMarketer":
			return WebsiteMarketer;
		default:
			return null;
		}
	}
}
