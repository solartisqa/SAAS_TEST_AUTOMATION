package com.selenium.DriverPackage;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class controllerScript
{
	public static void addExceptionReport(Connection conn,Statement stmt,String tablename,String testdata,String errormessage) throws SQLException
	{
		String sql1 = "INSERT INTO "+ tablename+"(Testdata,ErrorMessage)"+" VALUES('"+testdata+"','"+errormessage+"')";
		System.out.println(sql1);
		PreparedStatement insertStatement =(PreparedStatement) conn.prepareStatement(sql1);
		insertStatement.executeUpdate();
	}
}
