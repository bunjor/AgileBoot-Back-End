package com.agileboot.common.core.exception;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ApiExceptionTest {


    @Test
    public void testVarargsWithArrayArgs() {
        String errorMsg = "these parameters are null: %s, %s, %s.";
        Object[] array = new Object[] { "param1" , "param2" , "param3"};

        String formatWithArray = String.format(errorMsg, array);
        String formatWithVarargs = String.format(errorMsg, "param1", "param2", "param3");

        Assertions.assertEquals(formatWithVarargs, formatWithArray);
    }

    @Test
    public void testVarargsWithNullArgs() {
        String errorMsg = "these parameters are null: %s, %s, %s.";

        String format = String.format(errorMsg, "param1", null, null);

        Assertions.assertEquals("these parameters are null: param1, null, null.", format);
    }

}
