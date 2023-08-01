package com.zebrunner.carina.demo.pixel.android;

import com.zebrunner.carina.demo.pixel.common.ClockAppPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ClockAppPage extends ClockAppPageBase {

    public ClockAppPage(WebDriver driver) {
        super(driver);
    }

    private By clock = By.id("clockLocator");
    private By alarmButton = By.id("alarmButtonLocator");
    private By stopwatchButton = By.id("stopwatchButtonLocator");
    private By timerButton = By.id("timerButtonLocator");
    private By worldClockButton = By.id("worldClockButtonLocator");

    public boolean isClockDisplayed() {
        return isElementPresent(clock);
    }

    public boolean isAlarmButtonDisplayed() {
        return isElementPresent(alarmButton);
    }

    public boolean isStopwatchButtonDisplayed() {
        return isElementPresent(stopwatchButton);
    }

    public boolean isTimerButtonDisplayed() {
        return isElementPresent(timerButton);
    }

    public boolean isWorldClockButtonDisplayed() {
        return isElementPresent(worldClockButton);
    }

    public boolean isAlarmSetTo(String alarmTime) {
        String actualAlarmTime = driver.findElement(By.id(ALARM_TIME_INPUT)).getText();
        return actualAlarmTime.equals(alarmTime);
    }

    public boolean isStopwatchStarted() {
        return isElementPresent(By.id(STOPWATCH_STOP));
    }

    private boolean isElementPresent(By id) {
        return false;
    }

    public boolean isTimerSetTo(String minutes, String seconds) {
        String actualMinutes = driver.findElement(By.id(TIMER_INPUT_MINUTES)).getText();
        String actualSeconds = driver.findElement(By.id(TIMER_INPUT_SECONDS)).getText();
        return actualMinutes.equals(minutes) && actualSeconds.equals(seconds);
    }

    public boolean isTimerStarted() {
        WebElement startButton = driver.findElement(By.id(TIMER_START));
        return startButton.getAttribute("enabled").equals("true");
    }

    public void clickAlarmTab() {
         driver.findElement(By.id(ALARM_TAB)).click();
    }

    public void clickStopwatchTab() {
         driver.findElement(By.id(STOPWATCH_TAB)).click();
    }

    public void clickTimerTab() {
         driver.findElement(By.id(TIMER_TAB)).click();
    }

    public void setAlarm(String alarmTime) {
         driver.findElement(By.id(ALARM_TIME_INPUT)).sendKeys(alarmTime);
    }

    public boolean isAlarmSet(String alarmTime) {
         String actualAlarmTime = driver.findElement(By.id(ALARM_TIME_INPUT)).getText();
         return actualAlarmTime.equals(alarmTime);
    }

    public boolean isAlarmEnabled() {
         WebElement toggle = driver.findElement(By.id(ALARM_ENABLED_TOGGLE));
         return toggle.getAttribute("checked").equals("true");
    }

    public void openStopwatch() {
         driver.findElement(By.id(STOPWATCH_TAB)).click();
    }

    public void startStopwatch() {
         driver.findElement(By.id(STOPWATCH_START)).click();
    }

    public void stopStopwatch() {
         driver.findElement(By.id(STOPWATCH_STOP)).click();
    }

    public String getStopwatchElapsedTime() {
         return driver.findElement(By.id(STOPWATCH_STOP)).getText();
    }

    public void openTimer() {
         driver.findElement(By.id(TIMER_TAB)).click();
    }

    public void setTimer(String minutes, String seconds) {
         driver.findElement(By.id(TIMER_INPUT_MINUTES)).sendKeys(minutes);
         driver.findElement(By.id(TIMER_INPUT_SECONDS)).sendKeys(seconds);
    }

    public void startTimer() {
         driver.findElement(By.id(TIMER_START)).click();
    }

    public boolean isTimerExpired() {
         return driver.findElement(By.id(TIMER_START)).getAttribute("enabled").equals("false");
    }


}
