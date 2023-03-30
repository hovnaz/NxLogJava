package SynchroProcessor___Task_2;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SynchroProcessor {

    private Processor processor;

    public static void main(String[] args) {
        SynchroProcessor synchroProcessor = new SynchroProcessor();
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<Void> initializer = CompletableFuture.runAsync(synchroProcessor::initializeProcessor, executorService);
        CompletableFuture<Void> executor = initializer.thenRunAsync(synchroProcessor::executeProcessor, executorService);

        executor.join(); // Wait for both tasks to complete

        executorService.shutdown();
    }

    private void initializeProcessor() {
        processor = new Processor();
        processor.init();
    }

    private void executeProcessor() {
        processor.process();
    }
}
