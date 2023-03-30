## Task II

The following code contains 2 Threads running once:

### Code

```
public class SynchroProcessor___Task_2.SynchroProcessor {

    private SynchroProcessor___Task_2.Processor processor;

    public static void main(String[] args) {
	Thread t1 = new Executor().start();
	Thread t2 = new Initializer().start();

	System.exit(0);
    }

    private class Initializer extend Thread {
	public void run() {
	    processor = new SynchroProcessor___Task_2.Processor();
	    processor.init();
	}
    }
    private class Executor extend Thread {
	public void run() {
	    processor.process();
	}
    }
}
```

### Code

Write modified code which ensures the processor in Executor is always initialized when process() method is executed.
