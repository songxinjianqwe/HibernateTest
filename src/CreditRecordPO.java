

import java.io.Serializable;

import util.type.CreditRecordType;

public class CreditRecordPO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private OrderPO order;
	private UserPO user;
	private CreditRecordType type;
	private int variation;
	private int currCredit;

	public CreditRecordPO() {
		// TODO Auto-generated constructor stub
	}
	
	public CreditRecordPO(int id, OrderPO order, UserPO user, CreditRecordType type, int variation, int currCredit) {
		super();
		this.id = id;
		this.order = order;
		this.user = user;
		this.type = type;
		this.variation = variation;
		this.currCredit = currCredit;
	}

	public CreditRecordPO(int id, UserPO user, CreditRecordType type, int variation, int currCredit) {
		super();
		this.id = id;
		this.user = user;
		this.type = type;
		this.variation = variation;
		this.currCredit = currCredit;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public OrderPO getOrder() {
		return order;
	}

	public void setOrder(OrderPO order) {
		this.order = order;
	}

	public UserPO getUser() {
		return user;
	}

	public void setUser(UserPO user) {
		this.user = user;
	}

	public CreditRecordType getType() {
		return type;
	}

	public void setType(CreditRecordType type) {
		this.type = type;
	}

	public int getVariation() {
		return variation;
	}

	public void setVariation(int variation) {
		this.variation = variation;
	}

	public int getCurrCredit() {
		return currCredit;
	}

	public void setCurrCredit(int currCredit) {
		this.currCredit = currCredit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currCredit;
		result = prime * result + id;
		result = prime * result + ((order == null) ? 0 : order.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + variation;
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
		CreditRecordPO other = (CreditRecordPO) obj;
		if (currCredit != other.currCredit)
			return false;
		if (id != other.id)
			return false;
		if (order == null) {
			if (other.order != null)
				return false;
		} else if (!order.equals(other.order))
			return false;
		if (type != other.type)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (variation != other.variation)
			return false;
		return true;
	}
	
	
}
