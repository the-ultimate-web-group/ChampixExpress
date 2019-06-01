package com.champix.clientchampix.jms;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;
import java.io.Serializable;
import java.util.logging.Logger;

public class JmsService {
    private static final Logger log = Logger
            .getLogger(JmsService.class.getName());

    // Set up all the default values

    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    private static final String DEFAULT_DESTINATION = "java:jms/queue/FileMessages";

    private static final String DEFAULT_USERNAME = "jmsuser";
    private static final String DEFAULT_PASSWORD = "jmsepul98!";

    private Context ctxt;


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
