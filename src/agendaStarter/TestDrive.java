package agendaStarter;

import java.util.*;
import domein.*;
import exception.InformationRequiredException;

public class TestDrive {

    private Contact contactData[] = new Contact[] {
       new Contact("Bram", "Oosterlynck", "Dhr.", "HoGent")
    };
    private Appointment appt;
    private Scheduler pimScheduler = new Scheduler();

    /**
     * TODO attribut(en) voor aanmaak van een appointment
     *
     *
     *
     *
     * End TODO attribut(en)
     *
     * @param args
     */
    public static void main(String[] args) {
        new TestDrive().run();
    }

    /**
     *
     * @param numberToCreate
     */
    private List<Contact> createAttendees(int numberToCreate) {
        List<Contact> group = new ArrayList<>();
        for (int i = 0; i < numberToCreate; i++) {
            group.add(getContact(i));
        }

        return group;
    }

    /**
     *
     * @param index
     */
    private Contact getContact(int index) {
        return contactData[index % contactData.length];
    }

    private void run() {
        System.out.println("Creating an Appointment");
        AppointmentBuilder apptBuilder = new AppointmentBuilder();
        try {
            appt = pimScheduler.createAppointment(apptBuilder,
                    new GregorianCalendar(2017, 7, 22, 12, 30), null, "Project Demo", new Location("Hogeschool Gent, D2.014"), createAttendees(4));

        } catch (InformationRequiredException ex) {
            printExceptions(ex);
        }
    }

    private void printExceptions(InformationRequiredException ex) {
        Set<RequiredElement> requiredItems = ex.getInformationRequired();

        System.out.println("Unable to create Appointment: additional information is required");
        requiredItems.forEach(item -> System.out.printf("%s\n\n", item.toString()));
    }

}
