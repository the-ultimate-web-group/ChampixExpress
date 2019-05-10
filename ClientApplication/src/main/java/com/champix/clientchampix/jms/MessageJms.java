package com.champix.clientchampix.jms;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.NamingException;
import javax.xml.soap.Text;
import java.util.logging.Logger;

public class MessageJms {
    private static final Logger log = Logger
            .getLogger(MessageJms.class.getName());

    // Set up all the default values

    private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
    private static final String DEFAULT_DESTINATION = "java:jms/queue/FileMessages";

    private static final String DEFAULT_USERNAME = "jmsuser";
    private static final String DEFAULT_PASSWORD = "jmsepul98!";

    private Connection connection;
    private Context ctxt;

    public void sendMessage(String stringMessage) throws JMSException, NamingException {
        TextMessage message;
        try {
            ctxt = JBossContext.getInitialContext();
            String connectionFactoryString = System.getProperty(
                    "connection.factory", DEFAULT_CONNECTION_FACTORY);
            log.info("Attempting to acquire connection factory \""
                    + connectionFactoryString + "\"");
            ConnectionFactory connectionFactory = (ConnectionFactory) ctxt
                    .lookup(connectionFactoryString);
            log.info("Found connection factory \"" + connectionFactoryString
                    + "\" in JNDI");

            // Destination
            String destinationString = System.getProperty("destination",
                    DEFAULT_DESTINATION);
            log.info("Attempting to acquire destination \"" + destinationString
                    + "\"");
            Destination destination = (Destination) ctxt.lookup(destinationString);
            log.info("Found destination \"" + destinationString + "\" in JNDI");

            // On crée la connexion JMS , session, producteur et message;
            connection = connectionFactory.createConnection(
                    System.getProperty("username", DEFAULT_USERNAME),
                    System.getProperty("password", DEFAULT_PASSWORD));
            System.out.println("Session ouverte ! ");
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producteur = session.createProducer(destination);
            message = session.createTextMessage();
            connection.start();
            producteur.send(message);
        } catch (Exception e) {
            log.severe(e.getMessage());
            throw e;
        } finally {
            if (ctxt != null) {
                ctxt.close();
            }

            // closing the connection takes care of the session, producer, and
            // consumer
            if (connection != null) {
                connection.close();
            }
        }
    }
}
