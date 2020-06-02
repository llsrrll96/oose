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
		Connection conn = conn = ds.getConnection(); //데이터 소스로 연결
		Statement st = st = conn.createStatement();
		String sql = "SELECT * FROM 객소모델.product WHERE Product_Name LIKE '%"+productName+"%';";
		ResultSet rs = rs = st.executeQuery(sql);
		
		
			
			
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
		Connection conn = conn = ds.getConnection(); //데이터 소스로 연결
		Statement st = conn.createStatement();
		String sql = "SELECT * FROM 객소모델.product;";
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
	
	//수정
	
	//삭제
	public void deleteProduct(String id) {
		try {//쿼리 수행 해서 값을 넘긴다.
			Connection conn = conn = ds.getConnection(); //데이터 소스로 연결
			String sql = "DELETE FROM `객소모델`.`product` WHERE Product_ID = ?";
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
