package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ProductDAO {
	private DataSource ds;

	public ProductDAO() {
		try {
			Context context = new InitialContext();  //데이터 소스 초기화
			ds = (DataSource) context.lookup("java:comp/env/jdbc/MySQL");// jdbc/MySQL 리소스 이름
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//상품 검색
	public ArrayList<ProductDTO> searchProduct(String productName){ 
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM 객소모델.product WHERE Product_Name LIKE '%"+productName+"%';";
		ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
		
		try {
			conn = ds.getConnection(); //데이터 소스로 연결
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {//쿼리 수행 해서 값을 넘긴다.
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String product_ID = rs.getString("Product_ID");
				String product_Name = rs.getString("Product_Name");
				String product_Kinds = rs.getString("Product_Kinds");
				int product_Price = rs.getInt("Product_Price");
				int product_Stock = rs.getInt("Product_Stock");
				
				ProductDTO pDTO = new ProductDTO(product_ID,product_Name,product_Kinds,product_Price,product_Stock);
				products.add(pDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	
	
	//상품 조회
	public ArrayList<ProductDTO> displayProduct(){ 
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM 객소모델.product;";
		ArrayList<ProductDTO> products = new ArrayList<ProductDTO>();
		
		try {
			conn = ds.getConnection(); //데이터 소스로 연결
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {//쿼리 수행 해서 값을 넘긴다.
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String product_ID = rs.getString("Product_ID");
				String product_Name = rs.getString("Product_Name");
				String product_Kinds = rs.getString("Product_Kinds");
				int product_Price = rs.getInt("Product_Price");
				int product_Stock = rs.getInt("Product_Stock");
				
				ProductDTO pDTO = new ProductDTO(product_ID,product_Name,product_Kinds,product_Price,product_Stock);
				products.add(pDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	//등록
	
	//수정
	
	//삭제
	
	
}
