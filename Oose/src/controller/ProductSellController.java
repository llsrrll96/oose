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

//판매 실적 집계
@WebServlet("/productSell")
public class ProductSellController extends HttpServlet{
	private ProductSellDAO productSellDAO = new ProductSellDAO();
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestDisplayProductSell(req, resp);
	}
	
	protected void requestDisplayProductSell(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException 
	{
		ArrayList<ProductSell> productSellList;
		productSellList = productSellDAO.displayProductSell();
		
		req.setAttribute("productSellList", productSellList); //jsp 페이지로 넘기기
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/ProductSellView.jsp");
		dispatcher.forward(req, resp);
		
//		dispatcher.include(req, resp); //계속 이용 푸터 헤더, 요청 jsp로 돌아온다.
//		dispatcher = req.getRequestDispatcher("/footer.jsp");
//		dispatcher.include(req, resp);
	}

}

/*
모듈 설계자 : 박성용

검토자 : 박성용, 김인환
검토 날짜: 2020-06-05

*/
