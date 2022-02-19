package com.inetbanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass {

	@Test
	public void loginTest() {

		logger.info("Url is Opened");

		LoginPage lp = new LoginPage(driver);

		lp.setUserName(username);
		logger.info("Entered Username");

		lp.setPassword(password);
		logger.info("Entered Password");

		lp.clickSubmit();
		System.out.println(";" + driver.getTitle() + ";");
            System.out.println(";" + driver.getTitle() + ";");
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
			System.out.println(true);

		} else {

			Assert.assertFalse(false);
			logger.info("Login Test Failed");
			System.out.println(false);
		}

	}

}
