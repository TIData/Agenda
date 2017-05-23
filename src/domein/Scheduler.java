package domein;

import exception.InformationRequiredException;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author sebastiaan
 */
public class Scheduler {

    public Appointment createAppointment(AppointmentBuilder builder,
            GregorianCalendar startDate, GregorianCalendar endDate,
            String description, Location location, List<Contact> attendees)
            throws InformationRequiredException {
        
        if(Objects.isNull(builder)) {
            builder = new AppointmentBuilder();
        }
        
        builder.buildAppointment();
        
        builder.buildDates(startDate, endDate);
        builder.buildDescription(description);
        builder.buildAttendees(attendees);
        builder.buildLocation(location);
        
        return builder.getAppointment();
    }
}
