package com.cognizant.movie.model;

import java.util.ArrayList;


public class Favorites {

	private ArrayList<Movies> movieList; 
	private long noOfFavorites;

	public Favorites(ArrayList<Movies> movieList, long noOfFavorites) {
		if (this.movieList == null) this.movieList = new ArrayList<Movies>();
		this.movieList = movieList;
		this.noOfFavorites = noOfFavorites;
	}
	
	
	public ArrayList<Movies> getMovieList() {
		return movieList;
	}
	public void setMovieList(ArrayList<Movies> movieList) {
		this.movieList = movieList;
	}
	public long getNoOfFavorites() {
		return noOfFavorites;
	}
	public void setNoOfFavorites(long noOfFavorites) {
		this.noOfFavorites = noOfFavorites;
	}
	@Override
	public String toString() {
		return "Favorites [movieList=" + movieList + ", noOfFavorites=" + noOfFavorites + "]";
	}
	
	
	//equals()
	
	
}
