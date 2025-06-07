import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FilterZomato {
    public static void main(String[] args) {
        String csvFile = "data/ZomatoDataset.csv"; // File path sesuai permintaan
        String line;
        String splitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            // Baca header
            String header = br.readLine();
            System.out.println("Restoran dengan rating > 4.0 dan tersedia online order:");
            System.out.println("----------------------------------------------------------");

            while ((line = br.readLine()) != null) {
                String[] data = line.split(splitBy, -1); // -1 agar semua kolom dibaca, termasuk yang kosong

                if (data.length >= 7) {
                    try {
                        String name = data[0].trim();
                        String onlineOrder = data[1].trim();
                        String rateStr = data[3].trim();
                        double rating = 0.0;

                        // Ambil angka dari format seperti "4.1/5"
                        if (!rateStr.isEmpty() && rateStr.contains("/")) {
                            rating = Double.parseDouble(rateStr.split("/")[0]);
                        }

                        // Filter: Online order Yes dan rating > 4.0
                        if (onlineOrder.equalsIgnoreCase("Yes") && rating > 4.0) {
                            System.out.println("Nama: " + name + " | Rating: " + rating);
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Format angka salah pada baris: " + line);
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Terjadi kesalahan saat membaca file: " + e.getMessage());
        }
    }
}