package com.dbExample.accessor;


import com.dbExample.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository //used to create bean out of classes which act as repository( as this class interacts with database)
public class MovieAccessor {
    @Autowired
    private DataSource dataSource;

    public List<Movie> getMovies(){
        List<Movie> listOfMovies=new ArrayList<>();
        try(Connection connection=dataSource.getConnection()){ // try with resources
            //String sql= "SELECT title from movie";
            String sql1= "SELECT title, budget, homepage from movie where budget > ?";
            PreparedStatement ps= connection.prepareStatement(sql1); //used for security purpose
            ps.setInt(1,100000); //we are setting value of questionMark here.
           ResultSet rs= ps.executeQuery(); //this method returns  result set (result set is connection of values)
            while(rs.next()){
                Movie movie=new Movie(rs.getString(1),rs.getInt(2),rs.getString(3));
               // movies.add(rs.getString(1)); //field from 1st index of resultset
                listOfMovies.add(movie);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        return listOfMovies;
        //return Arrays.asList("Dark night rises","Batman begins");

    }
}
