package com.adeel.charts.rest;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.adeel.carfever.model.Guy;

@Path("/hello")
public class HelloWorld {
	
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@GET
	@Path("/j")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg() throws FileNotFoundException {
		@SuppressWarnings("resource")
		String content = new Scanner(new File("D:/Port_to_Java_rajmarni/skype/adeel.json")).useDelimiter("\\Z").next();
		return Response.ok()
	            .entity(content)
//	            .header("Access-Control-Allow-Origin","*")
//	            .header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
	            .build();
	}
	
	@POST
	@Path("/j")
	@Consumes(MediaType.APPLICATION_JSON)
	@HeaderParam("Access-Control-Allow-Origin")
	public Response saveUser(Guy guy) throws FileNotFoundException, ClassNotFoundException, SQLException {
		String result = "{\"success\":\"ok\"}";
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/carfever", "root", "root")) {
			Statement stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO guy(firstName, lastName, username, password, email) VALUES('"+
			guy.getFirstName()+"', '"+guy.getLastName()+"', '"+guy.getUsername()
			+"', md5('"+guy.getPassword()+"'), '" + guy.getEmail() + "')");
			
//			stmt.executeUpdate("INSERT INTO car(");
		}
		return Response.status(201).entity(result).build();
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@HeaderParam("Access-Control-Allow-Origin")
	public Response loginUser(Guy guy) throws FileNotFoundException, ClassNotFoundException, SQLException {
		String result;
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/carfever", "root", "root")) {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM guy g WHERE g.username = '" + guy.getUsername() 
					+ "' AND g.password = md5('" + guy.getPassword() + "')");
			result = ((rs.next()) ? "{\"success\":\"ok\"}" : "{\"success\":\"failed\"}");
		}
		return Response.status(201).entity(result).build();
	}
	
}
