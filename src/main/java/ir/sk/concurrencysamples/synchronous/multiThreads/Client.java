package ir.sk.concurrencysamples.synchronous.multiThreads;

import java.util.concurrent.ExecutionException;

/**
 * Created by sad.kayvanfar on 12/21/2021.
 */
public class Client {

    public void price() {
        Shop shop = new Shop();
        long start = System.nanoTime();
        double result = 0;
        try {
            result = shop.getPrice("my favorite product"); // block here
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(result);
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("invocation returned after " + invocationTime + "msecs");

        doSomthingElse();
    }

    private void doSomthingElse() {
        // Do some more tasks, like querying other shops
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.price();
    }
}
