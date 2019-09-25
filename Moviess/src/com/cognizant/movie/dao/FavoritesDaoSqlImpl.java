package com.cognizant.movie.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cognizant.movie.model.Favorites;
import com.cognizant.movie.model.Movies;


public class FavoritesDaoSqlImpl implements FavoritesDao{
  public  long total=0;
	@Override
	public void addFavorites(long userId, long moviesId) {
		// TODO Auto-generated method stub
		try {
			Connection con=ConnectionHandler.getConnection();
			
				PreparedStatement stmt=con.prepareStatement("insert into favourites (ft_mo_id) values('"+moviesId+"')");
				stmt.executeUpdate();
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}  

		
	}

	@Override
	public ArrayList<Movies> getAllFavorites(long userId) throws FavoritesEmptyException {
		// TODO Auto-generated method stub
        Connection con=ConnectionHandler.getConnection();
       
		ArrayList<Movies> movieList=new ArrayList<Movies>();
		try {
		Movies movieItem=null;
		
		
			PreparedStatement stmt = con.prepareStatement("select * from movie_list inner join favourites on favourites.ft_mo_id=movie_list.mo_id");
			ResultSet rs=stmt.executeQuery(); 
			
			while(rs.next()){
				
				//MenuItem menuItem=new MenuItem(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4),rs.getInt(5));  

				String active=rs.getString(4);
				//System.out.println(active);
				boolean b=true;
				if(active.equals("Yes")){
					b=true;
					
				}
				if(active.equals("No")){
					b=false;
					
				}
				String teaser=rs.getString(7);
				//System.out.println(active);
				boolean t=true;
				if(teaser.equals("Yes")){
					t=true;
					
				}
				if(teaser.equals("No")){
					t=false;
					
				}
				BigInteger b1 = new BigInteger(rs.getString(3)); 
				total++;
				// price=rs.getFloat(3)+price;
				 //long noOfFavorites = userFavorites.get(userId).getMovieList().size();
				movieItem=new Movies((long)rs.getInt(1),rs.getString(2),b1,b,rs.getDate(5),rs.getString(6),t);
				//System.out.println(menuItem);
				//System.out.println(price);
				movieList.add(movieItem);
				
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Favorites c=new Favorites(movieList,total);
		return movieList;
	}

	@Override
	public void removeFavorites(long userId, long moviesId) {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		try {
			PreparedStatement stmt = con.prepareStatement("delete from favourites where ft_mo_id='"+moviesId+"' limit 1");
			stmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
