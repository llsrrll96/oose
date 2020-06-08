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

@WebServlet("/updateProduct")
public class UpdateProductController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		requestUpdateProduct(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		requestUpdateProduct(req, resp);
	}

	private void requestUpdateProduct(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
        
		String id=req.getParameter("Product_ID");
        String name=req.getParameter("Product_Name");
        String kinds=req.getParameter("Product_Kinds");
        int price=Integer.parseInt(req.getParameter("Product_Price"));
        int stock=Integer.parseInt(req.getParameter("Product_Stock"));
        Product products = new Product(id,name,kinds,price,stock);
        
        ProductDAO productDAO = new ProductDAO();
        String updateCheck = Integer.toString(productDAO.updateProduct(products));
        req.setAttribute("updateCheck", updateCheck); //jsp 페이지로 넘기기
        
        RequestDispatcher dispatcher = req.getRequestDispatcher("/UpdateProductView.jsp");
        dispatcher.forward(req, resp);
	}
}
/*
모듈 설계자 : 박성용

검토자 : 박성용, 김인환
검토 날짜: 2020-06-05

수정 일자 : 2020-06-08
수정 내용 : updateProduct의 반환 값 설정

*/