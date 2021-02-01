package com.semanticsquare.thrillio.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


import com.semanticsquare.thrillio.DataStore;
import com.semanticsquare.thrillio.constants.Gender;
import com.semanticsquare.thrillio.constants.UserType;
import com.semanticsquare.thrillio.entities.User;
import com.semanticsquare.thrillio.managers.UserManager;

import java.util.*;

public class UserDao {
   
	/* public User[] getUsers(){
		 return DataStore.getUsers();
	 }*/
	
		public List<User> getUsers() {
			return DataStore.getUsers();
		}

		public User getUser(long userId) {
			// TODO Auto-generated method stub
			User user=null;
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false", "root", "root");
					Statement stmt = conn.createStatement();) {	
				String query = "Select * from User where id = " + userId +" ";
				ResultSet rs = stmt.executeQuery(query);
				System.out.println("query01 sucessful");
				while (rs.next()) {
					System.out.println("query1 sucessful");
					long id = rs.getLong("id");
					String email = rs.getString("email");
					String password = rs.getString("password");
					String firstName = rs.getString("first_name");
					String lastName = rs.getString("last_name");
					int gender_id = rs.getInt("gender_id");
					Gender gender = Gender.values()[gender_id];
					int user_type_id = rs.getInt("user_type_id");
					UserType userType = UserType.values()[user_type_id];
					
					user = UserManager.getInstance().createUser(id, email, password, firstName, lastName, gender, userType);
		    	}			
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
			return user;
		}

		public long authenticate(String email, String encodePassword) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jid_thrillio?useSSL=false", "root", "root");
					Statement stmt = conn.createStatement();) {	
				//encodePassword="a94a8fe5ccb19ba61c4c0873d391e987982fbbd3";
				String query = "Select id from User where email = '" + email + "' and password = '" + encodePassword + "'";
				//System.out.println("hgjhgfu");
				System.out.println("query: " + query);
				ResultSet rs = stmt.executeQuery(query);
				
				while (rs.next()) {
					System.out.println(rs.getLong("id"));
					return rs.getLong("id");				
		    	}	
				//System.out.println("hgjhgfu");
			} catch (SQLException e) {
				e.printStackTrace();
			}	
			
			return -1;
		}
	
}
