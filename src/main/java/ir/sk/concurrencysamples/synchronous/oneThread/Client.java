package ir.sk.concurrencysamples.synchronous.oneThread;

/**
 * Created by sad.kayvanfar on 12/21/2021.
 */
public class Client {

    public void price() {
        Shop shop = new Shop();
        long start = System.nanoTime();
        double result = shop.getPrice("my favorite product"); // block here
        System.out.println(result);
        long invocationTime = ((System.nanoTime() - start) / 1_000_000);
        System.out.println("invocation returned after " + invocationTime + "msecs");

        // Do some more tasks, like querying other shops
        doSomthingElse();
    }

    private void doSomthingElse() {
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.price();
    }
}
