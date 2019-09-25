package com.cognizant.movie.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.movie.dao.FavoritesDaoCollectionImpl;
import com.cognizant.movie.dao.FavoritesDaoSqlImpl;
import com.cognizant.movie.dao.FavoritesEmptyException;
import com.cognizant.movie.model.Movies;


/**
 * Servlet implementation class RemoveFavoritesServlet
 */
@WebServlet("/RemoveFavorites")
public class RemoveFavoritesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFavoritesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		long userId=1;
	    String movieId=request.getParameter("id");
	    long movieItemId=Long.parseLong(movieId);
	     FavoritesDaoSqlImpl ct=new FavoritesDaoSqlImpl();
	     ct.removeFavorites(userId, movieItemId);
	   
	  
	   try {
		   ArrayList<Movies> movieItemList=ct.getAllFavorites(userId);
		     double total=ct.total;
			 request.setAttribute("totalobj", total);
		   request.setAttribute("removeMovieItemStatus",true);
	       request.setAttribute("movieItemListobj", movieItemList);
	       RequestDispatcher rd=request.getRequestDispatcher("favorites.jsp");
	  
		rd.forward(request, response);
	   }catch(FavoritesEmptyException e){
		   RequestDispatcher rd=request.getRequestDispatcher("favorites-empty.jsp");
			rd.forward(request, response); 
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
