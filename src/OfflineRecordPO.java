

import java.io.Serializable;
import java.util.Date;

import util.type.RoomType;

public class OfflineRecordPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private HotelPO hotel;
	private Date checkinTime;
	private Date expectedCheckoutTime;
	private Date checkoutTime;
	private RoomType type;
	private int num;
	public OfflineRecordPO() {
		// TODO Auto-generated constructor stub
	}
	
	public OfflineRecordPO(int id, HotelPO hotel, Date checkinTime, Date expectedCheckoutTime, Date checkoutTime,
			RoomType type, int num) {
		super();
		this.id = id;
		this.hotel = hotel;
		this.checkinTime = checkinTime;
		this.expectedCheckoutTime = expectedCheckoutTime;
		this.checkoutTime = checkoutTime;
		this.type = type;
		this.num = num;
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
	public Date getCheckinTime() {
		return checkinTime;
	}
	public void setCheckinTime(Date checkinTime) {
		this.checkinTime = checkinTime;
	}
	public Date getExpectedCheckoutTime() {
		return expectedCheckoutTime;
	}
	public void setExpectedCheckoutTime(Date expectedCheckoutTime) {
		this.expectedCheckoutTime = expectedCheckoutTime;
	}
	public Date getCheckoutTime() {
		return checkoutTime;
	}
	public void setCheckoutTime(Date checkoutTime) {
		this.checkoutTime = checkoutTime;
	}
	public RoomType getType() {
		return type;
	}
	public void setType(RoomType type) {
		this.type = type;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((checkinTime == null) ? 0 : checkinTime.hashCode());
		result = prime * result + ((checkoutTime == null) ? 0 : checkoutTime.hashCode());
		result = prime * result + ((expectedCheckoutTime == null) ? 0 : expectedCheckoutTime.hashCode());
		result = prime * result + ((hotel == null) ? 0 : hotel.hashCode());
		result = prime * result + id;
		result = prime * result + num;
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
		OfflineRecordPO other = (OfflineRecordPO) obj;
		if (checkinTime == null) {
			if (other.checkinTime != null)
				return false;
		} else if (!checkinTime.equals(other.checkinTime))
			return false;
		if (checkoutTime == null) {
			if (other.checkoutTime != null)
				return false;
		} else if (!checkoutTime.equals(other.checkoutTime))
			return false;
		if (expectedCheckoutTime == null) {
			if (other.expectedCheckoutTime != null)
				return false;
		} else if (!expectedCheckoutTime.equals(other.expectedCheckoutTime))
			return false;
		if (hotel == null) {
			if (other.hotel != null)
				return false;
		} else if (!hotel.equals(other.hotel))
			return false;
		if (id != other.id)
			return false;
		if (num != other.num)
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
}
