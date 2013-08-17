package home.gym.domain.service.sender.core;

import home.gym.calendar.api.model.core.contact.Contact;
import home.gym.domain.model.MessageText;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;

public class MultiThreadingMessageSenderContext implements MessageSenderContext {

	private Executor executor;

	@Value("${threadpool.size}")
	private int threadPoolSize;
	
	@SuppressWarnings("unused")
    @PostConstruct
	private void intializeExecutor() {
		executor = Executors.newFixedThreadPool(threadPoolSize);
	}

	@Override
    public <T extends Contact> void send(T contact, MessageText message, ContactTypeSpecificSender<T> sender  ) {
		executor.execute(command(contact, message, sender));
	}

	private <T extends Contact> Runnable command(final T contact, final MessageText message, final ContactTypeSpecificSender<T> sender) {
		return new Runnable() {

			@Override
			public void run() {
				sender.send(contact, message);
			}
		};
	}


	void setThreadPoolSize(int threadPoolSize) {
		this.threadPoolSize = threadPoolSize;
	}
}
