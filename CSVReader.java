import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public List<Restaurant> readCSV(String filePath) {
        List<Restaurant> restaurants = new ArrayList<>();
        String line;
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            // Skip header
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                String name = data[0];
                String onlineOrder = data[1];
                String bookTable = data[2];
                String rate = data[3];
                String city = data[7];
                double rating = Double.parseDouble(data[8]);
                int votes = Integer.parseInt(data[4]);
                int approxCost = Integer.parseInt(data[5]);
                String listedIn = data[6];

                Restaurant restaurant = new Restaurant(name, onlineOrder, bookTable, rate, votes, approxCost, listedIn, city, rating);
                restaurants.add(restaurant);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return restaurants;
    }
}