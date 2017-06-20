package com.cpqi;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {

    private App app;

    @Before
    public void setup() {
        app = new App();
    }

    /**
     * Rigourous Test :-)
     */
    @Test
    public void testApp() {
        assertEquals("The value should be Hello + the name.", "Hello John", app.hello("John"));
    }
}
