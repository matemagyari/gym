package home.gym.domain.pipeline;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Pipeline {
    
    private static final int QUEUE_LENGTH = 1000;
    private final BlockingQueue<PipelineCommand> queue;
    
    public Pipeline() {
        this(QUEUE_LENGTH);
    }
    public Pipeline(int length) {
        queue = new ArrayBlockingQueue<PipelineCommand>(length);
        intializeQueue();
    }

    private void intializeQueue() {
        
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            
            @Override
            public void run() {
                while (true) {
                    
                    try {
                        PipelineCommand pipelineCommand = queue.take();
                        pipelineCommand.execute();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

    }
    
    public void putIn(PipelineCommand pipelineCommand) {
        queue.add(pipelineCommand);
    }

}
