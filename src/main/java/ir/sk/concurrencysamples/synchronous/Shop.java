package ir.sk.concurrencysamples.synchronous;

import java.util.Random;

/**
 * Created by sad.kayvanfar on 12/21/2021.
 */
public class Shop {

    public double getPrice(String product) {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) {
        delay();
        Random random = new Random();
        return random.nextDouble() * product.charAt(0) + product.charAt(1);
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
