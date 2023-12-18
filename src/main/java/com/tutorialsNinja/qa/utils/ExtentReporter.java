package com.tutorialsNinja.qa.utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;
public class ExtentReporter {
	
	public static ExtentReports generateExtendReport()
	{
		ExtentReports extentReports=new ExtentReports();
		File extentReportFile=new File(System.getProperty("user.dir")+ "\\test-output\\ExtentReports\\ExtentReports.html");
		ExtentSparkReporter sparkReporter=new ExtentSparkReporter(extentReportFile);
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("TutorialsNinja Test Automation Results");
		sparkReporter.config().setDocumentTitle("TN Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/YYYY  hh:mm:ss");
		
		extentReports.attachReporter(sparkReporter);
		
		Properties configProp=new Properties();
		File configPropFile=new File(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\tutorialsNinja\\qa\\config\\config.properties");
		FileInputStream fisConfigProp;
		try {
			fisConfigProp = new FileInputStream(configPropFile);
			configProp.load(fisConfigProp);
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		extentReports.setSystemInfo("Application URL", configProp.getProperty("url"));
		extentReports.setSystemInfo("Browser Name", configProp.getProperty("browserName"));
		extentReports.setSystemInfo("Email", configProp.getProperty("validEmail"));
		extentReports.setSystemInfo("Paaword", configProp.getProperty("validPassword"));
		extentReports.setSystemInfo("Operating System", System.getProperty("os.name"));
		extentReports.setSystemInfo("UserName", System.getProperty("user.name"));
		extentReports.setSystemInfo("JAVA Version", System.getProperty("java.version"));
		
		return extentReports;
	}

}
