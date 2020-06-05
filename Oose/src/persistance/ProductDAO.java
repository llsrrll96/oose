package persistance;

import java.sql.*;
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
	public ArrayList<Product> searchProduct(String productName){ 
		ArrayList<Product> products = new ArrayList<Product>();
		try {//쿼리 수행 해서 값을 넘긴다.
		Connection conn = ds.getConnection(); //데이터 소스로 연결
		Statement st = conn.createStatement();
		String sql = "SELECT * FROM sogongdo.product WHERE Product_Name LIKE '%"+productName+"%';";
		ResultSet rs = st.executeQuery(sql);
		
			while (rs.next()) {
				String product_ID = rs.getString("Product_ID");
				String product_Name = rs.getString("Product_Name");
				String product_Kinds = rs.getString("Product_Kinds");
				int product_Price = rs.getInt("Product_Price");
				int product_Stock = rs.getInt("Product_Stock");
				
				Product pDTO = new Product(product_ID,product_Name,product_Kinds,product_Price,product_Stock);
				products.add(pDTO);
			}
			  if(rs != null) try { rs.close(); } catch(SQLException sqle) {}
	            if(st != null) try { st.close(); } catch(SQLException sqle) {}
	            if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	
	
	//상품 조회
	public ArrayList<Product> displayProduct(){ 
		ArrayList<Product> products = new ArrayList<Product>();
		
		try {//쿼리 수행 해서 값을 넘긴다.
		Connection conn = ds.getConnection(); //데이터 소스로 연결
		Statement st = conn.createStatement();
		String sql = "SELECT * FROM sogongdo.product;";
		ResultSet rs = st.executeQuery(sql);
		
		
			while (rs.next()) {
				String product_ID = rs.getString("Product_ID");
				String product_Name = rs.getString("Product_Name");
				String product_Kinds = rs.getString("Product_Kinds");
				int product_Price = rs.getInt("Product_Price");
				int product_Stock = rs.getInt("Product_Stock");
				
				Product pDTO = new Product(product_ID,product_Name,product_Kinds,product_Price,product_Stock);
				products.add(pDTO);
			}
			if(rs != null) try { rs.close(); } catch(SQLException sqle) {}
            if(st != null) try { st.close(); } catch(SQLException sqle) {}
            if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return products;
	}
	
	//등록
	public void enrollProduct(String name, String kinds, int price, int stock) {
		 String product_Name = name;
		 String product_Kinds = kinds;
		 int product_Price = price;
		 int product_Stock = stock;
		 int rowCount = 0;
		try {//쿼리 수행 해서 값을 넘긴다.
			Connection conn = ds.getConnection(); //데이터 소스로 연결
			String sql = "INSERT INTO `sogongdo`.`product`(`Product_Name`,`Product_Kinds`,`Product_Price`,`Product_Stock`)\r\n" 
					+ "VALUES (?, ?, ?, ?)";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, product_Name);
			pstmt.setString(2, product_Kinds);
			pstmt.setInt(3, product_Price);
			pstmt.setInt(4, product_Stock);
			rowCount = pstmt.executeUpdate();
		
		
        if(pstmt != null) try { pstmt.close(); } catch(SQLException sqle) {}
        if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//수정
	public void updateProduct(String id, String name, String kinds, int price, int stock) {
		 String product_ID = id;
		 String product_Name = name;
		 String product_Kinds = kinds;
		 int product_Price = price;
		 int product_Stock = stock;
		
		try {//쿼리 수행 해서 값을 넘긴다.
			Connection conn = ds.getConnection(); //데이터 소스로 연결
			String sql = "UPDATE `sogongdo`.`product` SET `Product_Name` = ?,`Product_Kinds` = ?,`Product_Price` = ?,`Product_Stock` = ?\r\n" + 
					"WHERE `Product_ID` = ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, product_Name);
			pstmt.setString(2, product_Kinds);
			pstmt.setInt(3, product_Price);
			pstmt.setInt(4, product_Stock);
			pstmt.setString(5, product_ID);
			int rowCount = pstmt.executeUpdate();
		
        if(pstmt != null) try { pstmt.close(); } catch(SQLException sqle) {}
        if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//삭제
	public void deleteProduct(String id) {
		try {//쿼리 수행 해서 값을 넘긴다.
			Connection conn = ds.getConnection(); //데이터 소스로 연결
			String sql = "DELETE FROM `sogongdo`.`product` WHERE Product_ID = ?";
			PreparedStatement pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, id);
			int rowCount = pstmt.executeUpdate();
		
		
        if(pstmt != null) try { pstmt.close(); } catch(SQLException sqle) {}
        if(conn != null) try { conn.close(); } catch(SQLException sqle) {}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
