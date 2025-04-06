import java.util.*;
import java.time.LocalDateTime;

public class CRMApp {
    private List<Client> clients = new ArrayList<>();
    private List<Service> services = new ArrayList<>();
    private List<Appointment> appointments = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("\n=== Salon Kosmetyczny CRM ===");
            System.out.println("1. Dodaj klientkę");
            System.out.println("2. Dodaj usługę");
            System.out.println("3. Umów wizytę");
            System.out.println("4. Pokaż wizyty");
            System.out.println("0. Wyjście");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addClient();
                case "2" -> addService();
                case "3" -> addAppointment();
                case "4" -> showAppointments();
                case "0" -> System.exit(0);
                default -> System.out.println("Nieznana opcja.");
            }
        }
    }

    private void addClient() {
        System.out.print("Imię i nazwisko: ");
        String name = scanner.nextLine();
        System.out.print("Telefon: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        clients.add(new Client(name, phone, email));
        System.out.println("Dodano klientkę.");
    }

    private void addService() {
        System.out.print("Nazwa usługi: ");
        String name = scanner.nextLine();
        System.out.print("Czas trwania (minuty): ");
        int duration = Integer.parseInt(scanner.nextLine());
        System.out.print("Cena (zł): ");
        double price = Double.parseDouble(scanner.nextLine());
        services.add(new Service(name, duration, price));
        System.out.println("Dodano usługę.");
    }

    private void addAppointment() {
        if (clients.isEmpty() || services.isEmpty()) {
            System.out.println("Dodaj najpierw klientkę i usługę.");
            return;
        }

        System.out.println("Wybierz klientkę:");
        for (int i = 0; i < clients.size(); i++) {
            System.out.println((i+1) + ". " + clients.get(i));
        }
        int clientIndex = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.println("Wybierz usługę:");
        for (int i = 0; i < services.size(); i++) {
            System.out.println((i+1) + ". " + services.get(i));
        }
        int serviceIndex = Integer.parseInt(scanner.nextLine()) - 1;

        System.out.print("Podaj datę i godzinę (YYYY-MM-DDTHH:MM): ");
        LocalDateTime dateTime = LocalDateTime.parse(scanner.nextLine());

        appointments.add(new Appointment(clients.get(clientIndex), services.get(serviceIndex), dateTime));
        System.out.println("Wizyta dodana.");
    }

    private void showAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("Brak wizyt.");
        } else {
            for (Appointment a : appointments) {
                System.out.println(a);
            }
        }
    }
}
