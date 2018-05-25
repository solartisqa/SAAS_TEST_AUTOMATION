package com.selenium.SupportingClasses;


import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.LinkedHashMap;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSetMetaData;
import com.mysql.jdbc.Statement;
import com.selenium.exception.DatabaseException;

public class Comparedbtables 
{
	public static Boolean flag=true;
	 public static  void Comparedb(String jdbcdriver,String dburl,String user,String password,String tablename1,String tablename2) throws DatabaseException
		{
		  Connection conn=null;
		   ResultSet rs1 = null;
		   ResultSet rs2 = null;
		   ResultSetMetaData meta1 = null;
		   ResultSetMetaData meta2 = null;
		   Statement stmt1 =null;
		   Statement stmt2 =null;
		   int rs_row = 1;
		   try
		   {
		  Class.forName("com.mysql.jdbc.Driver");
		  conn = (Connection) DriverManager.getConnection("jdbc:mysql://192.168.84.225:3700/TestDB_Starr","root","redhat");
		   }
		   catch(Exception e)
		   {
			   System.out.println("Error in connection settings");
		   }
			
			try 
			{
				stmt1 = (Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			    rs1 =    stmt1.executeQuery("SELECT * FROM "+tablename1);
		        meta1 = (ResultSetMetaData) rs1.getMetaData();    
		        stmt2 = (Statement) conn.createStatement(ResultSet.TYPE_FORWARD_ONLY,ResultSet.CONCUR_UPDATABLE);
			    rs2 =    stmt2.executeQuery("SELECT * FROM "+tablename2);
		        meta2 = (ResultSetMetaData) rs2.getMetaData();  
		       
		        while (rs1.next()&&rs2.next())
		        {
		        	
		            for (int columnIterator = 1; columnIterator <= meta1.getColumnCount(); columnIterator++) 
		            {
		                String key1 = meta1.getColumnName(columnIterator);
		                String value1 = rs1.getString(key1);
		                String key2 = meta2.getColumnName(columnIterator);
		                String value2 = rs2.getString(key2);
		               // System.out.println(value1+"-------"+value2);
		               if(value1.equals(value2))
		               {
		            	  
		            	  System.out.println("No diffenece");
		               }
		               else
		               {
		            	System.out.println("Diffence in Column---"+key1+"values are ---"+value1+"<>"+value2);
		       			String sql1 = "INSERT INTO difference"+ "(si_no,Columnname,value1,value2)"+" VALUES('"+rs_row+"','"+key1+"','"+value1+"','"+value2+"')";
		       			System.out.println(sql1);
		       			PreparedStatement insertStatement =(PreparedStatement) conn.prepareStatement(sql1);
		       		
		       			insertStatement.executeUpdate();
		               }
		            }
		        
		           rs_row++;
		        } 
		        
			} 
			catch (Exception e) 
			{
				throw new DatabaseException("PROBLEM WITH RESULT-SET OBTAINED FROM DB",e);
			}
			
		}
	 
	 
	 public static void main(String args[]) throws DatabaseException
	 {
		 Comparedbtables.Comparedb("com.mysql.jdbc.Driver","jdbc:mysql://192.168.84.225:3700/TestDB_Starr","root","redhat", "ParallelTest", "ParallelTest1");
	 }
}
