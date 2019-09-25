package com.cognizant.movie.servlet;

import java.io.IOException;
import java.math.BigInteger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.MovieDao;
import com.cognizant.movie.dao.MovieItemDaoCollectionImpl;
import com.cognizant.movie.dao.MovieItemDaoSqlImpl;
import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;



@WebServlet("/EditMovieItem")
public class EditMovieItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		try {
			MovieItemDaoSqlImpl menuItemobj=new MovieItemDaoSqlImpl();
			String name=request.getParameter("fname");
			String price=request.getParameter("fprice");
			String active=request.getParameter("inStock");
			String date=request.getParameter("date");
			String category=request.getParameter("category");
			String freeDelievery=request.getParameter("java");
            String id=request.getParameter("id");
            long menuItemId=Long.parseLong(id);
			float fprice=Float.parseFloat(price);
			BigInteger a=new BigInteger(price);
			System.out.println("freeDelivery "+freeDelievery);
			boolean bactive=false;
			if(active.equals("stockPresent")) {
				bactive=true;
			}
			else{
				bactive=false;
			}
			boolean bfreeDelievery=false;
			if(freeDelievery!=null) {
			 bfreeDelievery=true;
			}
			else{
				 bfreeDelievery=false;
			}
			/*System.out.println("name "+name);
			System.out.println("price "+price);
			System.out.println("a "+a);
			System.out.println("bactive "+bactive);
			System.out.println("date "+DateUtil.convertToDate(date));
			System.out.println("category "+category);
			System.out.println("bfreeDelievery "+bfreeDelievery);*/
			
			
			
			Movies mfreeDelievery=new Movies(menuItemId,name,a,bactive, DateUtil.convertToDate(date),category,bfreeDelievery);
		    menuItemobj.editMovieItem(mfreeDelievery);
		    RequestDispatcher rd=request.getRequestDispatcher("edit-movie-status.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
