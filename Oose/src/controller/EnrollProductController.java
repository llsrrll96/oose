package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.Product;
import persistance.ProductDAO;

@WebServlet("/enrollProduct")
public class EnrollProductController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestEnrollProduct(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestEnrollProduct(req, resp);
	}

	private void requestEnrollProduct(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
        
		Product products = new Product();
		products.setProduct_Name(req.getParameter("Product_Name"));
		products.setProduct_Kinds(req.getParameter("Product_Kinds"));
		products.setProduct_Price(Integer.parseInt(req.getParameter("Product_Price")));
		products.setProduct_Stock(Integer.parseInt(req.getParameter("Product_Stock")));
		     
        ProductDAO productDAO = new ProductDAO();
        String checkEnroll = Integer.toString(productDAO.enrollProduct(products));
        req.setAttribute("checkEnroll", checkEnroll); //jsp 페이지로 값 넘기기
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/EnrollProductView.jsp");
        dispatcher.forward(req, resp);

	}
}

/*
모듈 설계자 : 박성용

검토자 : 박성용, 김인환
검토 날짜: 2020-06-05

수정 일자 : 2020-06-08
수정 내용 : productDAO.enrollProduct(products) 의 반환값 설정, req.setAttribute("checkEnroll", checkEnroll);
*/
