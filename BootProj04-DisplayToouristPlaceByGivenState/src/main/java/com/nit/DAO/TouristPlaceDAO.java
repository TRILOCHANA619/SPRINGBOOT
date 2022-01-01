package com.nit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nit.model.TouristPlace;

@Repository("touristPlaceService")
public class TouristPlaceDAO implements ITouristPlace {

	@Autowired
	private DataSource ds;

	private static final String SELEC_QUERY_TOURIST_PLACE ="SELECT PLACE_NAME,PLACE,STATE FROM TOURIST_PLACE_INDIA WHERE STATE IN (?,?,?)";
	@Override
	public List<TouristPlace> getTouristPlace(String state1, String state2, String state3) throws Exception {
		//creating the list object
		List<TouristPlace> touristPlaceList=new ArrayList<TouristPlace>();

		//get connection object
		try(Connection con=ds.getConnection();
				PreparedStatement ps=con.prepareStatement(SELEC_QUERY_TOURIST_PLACE)) {

			//SET THE PARAMETER
			ps.setString(1, state1);
			ps.setString(2, state2);
			ps.setString(3, state3);

			//get resultset object
			try(ResultSet rs=ps.executeQuery()){

				if(rs!=null) {
					while(rs.next()) {
						//create touristPlace class object
						TouristPlace  touristPlace=new TouristPlace();

						touristPlace.setTouristPlace(rs.getString(1));
						touristPlace.setPlace(rs.getString(2));
						touristPlace.setState(rs.getString(3));

						//adding the touristPlace objct to list
						touristPlaceList.add(touristPlace);
					}//while
				}//if
			}//try1
		}//try2
		catch (SQLException se) {
			se.printStackTrace();
			throw se;
		}//catch
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}//catch

		return touristPlaceList;
	}//getToutris plaace

}//class
