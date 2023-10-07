package mipt.highload.queue.config;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;
import org.apache.log4j.Logger;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class RabbitConfig {
    Logger logger = Logger.getLogger(RabbitConfig.class);

    @Bean
    public Session sessionConfig() {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.host", "smtp.yandex.ru");
        prop.put("mail.smtp.port", 465);
        prop.put("mail.smtp.ssl.enable", "true");
        prop.put("mail.transport.protocol", "smtp");

        return Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("orifleiminc@yandex.ru", "jstnwzgxwiirrday");
            }
        });
    }

    public void sendMessage(String msg, String email) throws MessagingException {
        MimeMessage message = new MimeMessage(sessionConfig());
        message.setFrom(new InternetAddress("orifleiminc@yandex.ru"));
        message.setRecipients(
                MimeMessage.RecipientType.TO, InternetAddress.parse(email));
        message.setSubject("Mail Subject");

        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(msg, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        return new CachingConnectionFactory("localhost");
    }

    @Bean
    public AmqpAdmin amqpAdmin() {
        return new RabbitAdmin(connectionFactory());
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public Queue myQueue1() {
        return new Queue("queue4");
    }

    @Bean
    public SimpleMessageListenerContainer messageListenerContainer1() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setQueueNames("queue4");
        container.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                String msg = new String(message.getBody());
                String[] arrMsg = msg.split("\\s");
                try {
                    sendMessage(arrMsg[0], arrMsg[1]);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        return container;
    }
}
