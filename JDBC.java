package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class studentmanagementsystem {
	 public static void add() {
			Scanner sc = new Scanner(System.in);
			Connection con = null;
			final String url ="jdbc:mysql://localhost:3306/stu?user=root&password=root";
		PreparedStatement pstmt  =null;	
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("driver loaded");
			con = DriverManager.getConnection(url);
			String q = "insert into hello(`sid`,`sname`,`sage`,`phone`) value(?,?,?,?)";	
			pstmt = con.prepareStatement(q);
			System.out.println("enter a id :");
			int id = sc.nextInt();
			System.out.println("enter a name");
			String name = sc.next();
			System.out.print("enter a age");
			int age =sc.nextInt();
			System.out.print("enter a phone");
			long phone = sc.nextLong();
			student student = new student(id,name,age,phone);
		    pstmt.setInt(1,id);
		    pstmt.setString(2,name);
		    pstmt.setInt(3, age);
		    pstmt.setLong(4, phone);
		    pstmt.execute();
		    System.out.print("done");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}	
	 }
	 public static void displayall() {
			String url ="jdbc:mysql://localhost:3306/stu?user=root&password=root";

			try
			{
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection(url);
	Statement stmt = con.createStatement();
	String q = "select * from hello";
	ResultSet res = stmt.executeQuery(q);
	while(res.next()) {
		System.out.println(res.getString("sid")+":"+res.getString("sage")+":"+res.getString("sname")+":"+res.getString("phone"));	
	}
	System.out.print("done");
			}
			catch (Exception e) {
				e.printStackTrace();
			}
	 }
	 public static void remove() {
		 Connection con = null;
		 final String url = "jdbc:mysql://localhost:3306/hello/user=root&password=root";
		 PreparedStatement pstmt = null;
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(null);
		pstmt = con.prepareStatement(url);
		
	} catch (ClassNotFoundException | SQLException e) {
		e.printStackTrace();
	}	 
	 }
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("=======================================");
		System.out.println("Welcome to student maanagement System");
		System.out.println("======================================="); 
		System.out.println("enter 1: to add data in data base");
		System.out.println("enter 2: to display all data in data base");
		 int key = sc.nextInt();
		switch (key) {
		case 1: {
			add();
			
			break;
		}
		case 2:{
			displayall();
			break;
		}
		case 3:{
			remove();
			break;
		}
		default:
			System.out.println("Unexpected value:pls enter the valid option" + key);
			break;
		}
	}
	 
}
