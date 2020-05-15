package sample;

public class Log implements Runnable {

    private static Thread t;

    public Log() {
        if (t == null) {
            t = new Thread(this);
            t.setName("Log_thread");
            t.setPriority(8);
            t.setDaemon(true);
            run();
        }
    }

    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public void run() {
        System.out.println( t.getName() + " is running!\n");
    }
}
