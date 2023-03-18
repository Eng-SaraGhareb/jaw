package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Locale;
import java.util.Objects;

public class HomePage extends PageBase {
	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "name-لايت")
	public WebElement lightlbl;

	@FindBy(id= "name-الأساسية")
	public WebElement standardlbl;

	@FindBy(id= "name-بريميوم")
	public WebElement premiumlbl;

	@FindBy(xpath= "//*[@id=\"currency-لايت\"]/i")
	public WebElement lightOnecurrency;

	@FindBy(xpath= "//b[normalize-space()='15']")
	public WebElement lightOneprice;

	@FindBy(xpath = "//b[normalize-space()='25']")
	public WebElement standardOneprice;

	@FindBy(xpath = "//b[normalize-space()='60']")
	public WebElement premiumOneprice;

	@FindBy(xpath = "//b[normalize-space()='1.2']")
	public WebElement lightSecondprice;

	@FindBy(xpath = "//b[normalize-space()='2.5']")
	public WebElement standardSecondprice;

	@FindBy(xpath = "//b[normalize-space()='4.8']")
	public WebElement premiumSecondprice;

	@FindBy(xpath = "//b[normalize-space()='2']")
	public WebElement lightThirdprice;

	@FindBy(xpath = "//b[normalize-space()='3']")
	public WebElement standardThirdprice;

	@FindBy(xpath = "//b[normalize-space()='6']")
	public WebElement premiumThirdprice;


	@FindBy(id = "translation-btn")
	public WebElement languagebtn;

	@FindBy(id = "country-name")
	public WebElement countryNamebtn;

	@FindBy(xpath = "//span[@id='country-name']")
	public WebElement arabicCountrybtn;

	@FindBy(id = "sa")
	public WebElement saudiImg;

	@FindBy(id = "kw")
	public WebElement kuwaitImg;

	@FindBy(id = "bh")
	public WebElement bahrainImg;

	@FindBy(id = "country-selct")
	public WebElement popOne;




	public void CountrySelection(WebElement element)
	{
		clickButton(arabicCountrybtn);
		popOne.isDisplayed();
		clickButton(element);
	}

	public void countryDisplaying()
	{
        languagebtn.getText().contains(" English");
		countryNamebtn.isDisplayed();
		lightlbl.isDisplayed();
		standardlbl.isDisplayed();
		premiumlbl.isDisplayed();
	}

	public void ksaSelection()
	{

		CountrySelection(saudiImg);

	}

	public void kuwaitSelection()
	{

		CountrySelection(kuwaitImg);

	}

	public void bahrainSelection()
	{

		CountrySelection(bahrainImg);
	}




}
