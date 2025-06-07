import java.io.*;
import java.util.*;

public class ZomatoSearchSort {
    public static void main(String[] args) {
        List<Restaurant> restaurants = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("data/ZomatoDataset.csv"))) {
            String line = br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                // Pisahkan kolom CSV
                String[] data = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

                if (data.length > 17) {
                    try {
                        String name = data[1].trim();
                        String onlineOrder = data[10].trim();
                        String bookTable = data[9].trim();
                        String rate = data[14].trim();
                        int votes = Integer.parseInt(data[12].trim().isEmpty() ? "0" : data[12].trim());
                        int approxCost = Integer.parseInt(data[11].trim().isEmpty() ? "0" : data[11].trim().replaceAll("[^\\d]", ""));
                        String listedIn = data[17].trim();
                        String city = data[4].trim();
                        double rating = Double.parseDouble(data[14].trim().isEmpty() ? "0" : data[14].trim());

                        // Buat objek Restaurant
                        restaurants.add(new Restaurant(name, onlineOrder, bookTable, rate, votes, approxCost, listedIn, city, rating));

                    } catch (NumberFormatException e) {
                        continue; // Jika ada angka yang error, skip
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Gagal membaca file: " + e.getMessage());
            return;
        }

        // 🔍 PENCARIAN: Nama restoran
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nMasukkan nama restoran yang ingin dicari: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        for (Restaurant r : restaurants) {
            if (r.getName().toLowerCase().contains(keyword)) {
                System.out.println("Ditemukan: " + r);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Restoran tidak ditemukan.");
        }

        // 🔽 PENGURUTAN: Bubble Sort berdasarkan rating
        for (int i = 0; i < restaurants.size() - 1; i++) {
            for (int j = 0; j < restaurants.size() - i - 1; j++) {
                if (restaurants.get(j).getRating() < restaurants.get(j + 1).getRating()) {
                    Restaurant temp = restaurants.get(j);
                    restaurants.set(j, restaurants.get(j + 1));
                    restaurants.set(j + 1, temp);
                }
            }
        }

        // 🔝 Tampilkan 10 restoran rating tertinggi
        System.out.println("\nTop 10 Restoran dengan Rating Tertinggi:");
        for (int i = 0; i < Math.min(10, restaurants.size()); i++) {
            System.out.println((i + 1) + ". " + restaurants.get(i));
        }
    }
}
