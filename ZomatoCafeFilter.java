import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ZomatoCafeFilter {
    public static void main(String[] args) {
        String filePath = "data/ZomatoDataset.csv";
        String line;
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String header = br.readLine();
            if (header == null) {
                System.out.println("File kosong!");
                return;
            }

            System.out.println("Restoran tipe Café dengan biaya < 300:");
            System.out.println(header);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy, -1);

                try {
                    String costStr = data[5].replaceAll(",", "").trim(); // approx_cost
                    int cost = Integer.parseInt(costStr);
                    String type = data[6].trim();

                    if (cost < 300 && type.equalsIgnoreCase("Cafes")) {
                        System.out.println(line);
                    }
                } catch (Exception e) {
                    continue;
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }
}
