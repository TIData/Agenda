package domein;

import java.util.GregorianCalendar;
import java.util.List;

public class AppointmentBuilder {

    protected Appointment appointment;

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

    public Appointment getAppointment() {
        return this.appointment;
    }
}
