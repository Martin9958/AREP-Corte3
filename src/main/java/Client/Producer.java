package Client;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.*;

public class Producer {

    public static void main(String[] args){
        Producer producer = new Producer();
        producer.run();
    }

    public void run(){
        CamelContext context = new DefaultCamelContext();
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "tcp://ec2-18-222-123-4.us-east-2.compute.amazonaws.com:61616?jms.useAsyncSend=true");
        try{
            Connection connection = connectionFactory.createConnection("smx","smx");
            connection.start();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue("events");
            MessageProducer messageProducer = session.createProducer(destination);
            messageProducer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
            String text = "Hello world! From: " + Thread.currentThread().getName() +
                    ": " + this.hashCode();
            TextMessage message = session.createTextMessage(text);
            System.out.println("Sent Message: " + message.hashCode() + ": " +
                    Thread.currentThread().getName());
            messageProducer.send(message);
        }catch(Exception e){
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }
}
