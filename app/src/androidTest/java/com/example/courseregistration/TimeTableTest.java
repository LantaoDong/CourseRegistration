package com.example.courseregistration;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.CoreMatchers.anything;

/**
 * Created by Haofan
 */

@RunWith(AndroidJUnit4.class)
@LargeTest
public class TimeTableTest {
    @Rule
    public ActivityTestRule<MajorListActivity> mActivityRule = new ActivityTestRule<>(
            MajorListActivity.class);

    @Test
    //Input a password which meets all rules
    public void clickMajorList(){
        //onData(anything()).inAdapterView(withId(R.id.listviews)).atPosition(0).perform(click());

    }
}
