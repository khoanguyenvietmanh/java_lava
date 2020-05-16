package utils;

//TODO: Implement Runnable

import java.util.LinkedList;
import java.util.Queue;

public class Log implements Runnable {

    private static Queue<String> q = new LinkedList<>();
    private static Thread t;

    public Log() {
        if (t == null) {
            t = new Thread(this);
            t.setName("Log thread");
            t.setPriority(8);

            t.start();
        }

    }

    public void print(String msg) {
        q.offer(msg);
    }

    @Override
    public void run() {
        int rate = 1;
        while (true) {
            if (!q.isEmpty()) {
                System.out.println(q.poll());
                rate = 1;
            } else {
                rate = Math.max(rate + 1, 5000);
            }
            try {
                Thread.sleep(100 * rate);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
