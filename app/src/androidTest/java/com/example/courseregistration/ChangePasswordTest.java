package com.example.courseregistration;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Test if users are able to change password
 *
 * Created by lantaodong on 2018-03-25.
 */

public class ChangePasswordTest {
    @Rule
    public ActivityTestRule<ChangePassword> mActivityTestRule = new ActivityTestRule<>(ChangePassword.class);
    @Test
    public void ChangePasswordTest(){
        onView(withId(R.id.oldPassword)).perform(typeText("abc"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.newPassword)).perform(typeText("abc"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.change)).perform(click());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
