public class Restaurant {
    private String name;
    private String onlineOrder;
    private String bookTable;
    private String rate;
    private String city;
    private double rating;
    private int votes;
    private int approxCost;
    private String listedIn;

    public Restaurant(String name, String onlineOrder, String bookTable, String rate, int votes, int approxCost, String listedIn, String city, double rating) {
        this.name = name;
        this.onlineOrder = onlineOrder;
        this.bookTable = bookTable;
        this.rate = rate;
        this.votes = votes;
        this.approxCost = approxCost;
        this.listedIn = listedIn;
        this.city = city;
        this.rating = rating;
    }
    // Getter
    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public double getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", onlineOrder='" + onlineOrder + '\'' +
                ", bookTable='" + bookTable + '\'' +
                ", rate='" + rate + '\'' +
                ", votes=" + votes +
                ", approxCost=" + approxCost +
                ", listedIn='" + listedIn + '\'' +
                '}';
    }
}