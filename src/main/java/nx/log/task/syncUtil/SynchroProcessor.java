package nx.log.task.syncUtil;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * The SynchroProcessor class ensures that the processor in Executor is always
 * initialized when process() method is executed.
 */
public class SynchroProcessor {

    private Processor processor;

    /**
     * The main method creates an instance of SynchroProcessor, initializes the processor
     * in a separate thread using CompletableFuture, and executes the processor
     * in another thread after initialization is completed.
     */
    public static void main(String[] args) {
        SynchroProcessor synchroProcessor = new SynchroProcessor();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Void> initializer = CompletableFuture.runAsync(synchroProcessor::initializeProcessor, executorService);
        CompletableFuture<Void> executor = initializer.thenRunAsync(synchroProcessor::executeProcessor, executorService);

        executor.join();

        executorService.shutdown();
    }

    /**
     * Initializes the processor by creating a new instance of Processor
     * and invoking the init() method.
     */
    private void initializeProcessor() {
        processor = new Processor();
        processor.init();
    }

    /**
     * Executes the processor by invoking the process() method.
     */
    private void executeProcessor() {
        processor.process();
    }
}
