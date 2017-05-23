package domein;

import exception.InformationRequiredException;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class AppointmentBuilder {

    protected Appointment appointment;

    protected Set<RequiredElement> requiredElements;

    public void buildAppointment() {
        appointment = new Appointment();
    }

    /**
     *
     * @param startDate
     * @param endDate
     */
    public void buildDates(GregorianCalendar startDate, GregorianCalendar endDate) {
        GregorianCalendar currentDate = new GregorianCalendar();
        if (startDate != null && startDate.after(currentDate)) {
            appointment.setStartDate(startDate);
        }

        if (endDate != null && endDate.after(appointment.getStartDate())) {
            appointment.setEndDate(endDate);
        } else {
            appointment.setEndDate(startDate);
        }
    }

    /**
     *
     * @param description
     */
    public void buildDescription(String description) {
        appointment.setDescription(description);
    }

    /**
     *
     * @param loc
     */
    public void buildLocation(Location loc) {
        appointment.setLocation(loc);
    }

    /**
     *
     * @param attendeed
     */
    public void buildAttendees(List<Contact> attendeed) {
        appointment.setAttendees(attendeed);
    }

    public Appointment getAppointment() throws InformationRequiredException {
        requiredElements = new HashSet<>();

        if (Objects.isNull(appointment.getStartDate())) {
            requiredElements.add(RequiredElement.StartDateRequired);
        }

        if (Objects.isNull(appointment.getLocation())) {
            requiredElements.add(RequiredElement.LocationRequired);
        }

        if (appointment.getAttendees().isEmpty()) {
            requiredElements.add(RequiredElement.AttendeeRequired);
        }

        if (!requiredElements.isEmpty()) {
            throw new InformationRequiredException(requiredElements);
        }

        return appointment;
    }
}
