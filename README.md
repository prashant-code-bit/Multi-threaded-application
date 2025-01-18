// A simple multi-threaded Java application demonstrating basic threading concepts.

class Task implements Runnable {
    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println(taskName + " is running, iteration " + i);
            try {
                // Simulating some work with sleep
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println(taskName + " was interrupted.");
            }
        }
        System.out.println(taskName + " has finished.");
    }
}

public class MultiThreadedApplication {
    public static void main(String[] args) {
        System.out.println("Starting Multi-Threaded Application...");

        // Create tasks
        Task task1 = new Task("Task 1");
        Task task2 = new Task("Task 2");
        Task task3 = new Task("Task 3");

        // Create threads for each task
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();

        // Main thread waits for all threads to finish
        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            System.err.println("Main thread was interrupted.");
        }

        System.out.println("All tasks are completed. Exiting application.");
    }
}
