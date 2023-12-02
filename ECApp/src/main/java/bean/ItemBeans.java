package bean;

// TODO 今の所汎用DAOの処理の中ではBeansのsetterは使用していない
public class ItemBeans {
	private int itemId;
	private String itemName;
	private int price;
	private String fileName;
	private int categoryId;
	private String categoryName;
	private boolean salesStatus;
	
	public ItemBeans(){}
	public ItemBeans(int itemId, String itemName, int price, String fileName, int categoryId, String categoryName, boolean salesStatus) {
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.fileName = fileName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.salesStatus = salesStatus;
	}
	
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public boolean isSalesStatus() {
		return salesStatus;
	}
	public void setSalesStatus(boolean salesStatus) {
		this.salesStatus = salesStatus;
	}
}
