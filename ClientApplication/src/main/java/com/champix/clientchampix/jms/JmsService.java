package com.champix.clientchampix.jms;

import javax.jms.*;
import javax.naming.NamingException;
import java.io.Serializable;

public class JmsService {

    public JmsService () {
    }

    public void sendMessage(Serializable messageToSend, TopicConnectionFactory topicConnectionFactory, Topic topic) throws JMSException, NamingException {
        try {

            TopicConnection connection = topicConnectionFactory.createTopicConnection();
            connection.start();

            TopicSession topicSession = connection.createTopicSession(false, Session.AUTO_ACKNOWLEDGE);

            TopicPublisher producer = topicSession.createPublisher(topic);

            ObjectMessage message = topicSession.createObjectMessage();
            message.setObject(messageToSend);
            // On publie le message
            producer.publish(message);

            // FULL CLOSE
            producer.close();
            topicSession.close();
            connection.close();

        } catch (JMSException e) {

            e.printStackTrace();
        }
    }
}
