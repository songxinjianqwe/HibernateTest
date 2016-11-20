package util.type;

public enum HotelDiscountType {
	Birthday, LargeQty, Enterprise, SpecialPeriod;
	public static HotelDiscountType getHotelDiscountType(String type) {
		switch (type) {
		case "Birthday":
			return Birthday;
		case "LargeQty":
			return LargeQty;
		case "Enterprise":
			return Enterprise;
		case "SpecialPeriod":
			return SpecialPeriod;
		default:
			return null;
		}
	}
}
