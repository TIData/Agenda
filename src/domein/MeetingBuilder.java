
package domein;

import exception.InformationRequiredException;
import java.util.Objects;

/**
 *
 * @author sebastiaan
 */
public class MeetingBuilder extends AppointmentBuilder {

    @Override
    public Appointment getAppointment() throws InformationRequiredException {
        try {
            appointment = super.getAppointment();
        } finally {
            if(Objects.isNull(appointment.getEndDate())) {
                requiredElements.add(RequiredElement.EndDateRequired);
            }
            
            if(!requiredElements.isEmpty()) {
                throw new InformationRequiredException(requiredElements);
            }
        }
        
        return appointment;
    }
}
