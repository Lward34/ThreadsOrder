public class ThreadsOrder implements Runnable {

    private static int numThread = 0;
    private static int threadAllowedToRun = 1;

    // This thread specific variables
    private int iterations = 0;
    private int myThreadID;

    private static final Object myLock = new Object();

    //constructor
    public ThreadsOrder() {
        this.myThreadID = 1 + numThread++;
    }

    @Override
    public void run() {
        synchronized (myLock) {
            while (iterations++ < 5) {
                while (myThreadID != threadAllowedToRun) {
                    try {
                        myLock.wait();
                    } catch (InterruptedException e) {

                    } catch (Exception e) {
                    }
                }
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {

                }

                System.out.println("Thread " + myThreadID + " - Iteration " + iterations);
                threadAllowedToRun = 1 + threadAllowedToRun % numThread;
                myLock.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Thread t1 = new Thread(new ThreadsOrder());
        Thread t2 = new Thread(new ThreadsOrder());
        Thread t3 = new Thread(new ThreadsOrder());

        t3.start();
        t2.start();
        t1.start();

    }
}
