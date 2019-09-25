package com.cognizant.movie.servlet;

import java.io.IOException;

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


@WebServlet("/ShowEditMovieItem")
public class ShowEditMovieItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ShowEditMovieItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		MovieItemDaoSqlImpl movieItemDao;
		try {
			movieItemDao = new MovieItemDaoSqlImpl();
			String id=request.getParameter("id");
			long movieItemId=Long.parseLong(id);
			Movies movieItem=movieItemDao.getMovies(movieItemId);
			request.setAttribute("movieItemobj", movieItem);
			RequestDispatcher rd=request.getRequestDispatcher("edit-movie.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
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
