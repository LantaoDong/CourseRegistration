package com.example.courseregistration;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isSelected;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Created by dengyiran on 18/2/28.
 */

public class simpleespressotest {
        @Rule
        public ActivityTestRule<Departmentchoose> mActivityRule1 = new ActivityTestRule<>(
                Departmentchoose.class);


        @Test
        public void check0Activity() {
                onView(withId(R.id.checkBox6)).check(matches(isNotChecked()));
                onView(withId(R.id.checkBox7)).check(matches(isNotChecked()));
                onView(withId(R.id.checkBox8)).check(matches(isNotChecked()));
                onView(withId(R.id.checkBox9)).check(matches(isNotChecked()));
                onView(withId(R.id.checkBox10)).check(matches(isNotChecked()));
                 //onView(withId(R.id.button3)).check(matches(isDisplayed()));

        }

        /*public void check2Activity() {
        onView(withId(R.id.checkBox8)).check(matches(isChecked())).perform(scrollTo(), click());
                onView(withId(R.id.button)).perform(click());
        }
        public void check3Activity() {
        onView(withId(R.id.checkBox9)).check(matches(isChecked())).perform(scrollTo(), click());
                onView(withId(R.id.button)).perform(click());
        }
        public void check4Activity() {
        onView(withId(R.id.checkBox10)).check(matches(isChecked())).perform(scrollTo(), click());
                onView(withId(R.id.button)).perform(click());
        }*/
}
