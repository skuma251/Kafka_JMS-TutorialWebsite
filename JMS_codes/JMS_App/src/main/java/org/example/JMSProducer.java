package org.example;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JMSProducer implements Runnable {

    private String information;

    public JMSProducer(String information) {
        this.information = information;
    }

    public void sendMessage() throws JMSException {
        MQConfig mqConfig = new MQConfig();
        mqConfig.Configuration();
        Session session = mqConfig.getSession();
        MessageProducer messageProducer = session.createProducer(mqConfig.getDestination());
        TextMessage textMessage = session.createTextMessage();
        textMessage.setText(information);
        messageProducer.send(textMessage);
    }
    public void run() {
        try {
            sendMessage();
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
