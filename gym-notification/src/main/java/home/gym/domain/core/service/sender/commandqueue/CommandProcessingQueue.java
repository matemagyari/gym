package home.gym.domain.core.service.sender.commandqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;
import javax.inject.Named;

@Named
public class CommandProcessingQueue {
    
    private static final int QUEUE_LENGTH = 1000;
    private BlockingQueue<Command> queue;
    
    @SuppressWarnings("unused")
    @PostConstruct
    private void intializeQueue() {
        queue = new ArrayBlockingQueue<Command>(QUEUE_LENGTH);
        
        Executor executor = Executors.newSingleThreadExecutor();
        executor.execute(new Runnable() {
            
            @Override
            public void run() {
                while (true) {
                    
                    try {
                        Command command = queue.take();
                        command.execute();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

    }
    
    public void putInQueue(Command command) {
        queue.add(command);
    }

}
