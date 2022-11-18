package org.example;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MQConfig {
    private Destination destination =null;
    private Session session = null;
    private Connection connection= null;

    public void Configuration() throws JMSException {
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnectionFactory.DEFAULT_BROKER_URL);
        connection = connectionFactory.createConnection();
        setConnection(connection);
        session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        setSession(session);
        destination = session.createQueue("testJMS");
        setDestination(destination);
    }

    private void setConnection(Connection connection) {
        this.connection = connection;
    }

    private void setSession(Session session) {
        this.session = session;
    }

    public Session getSession() {
        return session;
    }

    public Destination getDestination() {
        return destination;
    }
    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public void startDelivery() throws JMSException {
        connection.start();
    }
}
