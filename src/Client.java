import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private String phone;
    private String email;
    private String preferences; // co klientka lubi
    private List<String> visitHistory;
    private LocalDate nextVisitReminder;

    public Client(String name, String phone, String email, String preferences) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.preferences = preferences;
        this.visitHistory = new ArrayList<>();
        this.nextVisitReminder = null;
    }

    @Override
    public String toString() {
        return name + " | Tel: " + phone + " | Email: " + email + " | Lubi: " + preferences;
    }

    public String getReport() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Klientka: ").append(name).append(" ===\n");
        sb.append("Telefon: ").append(phone).append("\n");
        sb.append("Email: ").append(email).append("\n");
        sb.append("Preferencje: ").append(preferences).append("\n");
        sb.append("Historia wizyt:\n");
        if (visitHistory.isEmpty()) {
            sb.append("  (brak wizyt)\n");
        } else {
            for (String h : visitHistory) {
                sb.append("  - ").append(h).append("\n");
            }
        }
        return sb.toString();
    }

    public void setNextVisitReminder(LocalDate date) {
        this.nextVisitReminder = date;
    }

    public String getReminderInfo() {
        if (nextVisitReminder == null) return name + ": brak przypomnienia.";
        return name + " – przypomnienie o wizycie: " + nextVisitReminder;
    }

    public String getName() {
        return name;
    }
}
