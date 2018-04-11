package com.example.courseregistration;

import android.support.test.rule.ActivityTestRule;
import android.widget.ListView;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

/**
 * Test if users are able to check registered courses
 *
 * Created by lantaodong on 2018-03-25.
 */

public class ViewCoursesTest {
    @Rule
    public ActivityTestRule<ViewCourses> mActivityTestRule = new ActivityTestRule<>(ViewCourses.class);
    @Test
    public void ViewCoursesTest(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int numItems = ((ListView) mActivityTestRule.getActivity().findViewById(R.id.courses)).getAdapter().getCount();
        for (int i = 0; i < numItems; i++) {
            onData(anything())
                    .inAdapterView(withId(R.id.courses)).atPosition(i)
                    .check(matches(isDisplayed()));
        }
    }
}
