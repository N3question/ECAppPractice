package bean;

import java.io.Serializable;

public class CartBeans implements Serializable {
	private int itemId;
	private int userId;
	private int quantity;
	
	public CartBeans() {}
	public CartBeans(int itemId, int userId, int quantity) {
		this.itemId = itemId;
		this.userId = userId;
		this.quantity = quantity;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
