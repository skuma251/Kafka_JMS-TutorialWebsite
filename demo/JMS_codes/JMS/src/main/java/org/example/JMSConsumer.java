package org.example;
import javax.jms.*;
public class JMSConsumer implements Runnable {
    private Session session = null;
    private MessageConsumer messageConsumer = null;
    private MQConfig mqConfig;
    public JMSConsumer() {
    }
    public void recieveMessage() {
        try {
            mqConfig = new MQConfig();
            mqConfig.Configuration();
            session = mqConfig.getSession();
            messageConsumer = session.createConsumer(mqConfig.getDestination());
            mqConfig.startDelivery();
            TextMessage message = (TextMessage) messageConsumer.receive();
            String data = message.getText();

            System.out.println("Recieved message from the producer " + data);
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
    public void run() {
        recieveMessage();
    }
}
