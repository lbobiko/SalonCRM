public class Client {
    private String name;
    private String phone;
    private String email;

    public Client(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " | Tel: " + phone + " | Email: " + email;
    }
}
