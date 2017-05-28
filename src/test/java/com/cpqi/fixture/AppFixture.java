package com.cpqi.fixture;

import com.cpqi.App;
import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

/**
 * Created by silvionetto on 23/05/17.
 */
@RunWith(ConcordionRunner.class)
public class AppFixture {

    private App app;

    public String hello(String name) {
        app = new App();
        return app.hello(name);
    }

}
