package ir.sk.concurrencysamples.synchronous.multiThreads;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by sad.kayvanfar on 12/21/2021.
 */
public class Shop {

    public double getPrice(String product) throws ExecutionException, InterruptedException {
        return calculatePrice(product);
    }

    private double calculatePrice(String product) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        // forking
        Future<Double> future = executorService.submit(new Callable<Double>() {
            @Override
            public Double call() {
                delay();
                Random random = new Random();
                return random.nextDouble() * product.charAt(0) + product.charAt(1);
            }
        });
        executorService.shutdown();
        return future.get();
    }

    public static void delay() {
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
