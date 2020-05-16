package utils;

import java.util.LinkedList;
import java.util.Queue;

import static utils.consts.*;

public class Log implements Runnable {

    private static Queue<String> q = new LinkedList<>();
    private static Thread t;

    public Log() {
        if (t == null) {
            System.out.println("No log running. Creating log");
            t = new Thread(this);
            t.setName("Log thread");
            t.setPriority(LOG_PRIORITY);
            System.out.println(t.getName() + " created");
            t.start();
        }

    }

    public void print(String msg) {
        q.offer(msg);
    }

    @Override
    public void run() {
        //The more message, the less it respond
        int rate = STANDARD_LOG_RATE;

        while (true) {
            if (!q.isEmpty()) {
                System.out.println(q.poll());
                rate = (int) Math.min(rate * LOG_RATE_INCREASE_RATE, MAXIMUM_LOG_RATE);
            } else {
                rate = (int) Math.max(MINIMUM_LOG_RATE, rate * consts.LOG_RATE_DECAY_RATE);
            }
            try {
                Thread.sleep(rate * SLEEP_TIME_PER_RATE);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
