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
 * Created by lantaodong on 2018-03-10.
 */

public class HelpIndexTest {
    @Rule
    public ActivityTestRule<HelpContact> mActivityTestRule = new ActivityTestRule<>(HelpContact.class);
    @Test
    public void HelpIndexTest(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int numItems = ((ListView) mActivityTestRule.getActivity().findViewById(R.id.help)).getAdapter().getCount();
        for (int i = 0; i < numItems; i++) {
            onData(anything())
                    .inAdapterView(withId(R.id.help)).atPosition(i)
                    .check(matches(isDisplayed()));
        }
    }
}
