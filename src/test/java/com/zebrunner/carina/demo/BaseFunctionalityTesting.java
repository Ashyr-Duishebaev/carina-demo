package com.zebrunner.carina.demo;

import com.zebrunner.carina.core.IAbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.demo.pixel.android.ClockAppPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class BaseFunctionalityTesting implements IAbstractTest {

    @Test()
    @MethodOwner(owner = "ashyr")
    public void testAppLaunch() {
        ClockAppPage clockAppPage = initPage(getDriver(), ClockAppPage.class);
        Assert.assertTrue(clockAppPage.isPageOpened(), "Clock app is not launched successfully.");
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void testSettingAlarm() {
        ClockAppPage clockAppPage = initPage(getDriver(), ClockAppPage.class);
        Assert.assertTrue(clockAppPage.isPageOpened(), "Clock app is not launched successfully.");

        String alarmTime = "08:00 AM";
        clockAppPage.setAlarm(alarmTime);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(clockAppPage.isAlarmSet(alarmTime), "Alarm is not set to the specified time.");
        softAssert.assertTrue(clockAppPage.isAlarmEnabled(), "Alarm is not enabled.");
        softAssert.assertTrue(clockAppPage.isClockDisplayed(), "Clock is not displayed on the main screen.");
        softAssert.assertTrue(clockAppPage.isAlarmButtonDisplayed(), "Alarm button is not displayed on the main screen.");
        softAssert.assertTrue(clockAppPage.isStopwatchButtonDisplayed(), "Stopwatch button is not displayed on the main screen.");
        softAssert.assertTrue(clockAppPage.isTimerButtonDisplayed(), "Timer button is not displayed on the main screen.");
        softAssert.assertTrue(clockAppPage.isWorldClockButtonDisplayed(), "World Clock button is not displayed on the main screen.");

        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void testStopwatchFunctionality() {
        ClockAppPage clockAppPage = initPage(getDriver(), ClockAppPage.class);
        Assert.assertTrue(clockAppPage.isPageOpened(), "Clock app is not launched successfully.");

        clockAppPage.openStopwatch();
        clockAppPage.startStopwatch();

        try {
            Thread.sleep(5000); // 5000 milliseconds = 5 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        clockAppPage.stopStopwatch();

        SoftAssert softAssert = new SoftAssert();
        String elapsedTime = clockAppPage.getStopwatchElapsedTime();
        Assert.assertEquals(elapsedTime, "00:05", "Stopwatch did not measure the correct elapsed time.");
        softAssert.assertTrue(clockAppPage.isAlarmEnabled(), "Alarm is not enabled.");
        softAssert.assertTrue(clockAppPage.isStopwatchStarted(), "Stopwatch did not start when expected.");
        softAssert.assertTrue(clockAppPage.getStopwatchElapsedTime().equals("00:05"), "Stopwatch did not measure the correct elapsed time.");
        softAssert.assertAll();
    }

    @Test()
    @MethodOwner(owner = "ashyr")
    public void testTimerFunctionality() {
        ClockAppPage clockAppPage = initPage(getDriver(), ClockAppPage.class);
        Assert.assertTrue(clockAppPage.isPageOpened(), "Clock app is not launched successfully.");
        clockAppPage.openTimer();
        clockAppPage.setTimer("2", "00");
        clockAppPage.startTimer();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(clockAppPage.isTimerSetTo("2", "00"), "Timer is not set to the specified time.");
        softAssert.assertTrue(clockAppPage.isTimerStarted(), "Timer did not start when expected.");
        try {
            Thread.sleep(120000); // 120000 milliseconds = 2 minutes
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        softAssert.assertTrue(clockAppPage.isTimerExpired(), "Timer did not expire after 2 minutes.");
        Assert.assertTrue(clockAppPage.isTimerExpired(), "Timer did not expire after 2 minutes.");
        softAssert.assertAll();
    }
}
