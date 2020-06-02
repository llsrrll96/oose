package persistance;

import java.time.LocalDateTime;

public class ProductSell {
	private String sell_ID;
	private String product_ID;
	private int quantity;
	private int price;
	private LocalDateTime sell_Date;
	private String seller;
	
	public ProductSell() {}
	
	public ProductSell(String sell_ID, String product_ID, int quantity, int price, LocalDateTime sell_Date,
			String seller) {
		this.sell_ID = sell_ID;
		this.product_ID = product_ID;
		this.quantity = quantity;
		this.price = price;
		this.sell_Date = sell_Date;
		this.seller = seller;
	}

	public String getSell_ID() {
		return sell_ID;
	}

	public void setSell_ID(String sell_ID) {
		this.sell_ID = sell_ID;
	}

	public String getProduct_ID() {
		return product_ID;
	}

	public void setProduct_ID(String product_ID) {
		this.product_ID = product_ID;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public LocalDateTime getSell_Date() {
		return sell_Date;
	}

	public void setSell_Date(LocalDateTime sell_Date) {
		this.sell_Date = sell_Date;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	};
	
}
