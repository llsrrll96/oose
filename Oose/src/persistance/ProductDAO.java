package persistance;

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
	
	//등록, 수정, 삭제, 조회 / 사용자 조회 , 검색
	
}
