package us.devcloud.anthill;


import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void testApp() {
        App app = new App();
        app.engine().run();
    }
}
