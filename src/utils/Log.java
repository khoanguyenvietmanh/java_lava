package utils;

public class Log implements Runnable {

    static Thread t;

    public Log() {
        if (t == null) {
            System.out.println("Log thread is null");
            t = new Thread(this);
            t.setName("Log_thread");
            t.setPriority(8);
            t.setDaemon(true);
            System.out.println("Create new " + t.getName());
        }
    }

    public void print(String msg) {
        System.out.println(msg);
    }

    @Override
    public void run() {
        System.out.println(t.getName() + " is running!");
    }

}
