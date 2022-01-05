package modal;

public class Product {
    private int id;
    private String pname;
    private  double price;
    private int Aqun;
    
	public Product(int id, String pname, double price, int aqun) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
		Aqun = aqun;
	}

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAqun() {
		return Aqun;
	}

	public void setAqun(int aqun) {
		Aqun = aqun;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", pname=" + pname + ", price=" + price + ", Aqun=" + Aqun + "]";
	}
	
    
    
}
