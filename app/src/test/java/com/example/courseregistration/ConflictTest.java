package com.example.courseregistration;

import org.junit.Test;

/**
 * Created by Jaspering21 on 2018-03-14.
 */

public class ConflictTest {
    @Test
    public void checkConflict(User user, Class class){
        validator val = new validator();
        if(!user.getRegisteredCourse().getTime().equals(class.getTime())){
            assertEquals(0, val.checkValid());
        }
    }
}
