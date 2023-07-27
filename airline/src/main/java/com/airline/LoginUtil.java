package com.airline;

import java.io.IOException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.airline.entities.Manager;

public class LoginUtil {
	private static final SecureRandom secureRandom = new SecureRandom();
	private static final Base64.Encoder base64Encoder = Base64.getUrlEncoder();

	public static Manager validateUsernamePassword(String username, String password) {
		if (DbManager.getInstance().connection != null) {
			try {
				Statement statement = DbManager.getInstance().connection.createStatement();
				String sql = "select * from manager where username='" + username + "' and password='" + password + "'";
				System.out.println(sql);
				ResultSet resultSet = statement.executeQuery(sql);
				if (resultSet != null && resultSet.next()) {
					int id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					String email = resultSet.getString(3);
					String phone = resultSet.getString(4);
					System.out.println("Manager username password validated - " + name + ", " + email + ", " + phone);
					
					return new Manager(id, name, email, phone, username, password);
				} else {
					System.out.println("Manager data not found in database - " + username + ", " + password);
				}
			} catch (SQLException e) {
				System.err.println("Failed to get username and password data from database.");
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String createAuthToken(Manager manager) {
		String authToken = generateRandomString();

		if (DbManager.getInstance().connection != null) {
			try {
				Statement statement = DbManager.getInstance().connection.createStatement();
				String sql = "update manager set auth_token='" + authToken + "' where username='" + manager.username + "'";
				System.out.println(sql);
				statement.execute(sql);
				return authToken;
			} catch (SQLException e) {
				System.err.println("Failed to insert auth token in to database.");
				e.printStackTrace();
			}
		}
		return null;
	}

	public static Manager validateUserAuthentication(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Cookie authTokenCookie = LoginUtil.findAuthTokenCookie(request);
		// Not authenticated?
		if (authTokenCookie == null) {
			System.out.println("User is not authenticated.");
			System.out.println("Redirecting to Login page...");
			response.sendRedirect("login");
			return null;
		}

		String authToken = authTokenCookie.getValue();
		Manager user = LoginUtil.validateAuthToken(authToken);
		// Invalid auth token?
		if (user == null) {
			System.out.println("Invalid authentication token.");
			System.out.println("Redirecting to Login page...");
			response.sendRedirect("login");
			return null;
		}

		return user;
	}

	public static Cookie findAuthTokenCookie(HttpServletRequest request) {
		Cookie authTokenCookie = null;

		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {
			String cookieName = cookie.getName();
			String cookieValue = cookie.getValue();
			System.out.println("Cookie - " + cookieName + " : " + cookieValue);

			// Authentication token cookie?
			if (cookieName.equals("auth-token")) {
				authTokenCookie = cookie;
			}
		}
		
		return authTokenCookie;
	}

	private static Manager validateAuthToken(String authToken) {
		if (DbManager.getInstance().connection != null) {
			try {
				Statement statement = DbManager.getInstance().connection.createStatement();
				String sql = "select * from manager where auth_token='" + authToken + "'";
				System.out.println(sql);
				ResultSet resultSet = statement.executeQuery(sql);
				if (resultSet != null && resultSet.next()) {
					int id = resultSet.getInt(1);
					String name = resultSet.getString(2);
					String email = resultSet.getString(3);
					String phone = resultSet.getString(4);
					String username = resultSet.getString(5);
					String password = resultSet.getString(6);
					System.out.println("Manager auth token validated - " + name + ", " + email + ", " + phone);
					
					return new Manager(id, name, email, phone, username, password);
				} else {
					System.out.println("Manager data not found in database for auth token - " + authToken);
				}
			} catch (SQLException e) {
				System.err.println("Failed to get auth token data from database.");
				e.printStackTrace();
			}
		}
		return null;
	}

	private static String generateRandomString() {
		// Reference : https://stackoverflow.com/a/56628391
		byte[] randomBytes = new byte[8];
	    secureRandom.nextBytes(randomBytes);
	    return base64Encoder.encodeToString(randomBytes);
	}
}
