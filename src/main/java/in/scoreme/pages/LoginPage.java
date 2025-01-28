package in.scoreme.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import in.scoreme.constants.AppConstants;
import in.scoreme.utils.ElementUtil;
import in.scoreme.utils.TimeUtil;

import io.qameta.allure.Step;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	//1. private By locators
	private By emailId = By.xpath("//input[@formcontrolname='email']");
	private By password = By.id("password");
	
	private By loginBtn = By.xpath("//button[@class='_btn _btn-primary w-100 mb-3']");
	
	private By forgotPwdLink = By.xpath("//button[text()='Forgot Password?']");
	private By registerLink = By.linkText("Register");
	// *** top container contains all the toggle****//

	private By currencyToggle = By.xpath("//nav[@id='top']//form[1]");
	private By listInline = By.xpath("//*[@id='top-links']/ul");
	private By search = By.id("search");
	private By cart = By.id("cart");
	private By pageLogo = By.id("logo");
	

	//2. public page class constructor
	public LoginPage(WebDriver driver) {
	System.out.println("hello");
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	//3. public page actions/method
	@Step("Getting the page logo")
	public boolean isPageLogoDisplayed() {
		return eleUtil.isElementDisplayed(pageLogo);
	}

	@Step("Getting that currency toggle")
	public boolean isCurrencyToggleExist() {

		return eleUtil.isElementDisplayed(currencyToggle);
	}

	@Step("Getting inline list")
	public boolean isContainerToggleExist() {

		return eleUtil.isElementDisplayed(listInline);

	}

	@Step("Getting Search field")
	public boolean isSearchFieldExist() {
		return eleUtil.isElementDisplayed(search);

	}

	@Step("Getting cart")
	public boolean isCartExist() {

		return eleUtil.isElementDisplayed(cart);
	}

	// 3. Public page actions/method
	@Step("getting login page title")
	public String getLoginPageTitle() {

		String title = eleUtil.waitForTitleIs(AppConstants.LOGIN_PAGE_TITLE, TimeUtil.DEFAULT_MEDIUM_TIME);
		System.out.println("Login page title : " + title);
		return title;

	}

	@Step("Getting the login page URL")
	public String getLoginPageURL() {
		String url = eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL_FRACTION, TimeUtil.DEFAULT_MEDIUM_TIME);
		System.out.println("login page url : " + url);
		return url;
	}

	@Step("Getting the forgot password link")
	public boolean isForgotPwdLinkExist() {

		return eleUtil.isElementDisplayed(forgotPwdLink);
	}

	@Step("login with username: {0} and password: {1}")
	public AccountsPage doLogin(String username, String pwd) {

		//String captchaValue = CaptchaSolver();
		
		eleUtil.waitForElementVisible(emailId, TimeUtil.DEFAULT_LONG_TIME).sendKeys(username);
		eleUtil.doSendKeys(password, pwd);
		
		eleUtil.doClick(loginBtn);
		return new AccountsPage(driver);

	}
	

	@Step("Navigate to the register page")
	public RegisterationPage navigateToRegisterPage() {

		eleUtil.waitForElementVisible(registerLink, TimeUtil.DEFAULT_LONG_TIME).click();
		// It will return the object of the registration page

		return new RegisterationPage(driver);

	}

}
