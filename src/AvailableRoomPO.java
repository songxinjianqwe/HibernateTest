

import java.io.Serializable;
import java.util.Date;

import util.type.RoomType;

public class AvailableRoomPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HotelPO hotel;
	private RoomType type;
	private int availableRoomNum;
	private Date roomDate;
	
	public HotelPO getHotel() {
		return hotel;
	}
	public void setHotel(HotelPO hotel) {
		this.hotel = hotel;
	}
	public RoomType getType() {
		return type;
	}
	public void setType(RoomType type) {
		this.type = type;
	}
	public int getAvailableRoomNum() {
		return availableRoomNum;
	}
	public void setAvailableRoomNum(int availableRoomNum) {
		this.availableRoomNum = availableRoomNum;
	}
	public Date getRoomDate() {
		return roomDate;
	}
	public void setRoomDate(Date roomDate) {
		this.roomDate = roomDate;
	}
	
	
}
