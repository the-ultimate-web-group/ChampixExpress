package com.champix.servermom.jms;

import com.champix.servermom.domains.ReservationEntity;
import com.champix.servermom.dto.ReservationDTO;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/topic/ChampixTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")},
        mappedName = "ChampixTopic")
public class JMSQueue implements MessageListener {

    @Override
    public void onMessage(Message message) {

        try {
            ReservationDTO reservationEntity = (ReservationDTO) ((ObjectMessage) message).getObject();


        } catch (JMSException jmsException) {

        }
    }
}
