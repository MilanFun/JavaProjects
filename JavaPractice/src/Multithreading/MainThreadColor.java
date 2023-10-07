package Multithreading;

public class MainThreadColor {
  public static void main(String[] args) {
    Count count = new Count();

    CountThread thread1 = new CountThread(count);
    CountThread thread2 = new CountThread(count);

    thread1.setName("Thread 1");
    thread2.setName("Thread 2");

    thread1.start();
    thread2.start();
  }
}

class Count {
  private int i;

  public void doCount() {
    String color;

    switch (Thread.currentThread().getName()) {
      case "Thread 1":
        color = ThreadColor.ANSI_CYAN;
        break;
      case "Thread 2":
        color = ThreadColor.ANSI_PURPLE;
        break;
      default:
        color = ThreadColor.ANSI_GREEN;
    }
    synchronized (this) {
      for (i = 10; i > 0; i--) {
        System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
      }
    }
  }
}

class ThreadColor {
  public static final String ANSI_RED = "\u001B[31m";
  public static final String ANSI_GREEN = "\u001B[32m";
  public static final String ANSI_YELLOW = "\u001b[33m";
  public static final String ANSI_BLUE = "\u001B[34m";
  public static final String ANSI_PURPLE = "\u001B[35m";
  public static final String ANSI_CYAN = "\u001B[36m";
  public static final String ANSI_WHITE = "\u001b[37m";
}

class CountThread extends Thread {
  private Count count;

  public CountThread(Count count) {
    this.count = count;
  }

  @Override
  public void run() {
    this.count.doCount();
  }
}
