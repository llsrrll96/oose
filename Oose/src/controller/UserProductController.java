package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.*;

@WebServlet("/product")
public class UserProductController extends HttpServlet{
	private ProductDAO productDAO = new ProductDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ArrayList<Product> productList;
		productList = productDAO.displayProduct();
		
		req.setAttribute("productList", productList); //jsp 페이지로 넘기기
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/ManagerProductView.jsp");
		dispatcher.forward(req, resp);
		
//		dispatcher.include(req, resp); //계속 이용 푸터 헤더, 요청 jsp로 돌아온다.
//		dispatcher = req.getRequestDispatcher("/footer.jsp");
//		dispatcher.include(req, resp);
		
		
	}

}
