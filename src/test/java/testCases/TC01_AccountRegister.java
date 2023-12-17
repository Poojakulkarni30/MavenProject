package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegisterationPage;
import testBase.BaseClass;

public class TC01_AccountRegister extends BaseClass {

	@Test
	public void testaccountregistration() {

		logger.info("Starting my first test case ");
		
		HomePage hp = new HomePage(driver);
		
		logger.info("clicking on myaccount link");
		
		hp.clickMyAccount();
		
		logger.info("clicking on registration link");
		
		hp.clickRegister();
		
		
		
		
		RegisterationPage rp = new RegisterationPage(driver);
		/*
		 * rp.setFirstname("Pooja"); rp.setLastname("Kulkarni");
		 * rp.setemail("abc@123.in"); rp.setpwd("123456"); rp.acceptcondn();
		 * rp.contnue();
		 */
		logger.info("Providing customer data");

		rp.setFirstname(randomeString().toLowerCase());
		rp.setLastname(randomeString().toLowerCase());
		rp.setemail(randomeString() + "@gmail.com");
		rp.setpwd(randomAlphaNumeric());
		rp.acceptcondn();
		rp.nwsltr();
		rp.contnue();
		String confmmsg= rp.getConfirmationMsg();
		try {
		Assert.assertEquals(confmmsg, "Your Account Has Been Created!");
		}
		catch (Exception e) {
			e.getMessage();
			Assert.fail();
		}
		logger.info("***  Finished TC_001_AccountRegistrationTest ***");		

	}
}
