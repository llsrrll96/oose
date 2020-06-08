package persistance;

public class Product {
	private String product_ID;
	private String product_Name;
	private String product_Kinds;
	private int product_Price;
	private int product_Stock;
	
	public Product() {}
	
	public Product(String product_ID, String product_Name, String product_Kinds, int product_Price,
			int product_Stock) {
		super();
		this.product_ID = product_ID;
		this.product_Name = product_Name;
		this.product_Kinds = product_Kinds;
		this.product_Price = product_Price;
		this.product_Stock = product_Stock;
	}

	public String getProduct_ID() {
		return product_ID;
	}

	public void setProduct_ID(String product_ID) {
		this.product_ID = product_ID;
	}

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public String getProduct_Kinds() {
		return product_Kinds;
	}

	public void setProduct_Kinds(String product_Kinds) {
		this.product_Kinds = product_Kinds;
	}

	public int getProduct_Price() {
		return product_Price;
	}

	public void setProduct_Price(int product_Price) {
		this.product_Price = product_Price;
	}

	public int getProduct_Stock() {
		return product_Stock;
	}

	public void setProduct_Stock(int product_Stock) {
		this.product_Stock = product_Stock;
	}
}
/*
모듈 설계자 : 박성용

검토자 : 박성용, 김인환
검토 날짜: 2020-06-05

*/
