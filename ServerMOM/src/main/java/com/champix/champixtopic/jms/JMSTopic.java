package com.champix.champixtopic.jms;

import com.champix.champixtopic.domains.ReservationEntity;
import com.champix.champixtopic.dto.ReservationDTO;
import com.champix.champixtopic.repositories.ReservationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Autowired
    ReservationEntityRepository reservationEntityRepository;

    @Override
    public void onMessage(Message message) {

        try {
            ReservationDTO reservationDTO = (ReservationDTO) ((ObjectMessage) message).getObject();

            if (!validateReservationDTO(reservationDTO)) return;

            // ReservationDTO to ReservationEntity
            ReservationEntity reservationEntity = new ReservationEntity();
            reservationEntity.setClient(reservationDTO.getIdClient());
            reservationEntity.setDateEcheance(new Timestamp(reservationDTO.getDateEcheance().getTime()));
            reservationEntity.setVehicule(reservationDTO.getIdVehicule());
            reservationEntity.setDateReservation(new Timestamp(reservationDTO.getDateReservation().getTime()));

            if (!validateReservationEntity(reservationEntity)) return;

            reservationEntityRepository.save(reservationEntity);

        } catch (JMSException jmsException) {

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
    private boolean validateReservationEntity (ReservationEntity reservationEntity) {

        // Test both are not present
        return !reservationEntityRepository.findByClientAndDateReservation(reservationEntity.getClient(), reservationEntity.getDateReservation()).isPresent() &&
                !reservationEntityRepository.findByVehiculeAndDateReservation(reservationEntity.getVehicule(), reservationEntity.getDateReservation()).isPresent();
    }
}
