package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationPage extends BasePage {

	JavascriptExecutor executor;

	public RegisterationPage(WebDriver driver) {

		super(driver);

		this.executor = (JavascriptExecutor) this.driver;
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement fname;
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lname;
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement mail;
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement pwd;

	@FindBy(xpath = "//input[@id='input-newsletter-yes']")
	WebElement newsletter;

	@FindBy(xpath = "//input[@name='agree']")

	WebElement chkdPolicy;

	@FindBy(xpath = "//button[normalize-space()='Continue']")
	WebElement continuebtn;

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement confirmation;

	public void setFirstname(String fnname) {

		fname.sendKeys(fnname);
	}

	public void setLastname(String laeme) {

		lname.sendKeys(laeme);
	}

	public void setemail(String email) {

		mail.sendKeys(email);
	}

	public void setpwd(String pswd) {

		pwd.sendKeys(pswd);
	}

	public void nwsltr() {

		newsletter.click();
	}

	public void acceptcondn() {

		executor.executeScript("arguments[0].click();", chkdPolicy);
	}

	public void contnue() {

		executor.executeScript("arguments[0].click();", continuebtn);

	}

	public String getConfirmationMsg() {
		try {
			return (confirmation.getText());
		} catch (Exception e) {
			return (e.getMessage());

		}

	}
}