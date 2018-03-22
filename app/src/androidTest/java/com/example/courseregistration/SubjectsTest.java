package com.example.courseregistration;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.widget.ListView;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by lantaodong on 2018-03-10.
 */

public class SubjectsTest {
    @Rule
    public ActivityTestRule<CourseFilter> mActivityTestRule = new ActivityTestRule<>(CourseFilter.class);

    @Test
    public void SubjectsTest(){
        /*
        onView(withId(R.id.username)).perform(typeText("abc"), ViewActions.closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("abc"), ViewActions.closeSoftKeyboard());
        //added time delay to make the test pass
        onView(withId(R.id.login)).perform(click());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ViewInteraction appCompatButton5 = onView(
                allOf(withId(R.id.searchCourse), withText("Search Course"), isDisplayed()));
        appCompatButton5.perform(click());
        */

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int numItems = ((ListView) mActivityTestRule.getActivity().findViewById(R.id.subject)).getAdapter().getCount();
        for (int i = 0; i < numItems; i++) {
            onData(anything())
                    .inAdapterView(withId(R.id.subject)).atPosition(i)
                    .check(matches(isDisplayed()));
        }

    }
}
