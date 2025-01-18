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
