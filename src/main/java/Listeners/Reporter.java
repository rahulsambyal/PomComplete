package Listeners;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.management.RuntimeErrorException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.relevantcodes.extentreports.ExtentTest;


public class Reporter implements ITestListener {
	
	private static ThreadLocal<ExtentTest> suiteR= new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> testR= new ThreadLocal<>();
	private static ThreadLocal<ExtentTest> currentTest= new ThreadLocal<>();
	private static Map<String,ExtentTest> testMap= new ConcurrentHashMap<>();
	private static  Map<String,ExtentTest> methodMap= new ConcurrentHashMap<>();
	
	private static final String reportName="My Report Name";

	public static ThreadLocal<ExtentTest> getCurrentTest(){
		return currentTest;
	}
	
	private static class ExtentManager{
		
		private static ExtentReports report;
		private static ExtentHtmlReporter htmlReport;
		private static ExtentHtmlReporter htmlLogConverter;
		
		private ExtentManager() {
			
		}
		
		public synchronized static ExtentHtmlReporter getHtmlReporter() {
			if(null== report)
				throw new RuntimeException("Extent reports not initialized yet");
			return htmlReport;
		}
		
		/*
		 * public synchronized static ExtentReports getReporter() { if(null== report)
		 * report = new ExtentReports(); String reportPath=
		 * System.getProperty("base.path")+"\\ExtentReport.html"; File reportFile= new
		 * File(reportPath); if(!reportFile.exists()) { File dirOfFile =
		 * reportFile.getParentFile(); dirOfFile.mkdir(); try {
		 * reportFile.createNewFile(); }catch(IOException e) { e.printStackTrace(); } }
		 * htmlReport= new ExtentHtmlReporter(reportFile);
		 * htmlReport.config().setTheme(Theme.STANDARD); //
		 * htmlReport.config().setChartVisibityOnOpen(true);
		 * 
		 * return htmlReport; }
		 */
		
	}
	

}
