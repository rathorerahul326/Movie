package com.cognizant.movie.dao;

import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.cognizant.movie.model.Movies;
import com.cognizant.movie.util.DateUtil;


public class MovieItemDaoSqlImpl implements MovieDao {

	@Override
	public ArrayList<Movies> getMoviesListAdmin() {
		// TODO Auto-generated method stub
	ArrayList<Movies> movieList=null;
		
		try {
		Connection con=ConnectionHandler.getConnection();
		
		
		movieList=new ArrayList<Movies>();
		PreparedStatement stmt=con.prepareStatement("select * from movie_list");  
		
		ResultSet rs = stmt.executeQuery();  
		
		
		while(rs.next()){
		String active=rs.getString(4);
	
		boolean b=true;
		if(active.equals("Yes")){
			b=true;
			
		}
		if(active.equals("No")){
			b=false;
			}
		String teaser=rs.getString(7);
		
		boolean t=true;
		if(teaser.equals("Yes")){
			t=true;
			
		}
		if(teaser.equals("No")){
			t=false;
			}

		BigInteger b1 = new BigInteger(rs.getString(3)); 
		
		Movies movieItem=new Movies((long)rs.getInt(1),rs.getString(2),b1,b,rs.getDate(5),rs.getString(6),t);
		System.out.println(movieItem);
		movieList.add(movieItem);
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return movieList;
		
	}

	@Override
	public ArrayList<Movies> getMoviesListCustomer() {
		// TODO Auto-generated method stub
		ArrayList<Movies> movieList = null;
		//System.out.println("dsjk");
		try {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		Date todayy = Calendar.getInstance().getTime();
		String today = simpleDateFormat.format(date);
		Date Today = DateUtil.convertToDate(today);
		
		Connection con=ConnectionHandler.getConnection();
		movieList=new ArrayList<Movies>();
		PreparedStatement stmt=con.prepareStatement("select * from movie_list where mo_active='Yes' and DATE(`mo_date_of_launch`) <= CURDATE()");  
		ResultSet rs=stmt.executeQuery();  
		while(rs.next()){
			long id;
			String title;
			String active;
			Date dateOfLaunch;
			String genre;
			String teaser;
            id=(long)rs.getInt(1);
            title=rs.getString(2);
        	BigInteger  boxOffice = new BigInteger(rs.getString(3));
           
              active=rs.getString(4);
            boolean b=true;
    		if(active.equals("YES")){
    			b=true;
    			
    		}
    		if(active.equals("NO")){
    			b=false;
    			
    		}
            dateOfLaunch=rs.getDate(5);
            genre=rs.getString(6);
            teaser=rs.getString(7);
            boolean t=true;
    		if(teaser.equals("YES")){
    			t=true;
    			
    		}
    		if(teaser.equals("NO")){
    			t=false;
    			
    		}
          
		Movies movieItem=new Movies(id,title,boxOffice,b,dateOfLaunch,genre,t); 
		System.out.println(movieItem);
		movieList.add(movieItem);
		} 
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return movieList;
	}

	@Override
	public void modifyMovies(Movies movies) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Movies getMovies(long moviesId) {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		Movies movieItem=null;
		try {
		long movieItemIdd=moviesId;
		PreparedStatement stmt;
		
			stmt = con.prepareStatement("select * from movie_list where mo_id='"+movieItemIdd+"'");
		
		ResultSet rs=stmt.executeQuery(); 
		while(rs.next()){
			String active=rs.getString(4);
			boolean b=true;
			if(active.equals("Yes")){
				b=true;
				
			}
			if(active.equals("No")){
				b=false;
				
			}
			String teaser=rs.getString(7);
			boolean t=true;
			if(teaser.equals("Yes")){
				t=true;
				
			}
			if(teaser.equals("No")){
				t=false;
				
			}
			BigInteger  boxOffice = new BigInteger(rs.getString(3));
			movieItem=new Movies((long)rs.getInt(1),rs.getString(2),boxOffice,b,rs.getDate(5),rs.getString(6),t);
			System.out.println(movieItem);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		return movieItem;
	}
	public void editMovieItem(Movies movieItem) throws SQLException {
		// TODO Auto-generated method stub
		Connection con=ConnectionHandler.getConnection();
		 boolean active=movieItem.isActive();
		 boolean teaser=movieItem.isTeaser();
		 String sactive;
		 String steaser;
 		if(active){
 			sactive="Yes";
 			
 		}
 		else{
 			sactive="No";
 		}
 		if(teaser){
 			steaser="Yes";
 			
 		}
 		else{
 			steaser="No";
 		}
 		
		try {
			//datee = DateUtil.convertToDate(strDate);
			long id=movieItem.getId();
			PreparedStatement stmt = con.prepareStatement("update movie_list set mo_title='"+movieItem.getTitle()+"',mo_has_teaser='"+steaser+"',mo_box_office='"+movieItem.getBoxOffice()+"',mo_active='"+sactive+"',mo_date_of_launch='"+convertDateToSQLDate(movieItem.getDateOfLaunch())+"',mo_genre='"+movieItem.getGenre()+"' where mo_id='"+id+"'");
			
			  int row = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
     java.sql.Date convertDateToSQLDate (java.util.Date date) {
		
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
		
	}
}
