package util.type;

public enum WebsiteDiscountType {
	SpecialPeriod,SpecialCommercialCircle,VIP;
	public static WebsiteDiscountType getWebsiteDiscountType(String type){
		switch(type){
		case "SpecialPeriod":
			return SpecialPeriod;
		case "SpecialCommercialCircle":
			return SpecialCommercialCircle;
		case "VIP":
			return VIP;
		default:
			return null;
		}
	}
}
