package pages;

import java.util.Random;

public class BasePage {

    protected int randomNumber() {
        Random randomGenerator = new Random();
        return randomGenerator.nextInt(10000);
    }

}
