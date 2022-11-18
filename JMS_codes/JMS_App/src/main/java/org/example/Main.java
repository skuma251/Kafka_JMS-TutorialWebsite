package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Enter the message you need to send");
        Scanner sc = new Scanner(System.in);
        String data = sc.nextLine();

        JMSProducer jmsProducer = new JMSProducer(data);
        Thread messageProducer = new Thread(jmsProducer);
        messageProducer.run();

        System.out.println("Your message was sent and is ready to be consumed.");
        System.out.println("Please check the queue, the message should be there in pending message!");

        Thread.sleep(10000);

        JMSConsumer jmsConsumer = new JMSConsumer();
        Thread messageReciever = new Thread(jmsConsumer);
        messageReciever.run();
    }
}