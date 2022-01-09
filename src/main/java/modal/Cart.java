package modal;



public class Cart {
	

	private int productId;
	private String productName;
	private int userId;
	private int qty;

	
	
	
	public Cart() {
		super();
	}
	public Cart( int productId,String productName, int userId, int qty) {
		super();
		
		this.productId = productId;
		this.productName = productName;
		this.userId = userId;
		this.qty = qty;
		
	}
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	
	

}
