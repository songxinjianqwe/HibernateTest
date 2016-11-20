

import java.io.Serializable;
import java.util.Date;

import util.type.HotelDiscountType;

public  class HotelDiscountPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private HotelPO hotel;
	private double discount;
	private HotelDiscountType type;
	private EnterprisePO enterprise;//合作企业
	private int minQty;//满几间房有优�?
	private Date beginTime;//特定期间优惠
	private Date endTime;
	public HotelDiscountPO() {
		// TODO Auto-generated constructor stub
	}
	

	public HotelDiscountPO(int id, HotelPO hotel, double discount, HotelDiscountType type, EnterprisePO enterprise,
			int minQty, Date beginTime, Date endTime) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.discount = discount;
		this.type = type;
		this.enterprise = enterprise;
		this.minQty = minQty;
		this.beginTime = beginTime;
		this.endTime = endTime;
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public HotelPO getHotel() {
		return hotel;
	}
	public void setHotel(HotelPO hotel) {
		this.hotel = hotel;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public HotelDiscountType getType() {
		return type;
	}
	public void setType(HotelDiscountType type) {
		this.type = type;
	}
	
	public int getMinQty() {
		return minQty;
	}
	public void setMinQty(int minQty) {
		this.minQty = minQty;
	}
	public Date getBeginTime() {
		return beginTime;
	}
	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public EnterprisePO getEnterprise() {
		return enterprise;
	}

	public void setEnterprise(EnterprisePO enterprise) {
		this.enterprise = enterprise;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((beginTime == null) ? 0 : beginTime.hashCode());
		long temp;
		temp = Double.doubleToLongBits(discount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((endTime == null) ? 0 : endTime.hashCode());
		result = prime * result + ((enterprise == null) ? 0 : enterprise.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + id;
		result = prime * result + minQty;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HotelDiscountPO other = (HotelDiscountPO) obj;
		if (beginTime == null) {
			if (other.beginTime != null)
				return false;
		} else if (!beginTime.equals(other.beginTime))
			return false;
		if (Double.doubleToLongBits(discount) != Double.doubleToLongBits(other.discount))
			return false;
		if (endTime == null) {
			if (other.endTime != null)
				return false;
		} else if (!endTime.equals(other.endTime))
			return false;
		if (enterprise == null) {
			if (other.enterprise != null)
				return false;
		} else if (!enterprise.equals(other.enterprise))
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (id != other.id)
			return false;
		if (minQty != other.minQty)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	
		
}
