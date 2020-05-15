package utils;

//TODO: make continuous thread
public class Log implements Runnable {

    private static boolean isRunning = false;
    private Thread t;

    public void print(String msg) {
        if (!isRunning) {
            run();
        }
        System.out.println(msg);
    }

    public void run() {
        t = new Thread(this);
        t.setName("Log thread");
        t.setPriority(7);
        t.setDaemon(true);
        t.start();
        isRunning = true;
    }
}
