package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import persistance.ProductDAO;

@WebServlet("/enrollProduct")
public class EnrollProductController  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGP(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGP(req, resp);
	}

	private void doGP(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");   
		resp.setContentType("text/html;charset=utf-8"); 
        
        String name=req.getParameter("Product_Name");
        String kinds=req.getParameter("Product_Kinds");
        int price=Integer.parseInt(req.getParameter("Product_Price"));
        int stock=Integer.parseInt(req.getParameter("Product_Stock"));
        
        //형식 괜찮으면 
        
        
        
        
        
        
        
        
        
        	ProductDAO productDAO = new ProductDAO();
        	productDAO.enrollProduct(name, kinds, price, stock);
        
        
        	RequestDispatcher dispatcher = req.getRequestDispatcher("/EnrollProductView.jsp");
        	dispatcher.forward(req, resp);
        
		
		//안괜찮으면 다시
		
		
		
	}
}
