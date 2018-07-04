package com.selenium.DriverPackage;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class controllerScript {
	public static void addExceptionReport(Connection conn, Statement stmt, String tablename, String testdata,
			String errormessage) throws SQLException {
		String sql1 = "INSERT INTO " + tablename + "(Testdata,ErrorMessage)" + " VALUES('" + testdata + "','"
				+ errormessage + "')";
		System.out.println(sql1);
		PreparedStatement insertStatement = (PreparedStatement) conn.prepareStatement(sql1);
		insertStatement.executeUpdate();
	}

	public static void takeScreenShot(WebDriver driver, String filePath, String testdata) {
		try {
			System.out.println("***Placed screen shot in " + filePath + " ***");
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filePath + testdata + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
			// driver.close();
		} catch (IOException e) {
			System.out.println("Exception in taking Screenshots");
			e.printStackTrace();
		}
	}
}
