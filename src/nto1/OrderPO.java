package nto1;

import java.io.Serializable;
import java.util.Date;

public class OrderPO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private Date placeTime;
	private Date execTime;
	private Date checkinTime;
	private Date expectedCheckoutTime;
	private Date checkoutTime;
	private Date revokeTime;
	private OrderStatus status;
	private int hotelID;
	private double value;
	private RoomType type;
	private int num;
	private boolean hasChild;
	private UserPO user;
	private int score;
	private String evaluation;

	public OrderPO() {
		// TODO Auto-generated constructor stub
	}


	public OrderPO(int id, Date placeTime, Date execTime, Date checkinTime, Date expectedCheckoutTime,
			Date checkoutTime, Date revokeTime, OrderStatus status, int hotelID, double value, RoomType type, int num,
			boolean hasChild, UserPO user, int score, String evaluation) {
		super();
		this.id = id;
		this.placeTime = placeTime;
		this.execTime = execTime;
		this.checkinTime = checkinTime;
		this.expectedCheckoutTime = expectedCheckoutTime;
		this.checkoutTime = checkoutTime;
		this.revokeTime = revokeTime;
		this.status = status;
		this.hotelID = hotelID;
		this.value = value;
		this.type = type;
		this.num = num;
		this.hasChild = hasChild;
		this.user = user;
		this.score = score;
		this.evaluation = evaluation;
	}

	public OrderPO(Date placeTime, Date execTime, Date expectedCheckoutTime
			, OrderStatus status, int hotelID, double value, RoomType type, int num,
			 UserPO user) {
		super();
		this.placeTime = placeTime;
		this.execTime = execTime;
		this.expectedCheckoutTime = expectedCheckoutTime;
		this.status = status;
		this.hotelID = hotelID;
		this.value = value;
		this.type = type;
		this.num = num;
		this.user = user;
	}
	public UserPO getUser() {
		return user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getHotelID() {
		return hotelID;
	}

	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}

	public Date getPlaceTime() {
		return placeTime;
	}

	public void setPlaceTime(Date placeTime) {
		this.placeTime = placeTime;
	}

	public Date getExecTime() {
		return execTime;
	}

	public void setExecTime(Date execTime) {
		this.execTime = execTime;
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

	public Date getRevokeTime() {
		return revokeTime;
	}

	public void setRevokeTime(Date revokeTime) {
		this.revokeTime = revokeTime;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
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

	public boolean isHasChild() {
		return hasChild;
	}

	public void setHasChild(boolean hasChild) {
		this.hasChild = hasChild;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

}
