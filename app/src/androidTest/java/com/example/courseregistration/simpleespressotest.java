package com.example.courseregistration;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by dengyiran on 18/2/28.
 */

public class simpleespressotest {
        @Rule
        public ActivityTestRule<Departmentchoose> mActivityRule = new ActivityTestRule<>(
                Departmentchoose.class);

        @Test
        public void check0Activity() {
            onView(withId(R.id.checkbox)).check(matches(isChecked()));
            onView(withId(R.id.button)).perform(click());
        }
}
