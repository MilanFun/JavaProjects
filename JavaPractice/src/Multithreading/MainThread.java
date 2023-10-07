package Multithreading;

public class MainThread {
  public static void main(String[] args) {
    Counter counter = new Counter();

    SimpleThread threadOne = new SimpleThread("Thread One", counter);
    SimpleThread threadTwo = new SimpleThread("Thread Two", counter);

    threadOne.start();
    threadTwo.start();

    try {
      threadOne.join();
      threadTwo.join();
    }catch (InterruptedException e){
      System.out.println("Threads interrupted.");
      e.printStackTrace();
    }
  }
}

class Counter {
  public void display() {
    try {
      for(int i = 1; i<=5; i++){
        System.out.println("Counter: " + i);
      }
    }catch (Exception e){
      System.out.println("Thread is interrupted.");
    }
  }
}

class SimpleThread extends Thread {
  private Thread thread;
  private String threadName;
  final Counter counter;

  public SimpleThread(String threadName, Counter counter) {
    this.threadName = threadName;
    this.counter = counter;
  }

  @Override
  public void run() {
    System.out.println("Thread " + threadName + " is running...");
    synchronized (counter) {
      counter.display();
    }
    System.out.println("Leaving " + threadName + " thread...");
  }

  @Override
  public void start() {
    System.out.println("Thread " + threadName + " successfully started.");
    if (thread == null) {
      thread = new Thread(this, threadName);
      thread.start();
    }
  }
}
