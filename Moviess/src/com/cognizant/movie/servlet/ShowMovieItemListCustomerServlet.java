package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.ArrayList;

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

@WebServlet("/ShowMovieItemListCustomer")
public class ShowMovieItemListCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ShowMovieItemListCustomerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		MovieItemDaoSqlImpl movieItemDao;
	    try {
	    	
	    	movieItemDao = new MovieItemDaoSqlImpl();
			ArrayList<Movies> movieItemList=movieItemDao.getMoviesListCustomer();
			request.setAttribute("movieItemListobj", movieItemList);
			RequestDispatcher rd=request.getRequestDispatcher("movie-list-customer.jsp");
			rd.forward(request, response);
		  }catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
