package com.example.courseregistration;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by lantaodong on 2018-02-26.
 */

public class ButtonTest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void buttonTest(){
        //added a sleep statement to match the app's execution delay.

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction Login = onView(
                allOf(withId(R.id.login), withText("Login"), isDisplayed()));
        Login.perform(click());



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction button = onView(
                allOf(withId(R.id.create), withText("Create Account"),isDisplayed()));
        button.perform(click());

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction register = onView(
                allOf(withId(R.id.register), withText("Register"),isDisplayed()));
        register.perform(click());



        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ViewInteraction backButton = onView(
                allOf(withId(R.id.back), withText("Back"),isDisplayed()));
        backButton.perform(click());




    }


}
