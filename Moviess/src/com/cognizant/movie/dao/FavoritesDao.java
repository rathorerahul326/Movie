package com.cognizant.movie.dao;

import java.util.ArrayList;

import com.cognizant.movie.model.Movies;


public interface FavoritesDao {

	void addFavorites(long userId, long moviesId);
	ArrayList<Movies> getAllFavorites(long userId) throws FavoritesEmptyException;
	void removeFavorites(long userId, long moviesId);
}
