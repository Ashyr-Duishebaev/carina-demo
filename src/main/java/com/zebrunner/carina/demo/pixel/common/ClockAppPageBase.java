package com.zebrunner.carina.demo.pixel.common;

import org.openqa.selenium.WebDriver;
import com.zebrunner.carina.webdriver.gui.AbstractPage;

public class ClockAppPageBase extends AbstractPage {

    protected static final String ALARM_TAB = "alarm_tab";
    protected static final String STOPWATCH_TAB = "stopwatch_tab";
    protected static final String TIMER_TAB = "timer_tab";

    protected static final String ALARM_TIME_INPUT = "alarm_time_input";
    protected static final String ALARM_ENABLED_TOGGLE = "alarm_enabled_toggle";
    protected static final String ALARM_SET = "alarm_set";

    protected static final String STOPWATCH_START = "stopwatch_start";
    protected static final String STOPWATCH_STOP = "stopwatch_stop";

    protected static final String TIMER_INPUT_MINUTES = "timer_input_minutes";
    protected static final String TIMER_INPUT_SECONDS = "timer_input_seconds";
    protected static final String TIMER_START = "timer_start";

    public ClockAppPageBase(WebDriver driver) {
        super(driver);
    }


    public void clickAlarmTab() {
    }

    public void clickStopwatchTab() {
    }

    public void clickTimerTab() {
    }

    public void setAlarm(String alarmTime) {
    }

    public boolean isAlarmSet(String alarmTime) {
        return false;
    }

    public boolean isAlarmEnabled() {
        return false;
    }

    public void openStopwatch() {
    }

    public void startStopwatch() {
    }

    public void stopStopwatch() {
    }

    public String getStopwatchElapsedTime() {
        return "";
    }

    public void openTimer() {
    }

    public void setTimer(String minutes, String seconds) {
    }

    public void startTimer() {
    }

    public boolean isTimerExpired() {
        return false;
    }
}

