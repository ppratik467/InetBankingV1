package com.inetbanking.utilities;

import org.testng.TestListenerAdapter;

public class Reporting extends TestListenerAdapter {
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;

	public void onstart(ITestContext testContext)
	{
		String timeStamp = new SimpleDataFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
	String repName="Test-Report-"+timeStamp+".html";
	htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);//specify location
	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extent-config.xml");
	
	extent=new ExtentReports();
	
	extent.attachReporter(htmlReporter);
	extent.setSystemInfo("Host name","localhost");
	extent.setSystemInfo("Environment","QA");
	extent.setSystemInfo("user","pavan");
	
	htmlReporter.config().setDocumentTitle("InetBankng Test Project");
	htmlReporter.config().setReportName("Functional Test Report");
	htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
	htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult tr)
}logger=extent.createTest(tr.getName());logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN));

}

public void onTestFailure(ITestResult tr)
{
	logger=extent.createTest(tr.getName());
	logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED));
	
	String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+tr.getName()+".png";
	
	File f = new File(screenshotPath);
	
	if(f.exist())
	{
		try {
			logger.fail("Screenshot is below:"+logger.addScreenCaptureFromPath(screenshotPath));
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		}
	public void onTestSkipped(ITestResult tr)
	{
		logger=extent.createTest(tr.getName());
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	public void onFinish(ITestContext testContext)
	}
       extent.flush();
       }
}
