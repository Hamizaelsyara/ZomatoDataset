import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ZomatoOnlineOrderFilter {
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

            System.out.println("Restoran yang menerima online order dan rating > 4.0:");
            System.out.println(header);

            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy, -1);

                try {
                    String onlineOrder = data[1];  // Kolom 'online_order'
                    String rate = data[4];         // Kolom 'rate'

                    if (onlineOrder.equalsIgnoreCase("Yes") && !rate.equals("NEW") && !rate.equals("-")) {
                        double rating = Double.parseDouble(rate.split("/")[0]);
                        if (rating > 4.0) {
                            System.out.println(line);
                        }
                    }
                } catch (Exception e) {
                    continue; // Lewati data yang rusak
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
        }
    }
}
