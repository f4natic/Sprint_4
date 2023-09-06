package ru.yandex.practicum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutImportantPage {
    private WebDriver driver;

    private By title = By.className("Home_FourPart__1uthg");
    private By questionOne = By.id("accordion__heading-0");
    private By answerOne = By.id("accordion__panel-0");
    private By questionTwo = By.id("accordion__heading-1");
    private By answerTwo = By.id("accordion__panel-1");
    private By questionThree = By.id("accordion__heading-2");
    private By answerThree = By.id("accordion__panel-2");
    private By questionFour = By.id("accordion__heading-3");
    private By answerFour = By.id("accordion__panel-3");
    private By questionFive = By.id("accordion__heading-4");
    private By answerFive = By.id("accordion__panel-4");
    private By questionSix = By.id("accordion__heading-5");
    private By answerSix = By.id("accordion__panel-5");
    private By questionSeven = By.id("accordion__heading-6");
    private By answerSeven = By.id("accordion__panel-6");
    private By questionEight = By.id("accordion__heading-7");
    private By answerEight = By.id("accordion__panel-7");

    public AboutImportantPage(WebDriver driver) {
        this.driver = driver;
    }

    public void scrollToImportant() {
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(title));
    }

    public void clickOnQuestionOne() {
        driver.findElement(questionOne).click();
    }

    public boolean answerOneShowText() {
        WebElement element = driver.findElement(answerOne);
        if(!element.getText().isEmpty() && element.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void clickOnQuestionTwo() {
        driver.findElement(questionTwo).click();
    }

    public boolean answerTwoShowText() {
        WebElement element = driver.findElement(answerTwo);
        if(!element.getText().isEmpty() && element.isDisplayed()) {
            return true;
        }
        return false;
    }
    public void clickOnQuestionThree() {
        driver.findElement(questionThree).click();
    }

    public boolean answerThreeShowText() {
        WebElement element = driver.findElement(answerThree);
        if(!element.getText().isEmpty() && element.isDisplayed()) {
            return true;
        }
        return false;
    }
    public void clickOnQuestionFour() {
        driver.findElement(questionFour).click();
    }

    public boolean answerFourShowText() {
        WebElement element = driver.findElement(answerFour);
        if(!element.getText().isEmpty() && element.isDisplayed()) {
            return true;
        }
        return false;
    }
    public void clickOnQuestionFive() {
        driver.findElement(questionFive).click();
    }

    public boolean answerFiveShowText() {
        WebElement element = driver.findElement(answerFive);
        if(!element.getText().isEmpty() && element.isDisplayed()) {
            return true;
        }
        return false;
    }
    public void clickOnQuestionSix() {
        driver.findElement(questionSix).click();
    }

    public boolean answerSixShowText() {
        WebElement element = driver.findElement(answerSix);
        if(!element.getText().isEmpty() && element.isDisplayed()) {
            return true;
        }
        return false;
    }

    public void clickOnQuestionSeven() {
        driver.findElement(questionSeven).click();
    }

    public boolean answerSevenShowText() {
        WebElement element = driver.findElement(answerSeven);
        if(!element.getText().isEmpty() && element.isDisplayed()) {
            return true;
        }
        return false;
    }
    public void clickOnQuestionEight() {
        driver.findElement(questionEight).click();
    }

    public boolean answerEightShowText() {
        WebElement element = driver.findElement(answerEight);
        if(!element.getText().isEmpty() && element.isDisplayed()) {
            return true;
        }
        return false;
    }
}
