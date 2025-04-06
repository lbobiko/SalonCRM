public class Service {
    private String name;
    private int durationMinutes;
    private double price;

    public Service(String name, int durationMinutes, double price) {
        this.name = name;
        this.durationMinutes = durationMinutes;
        this.price = price;
    }

    @Override
    public String toString() {
        return name + " (" + durationMinutes + " min) – " + price + " zł";
    }

    public String getName() { return name; }
}
