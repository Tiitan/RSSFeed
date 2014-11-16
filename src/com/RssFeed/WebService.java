package com.RssFeed;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.RssFeed.Bean.Confirmation;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WebService 
{
	static String webServiceURL = " http://54.77.52.238:8080/RSSFeedWS/";
	
	public static Confirmation Login(String email, String password)
	{
		Confirmation confirmation = new Confirmation();
		
		try
		{
		    URL url = new URL(webServiceURL + "connection");
		    HttpURLConnection webServiceConnection = (HttpURLConnection) url.openConnection();
		    webServiceConnection.setRequestMethod("PUT");
		    webServiceConnection.setRequestProperty("email", email);
		    webServiceConnection.setRequestProperty("password", password);
		    webServiceConnection.connect();
		    
		    JsonParser jp = new JsonParser();
		    JsonElement root = jp.parse(new InputStreamReader((InputStream) webServiceConnection.getContent()));
		    JsonObject rootobj = root.getAsJsonObject();
		    
		    confirmation.setConfirmation(rootobj.get("confirmation").getAsBoolean());
		    confirmation.setMessage(rootobj.get("message").getAsString());
		}
		catch (Exception e)
		{
		    confirmation.setConfirmation(false);
		    confirmation.setMessage("Internal exception: " + e.getMessage());
		}
		
		return confirmation;
	}
	public static Confirmation Logout(String token)
	{
		Confirmation confirmation = new Confirmation();
		try
		{
		    URL url = new URL(webServiceURL + "connection");
		    HttpURLConnection webServiceConnection = (HttpURLConnection) url.openConnection();
		    webServiceConnection.setRequestMethod("DELETE");
		    webServiceConnection.setRequestProperty("token", token);
		    webServiceConnection.connect();
		    
		    JsonParser jp = new JsonParser();
		    JsonElement root = jp.parse(new InputStreamReader((InputStream) webServiceConnection.getContent()));
		    JsonObject rootobj = root.getAsJsonObject();
		    
		    confirmation.setConfirmation(rootobj.get("confirmation").getAsBoolean());
		    confirmation.setMessage(rootobj.get("message").getAsString());
		}
		catch (Exception e)
		{
		    confirmation.setConfirmation(false);
		    confirmation.setMessage("Internal exception: " + e.getMessage());
		}
		
		return confirmation;
	}
	public static Confirmation SignUp(String email, String password, String firstName, String lastName) 
	{
		Confirmation confirmation = new Confirmation();
		try
		{
		    URL url = new URL(webServiceURL + "account");
		    HttpURLConnection webServiceConnection = (HttpURLConnection) url.openConnection();
		    webServiceConnection.setRequestMethod("PUT");
		    webServiceConnection.setRequestProperty("email", email);
		    webServiceConnection.setRequestProperty("password", password);
		    webServiceConnection.setRequestProperty("firstName", firstName);
		    webServiceConnection.setRequestProperty("lastName", lastName);
		    webServiceConnection.connect();
		    
		    JsonParser jp = new JsonParser();
		    JsonElement root = jp.parse(new InputStreamReader((InputStream) webServiceConnection.getContent()));
		    JsonObject rootobj = root.getAsJsonObject();
		    
		    confirmation.setConfirmation(rootobj.get("confirmation").getAsBoolean());
		    confirmation.setMessage(rootobj.get("message").getAsString());
		}
		catch (Exception e)
		{
		    confirmation.setConfirmation(false);
		    confirmation.setMessage("Internal exception: " + e.getMessage());
		}
		
		return confirmation;
	}
}
