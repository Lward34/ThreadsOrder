/*
 * File:Main.java
 * Lilian Ward
 * CMSC 412
 * April 2, 2021
 * Purpose: This program creates three new threads 
 * Synchronizes them in a such way that each thread display its thread id in turn for 5 iterations
 *
 */

class MyThread implements Runnable {

    //This thread specific variable
    String thrdName;

    //constructor
    MyThread(String name) {
        thrdName = name;
    }

    //Override the run() method of runnable interface
    @Override
    public void run() {
        // a try/ catch block
        try {
            // start a for loop, counts to 5 
            for (int count = 0; count < 5; count++) {
                // thread to sleep every 0.4 seconds
                Thread.sleep(400);
                System.out.println(thrdName + " - iteration no. " + (count + 1));
            }
        } catch (InterruptedException exc) {
            System.out.println(thrdName + " interrupted.");
        }
    }
}

//Define class UserThreads
class UserThreads {
    // Start the Main () method and throws interrupt Exception

    public static void main(String[] args) {
        try {
            // start a for loop 
            //Each time creates a thread start it up and pause for 0.1 seconds
            //This delay ensures that each of the thread gets a chance to print for its current iteration 
            //before goes next iteration
            for (int i = 0; i < 3; i++) {
                (new Thread(new MyThread("Thread " + (i + 1)))).start();
                Thread.sleep(100);
            }
        } catch (InterruptedException exc) {
            System.out.println("Main thread interrupted.");
        }
    }
}
