package com.example.courseregistration;

import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.AllOf.allOf;

/**
 * Test if UI is showing
 *
 * Created by lantaodong on 2018-03-25.
 */

public class UITest {
    @Rule
    public ActivityTestRule<UserActivity> mActivityTestRule = new ActivityTestRule<>(UserActivity.class);
    @Test
    public void UITest(){
        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.drop), withText("add/drop"), isDisplayed()));
        appCompatButton.check(matches(isDisplayed()));
        ViewInteraction appCompatButton2 = onView(
                allOf(withId(R.id.searchCourse), withText("Search Course"), isDisplayed()));
        appCompatButton2.check(matches(isDisplayed()));
        ViewInteraction appCompatButton3 = onView(
                allOf(withId(R.id.help), withText("help"), isDisplayed()));
        appCompatButton3.check(matches(isDisplayed()));
        ViewInteraction appCompatButton4 = onView(
                allOf(withId(R.id.timeTable), withText("time table"), isDisplayed()));
        appCompatButton4.check(matches(isDisplayed()));
        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.schedule), withText("view schedule"), isDisplayed()));
        appCompatButton5.check(matches(isDisplayed()));
        ViewInteraction appCompatButton6 = onView(
                allOf(withId(R.id.changePassword), withText("Change Password"), isDisplayed()));
        appCompatButton6.check(matches(isDisplayed()));
        ViewInteraction appCompatButton7 = onView(
                allOf(withId(R.id.registeredCourses), withText("Registered Courses"), isDisplayed()));
        appCompatButton7.check(matches(isDisplayed()));
        ViewInteraction appCompatButton8 = onView(
                allOf(withId(R.id.backToLogin), withText("Logout"), isDisplayed()));
        appCompatButton8.check(matches(isDisplayed()));
    }
}
