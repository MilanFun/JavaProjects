package mipt.highload.queue;

import mipt.highload.queue.config.RabbitConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("mipt.highload.queue")
@Import(RabbitConfig.class)
public class QueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(QueueApplication.class, args);
	}

}
