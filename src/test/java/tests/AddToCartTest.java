package tests;

import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test
    void userShouldBeAbleToAddProductToCart(){
        driver.get("https://www.amazon.in/");

    }
}
