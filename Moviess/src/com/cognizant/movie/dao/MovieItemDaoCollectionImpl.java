package com.cognizant.movie.dao;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;

import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;


public class MovieItemDaoCollectionImpl implements MovieDao {

	private static ArrayList<Movies> movieList;
	public MovieItemDaoCollectionImpl() {
		if(movieList ==null)
		{
			movieList = new ArrayList<Movies>();
			movieList.add(new Movies(1, "Avatar", new BigInteger("2787965087"),  true, DateUtil.convertToDate("15/03/2017"),"Science Fiction", true ));
			movieList.add(new Movies(2, "The Avengers", new BigInteger("1518812988"),  true, DateUtil.convertToDate("23/12/2017"),"Superhero",  false));
			movieList.add(new Movies(3, "Titanic",  new BigInteger("2187463944"),  true,  DateUtil.convertToDate("21/08/2018"), "Romance",  false));
			movieList.add(new Movies(4, "Jurassic World", new BigInteger("1671713208"),  false,  DateUtil.convertToDate("02/07/2017"), "Science Fiction",  true));
			movieList.add(new Movies(5, "Avengers: End Game", new BigInteger("2750760348"), true, DateUtil.convertToDate("02/11/2022"),"Superhero",  true));
		}
	}
	
	
	
	@Override
	public  ArrayList<Movies> getMoviesListAdmin() {
		// TODO Auto-generated method stub
		return movieList;
	}

	@Override
	public ArrayList<Movies> getMoviesListCustomer() {
		// TODO Auto-generated method stub
		ArrayList<Movies> customerList = new ArrayList<Movies>();
		Date day = new Date();
		for(Movies movies : movieList) {
			Date listDate = movies.getDateOfLaunch();
			if( day.compareTo(listDate) >= 0 && movies.isActive())
			{
				customerList.add(movies);
			}
		}
		return customerList;
	}

	@Override
	public void modifyMovies(Movies movies) {
		// TODO Auto-generated method stub
		for(Movies m: movieList) {
			
			
			if(m.equals(movies))
			{
				
				m.setTitle(movies.getTitle());;
				m.setGenre(movies.getGenre());
				m.setActive(movies.isActive());
				m.setDateOfLaunch(movies.getDateOfLaunch());
				m.setTeaser(movies.isTeaser());
				m.setBoxOffice(movies.getBoxOffice());
				System.out.println(m);
			
				
				
			}
		}
		
		
	}

	@Override
	public Movies getMovies(long moviesId) {
		// TODO Auto-generated method stub
		for(Movies movies: movieList)
		{
			if(movies.getId()==moviesId)
			{
				return movies;
			}	
		}
		return null;
	}
	
	
	
	
}
