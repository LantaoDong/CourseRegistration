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
    public void timeTest_isCorrect() throws Exception {
        assertEquals(ViewSchedule.checkIfInsideTime(8,30,10,30,8,30), true);
    }

    @Test
    public void timeTest_isCorrect2() throws Exception {
        assertEquals(ViewSchedule.checkIfInsideTime(8,30,10,30,11,00), false);
    }
}


                     //////