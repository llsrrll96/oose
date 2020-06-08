package persistance;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductSellDAO {
	private DataSource ds;

	public ProductSellDAO() {
		try {
			Context context = new InitialContext();  //데이터 소스 초기화
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");// jdbc/MySQL 리소스 이름
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//보여주는 함수
	public ArrayList<ProductSell> displayProductSell() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM sogongdo.product_sell;";
		ArrayList<ProductSell> productSells = new ArrayList<ProductSell>();
		
		try {
			conn = ds.getConnection(); //데이터 소스로 연결
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {//쿼리 수행 해서 값을 넘긴다.
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String sell_ID = rs.getString("Sell_ID");
				String product_ID =rs.getString("Product_ID");
				int quantity = rs.getInt("Quantity");
				int price = rs.getInt("Price");
				LocalDateTime sell_Date = rs.getTimestamp("Sell_Date").toLocalDateTime();
				String seller = rs.getString("Seller");

				ProductSell psDTO = new ProductSell(sell_ID, product_ID, quantity,price,sell_Date,seller);
				productSells.add(psDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productSells;
	}
	
}

/*
모듈 설계자 : 박성용

검토자 : 박성용, 김인환
검토 날짜: 2020-06-05

*/
