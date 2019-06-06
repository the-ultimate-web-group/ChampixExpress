package com.champix.champixtopic.jms;

import com.champix.champixtopic.domains.ReservationEntity;
import com.champix.champixtopic.service.ReservationService;
import com.champix.dto.ReservationDTO;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;
import java.sql.Timestamp;

@MessageDriven(activationConfig = {
        @ActivationConfigProperty(propertyName = "destination", propertyValue = "java:jboss/exported/topic/ChampixTopic"),
        @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")},
        mappedName = "ChampixTopic")
public class JMSTopic implements MessageListener {


    public void onMessage(Message message) {

        try {
            ObjectMessage objMessage = (ObjectMessage) message;

            ReservationDTO reservationDTO = (ReservationDTO) objMessage.getObject();

            if (!validateReservationDTO(reservationDTO)) return;

            // ReservationDTO to ReservationEntity
            ReservationEntity reservationEntity = new ReservationEntity();
            reservationEntity.setClient(reservationDTO.getIdClient());
            reservationEntity.setDateEcheance(new Timestamp(reservationDTO.getDateEcheance().getTime()));
            reservationEntity.setVehicule(reservationDTO.getIdVehicule());
            reservationEntity.setDateReservation(new Timestamp(reservationDTO.getDateReservation().getTime()));

            ReservationService.getInstance().save(reservationEntity);

        } catch (JMSException jmsException) {
            jmsException.printStackTrace();
        } catch (ClassCastException cce) {
            cce.printStackTrace();
        }
    }

    /***
     * Only verify each var not null (others are int -> not null)
     * @param reservationDTO
     * @return boolean (true if(valid) else false)
     */
    private boolean validateReservationDTO (ReservationDTO reservationDTO) {

        return reservationDTO.getDateEcheance() != null && reservationDTO.getDateReservation() != null;
    }

    /***
     * Verify this car is not already reserved and this client did'nt reserve another car at the same time.
     * @param reservationEntity
     * @return boolean (true if(valid) else false)
     */
}
