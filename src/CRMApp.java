import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class CRMApp {
    private List<Client> clients;
    private Scanner scanner;

    public CRMApp() {
        clients = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        String choice;
        do {
            System.out.println("1. Dodaj klienta");
            System.out.println("2. Wyświetl klientów");
            System.out.println("3. Usuń klienta");
            System.out.println("4. Edytuj klienta");
            System.out.println("5. Wyświetl raport");
            System.out.println("6. Zapisz raport do pliku");
            System.out.println("7. Wyświetl przypomnienia");
            System.out.println("0. Wyjdź");
            System.out.print("Wybierz opcję: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1" -> addClient();
                case "2" -> displayClients();
                case "3" -> removeClient();
                case "4" -> editClient();
                case "5" -> displayReport();
                case "6" -> saveReportToFile();
                case "7" -> showReminders();
            }
        } while (!choice.equals("0"));
    }

    private void addClient() {
        System.out.print("Imię klienta: ");
        String name = scanner.nextLine();
        System.out.print("Telefon klienta: ");
        String phone = scanner.nextLine();
        System.out.print("Email klienta: ");
        String email = scanner.nextLine();
        System.out.print("Co klientka lubi / preferencje (np. delikatne zapachy): ");
        String preferences = scanner.nextLine();
        System.out.print("Data przypomnienia o wizycie (RRRR-MM-DD) lub Enter, jeśli brak: ");
        String reminder = scanner.nextLine();
        Client newClient = new Client(name, phone, email, preferences);
        if (!reminder.isEmpty()) {
            try {
                LocalDate reminderDate = LocalDate.parse(reminder);
                newClient.setNextVisitReminder(reminderDate);
            } catch (Exception e) {
                System.out.println("Błędny format daty, przypomnienie nie zostało ustawione.");
            }
        }
        clients.add(newClient);
    }

    private void showReminders() {
        System.out.println("=== Przypomnienia ===");
        for (Client c : clients) {
            System.out.println(c.getReminderInfo());
        }
    }

    private void saveReportToFile() {
        try {
            PrintWriter writer = new PrintWriter("raport_klientek.txt");
            for (Client c : clients) {
                writer.println(c.getReport());
                writer.println();
            }
            writer.close();
            System.out.println("Raport zapisany jako 'raport_klientek.txt'.");
        } catch (Exception e) {
            System.out.println("Błąd podczas zapisu pliku: " + e.getMessage());
        }
    }

    private void displayClients() {
        if (clients.isEmpty()) {
            System.out.println("Brak klientek.");
        } else {
            for (Client c : clients) {
                System.out.println(c);
            }
        }
    }

    private void removeClient() {
        displayClients();
        System.out.print("Podaj numer klientki do usunięcia: ");
        int index = Integer.parseInt(scanner.nextLine());
        if (index >= 0 && index < clients.size()) {
            clients.remove(index);
            System.out.println("Klientka usunięta.");
        } else {
            System.out.println("Nieprawidłowy numer.");
        }
    }

    private void editClient() {
        System.out.println("Edytowanie niezaimplementowane.");
    }

    private void displayReport() {
        for (Client c : clients) {
            System.out.println(c.getReport());
            System.out.println();
        }
    }
}
