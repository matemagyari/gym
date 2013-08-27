package home.gym.domain.pipeline;

import javax.inject.Named;

@Named
public class PipelineManager {
    
    public Pipeline createPipeline(int length) {
        return new Pipeline(length);
    }

    public Pipeline createPipeline() {
        return new Pipeline();
    }

    
}
