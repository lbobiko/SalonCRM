import java.time.LocalDateTime;

public class Appointment {
    private Client client;
    private Service service;
    private LocalDateTime dateTime;

    public Appointment(Client client, Service service, LocalDateTime dateTime) {
        this.client = client;
        this.service = service;
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return dateTime + " – " + client.getName() + " – " + service.getName();
    }
}
