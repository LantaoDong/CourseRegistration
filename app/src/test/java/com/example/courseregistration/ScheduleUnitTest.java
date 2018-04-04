package com.example.courseregistration;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ScheduleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    //public boolean checkIfInsideTime(int startHr, int startMin, int endHr, int endMin, int newHr, int newMin) {

    @Test
    public void codeGetters_areCorrect() throws Exception {
        assertEquals(ViewScheduleSingleDay.getDayCode("Monday"), "M");
        assertEquals(ViewScheduleSingleDay.getDayCode("Smarch"), "Z");

        assertEquals(ViewScheduleSingleDay.getTermCode("Fall"), 1);
        assertEquals(ViewScheduleSingleDay.getTermCode("Smarch"), -1);


    }
}


                     //////