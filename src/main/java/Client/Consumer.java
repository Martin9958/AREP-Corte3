package Client;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class Consumer implements Runnable, ExceptionListener {

    public static void main(String[] args){
        Consumer consumer = new Consumer();
        consumer.run();
    }

    public void run() {
        try {

            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                    "tcp://ec2-18-222-123-4.us-east-2.compute.amazonaws.com:61616?jms.useAsyncSend=true");
            Connection connection = connectionFactory.createConnection("smx", "smx");
            connection.start();

            connection.setExceptionListener(this);

            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

            Destination destination = session.createQueue("events");

            MessageConsumer consumer = session.createConsumer(destination);

            Message message = consumer.receive(1000);

            if (message instanceof TextMessage) {
                TextMessage textMessage = (TextMessage) message;
                String text = textMessage.getText();
                System.out.println("Received: " + text);
            } else {
                System.out.println("Received: " + message);
            }

            consumer.close();
            session.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Caught: " + e);
            e.printStackTrace();
        }
    }

    public synchronized void onException(JMSException ex) {
        System.out.println("JMS Exception occured.  Shutting down client.");
    }
}

