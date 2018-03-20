package com.example.courseregistration;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

/**
 * Created by lantaodong on 2018-03-10.
 */

public class MathCourseDescriptionTest {
    @Rule
    public ActivityTestRule<MathCourses> mActivityTestRule = new ActivityTestRule<>(MathCourses.class);
    @Test
    public void MathCourseDescriptionTest(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
        onData(anything()).inAdapterView(withId(R.id.math)).atPosition(0).perform(click());
        onView(withId(R.id.MATHdescription)).check(matches(isDisplayed()));
    }

}
