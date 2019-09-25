package com.cognizant.movie.dao;

import java.util.ArrayList;

import com.cognizant.movie.model.Movies;


public interface MovieDao {


	ArrayList<Movies> getMoviesListAdmin();
	ArrayList<Movies> getMoviesListCustomer();
	void modifyMovies(Movies movies);
	Movies getMovies(long moviesId);
	
}
