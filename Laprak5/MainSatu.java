package Laprak5;

abstract class Kue {
    protected String nama;
    protected double harga;

    public Kue(String nama, double harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public abstract double hitungHarga();

    @Override
    public String toString() {
        return "Nama Kue: " + nama + "\nHarga Kue: " + harga;
    }
}

class KuePesanan extends Kue {
    public double berat;

    public KuePesanan(String nama, double harga, double berat) {
        super(nama, harga);
        this.berat = berat;
    }

    @Override
    public double hitungHarga() {
        return harga * berat;
    }

    @Override
    public String toString() {
        return "Nama Kue: " + nama + "\nHarga Kue: " + harga + "\nBerat Kue: " + berat;
    }
}

class KueJadi extends Kue {
    public double jumlah;

    public KueJadi(String nama, double harga, double jumlah) {
        super(nama, harga);
        this.jumlah = jumlah;
    }

    @Override
    public double hitungHarga() {
        return harga * jumlah * 2;
    }

    @Override
    public String toString() {
        return "Nama Kue: " + nama + "\nHarga Kue: " + harga + "\nJumlah Kue: " + jumlah;
    }
}

public class MainSatu {
    public static void main(String[] args) {

        Kue[] kues = new Kue[20];

        kues[0] = new KuePesanan("Kue Bolu", 20.0, 1.5);
        kues[1] = new KueJadi("Kue Lapis", 25.0, 2.0);
        kues[2] = new KuePesanan("Kue Tart", 30.0, 2.0);
        kues[3] = new KueJadi("Kue Cubit", 15.0, 3.0);
        kues[4] = new KuePesanan("Kue Brownies", 18.0, 1.2);
        kues[5] = new KueJadi("Kue Nastar", 22.0, 2.5);
        kues[6] = new KuePesanan("Kue Kastengel", 25.0, 1.8);
        kues[7] = new KueJadi("Kue Putri Salju", 20.0, 2.7);
        kues[8] = new KuePesanan("Kue Macaroon", 28.0, 1.0);
        kues[9] = new KueJadi("Kue Semprit", 18.0, 3.0);
        kues[10] = new KuePesanan("Kue Lidah Kucing", 22.0, 1.5);
        kues[11] = new KueJadi("Kue Kering Coklat", 24.0, 2.2);
        kues[12] = new KuePesanan("Kue Sagu Keju", 20.0, 1.8);
        kues[13] = new KueJadi("Kue Putri Ayu", 26.0, 2.5);
        kues[14] = new KuePesanan("Kue Lapis Legit", 35.0, 2.0);
        kues[15] = new KueJadi("Kue Lumpia", 18.0, 3.5);
        kues[16] = new KuePesanan("Kue Kering Nanas", 22.0, 1.3);
        kues[17] = new KueJadi("Kue Mooncake", 30.0, 2.0);
        kues[18] = new KuePesanan("Kue Putri Salju", 25.0, 1.7);
        kues[19] = new KueJadi("Kue Nastar Keju", 28.0, 2.8);

        System.out.println("====== Kue Pesanan ======");
        double totalHargaKuePesanan = 0;
        double totalBeratKuePesanan = 0;
        for (Kue kue : kues) {
            if (kue instanceof KuePesanan) {
                System.out.println(kue);
                double totalHarga = kue.hitungHarga();
                System.out.println("Total Harga: " + totalHarga);
                System.out.println("Jenis Kue: " + kue.getClass().getSimpleName());
                System.out.println();
                totalHargaKuePesanan += totalHarga;
                totalBeratKuePesanan += ((KuePesanan) kue).berat;
            }
        }

        System.out.println("====== Kue Jadi ======");
        double totalHargaKueJadi = 0;
        double totalJumlahKueJadi = 0;
        for (Kue kue : kues) {
            if (kue instanceof KueJadi) {
                System.out.println(kue);
                double totalHarga = kue.hitungHarga();
                System.out.println("Total Harga: " + totalHarga);
                System.out.println("Jenis Kue: " + kue.getClass().getSimpleName());
                System.out.println();
                totalHargaKueJadi += totalHarga;
                totalJumlahKueJadi += ((KueJadi) kue).jumlah;
            }
        }

        System.out.println("====== Hasil ======");
        double totalHarga = totalHargaKuePesanan + totalHargaKueJadi;
        System.out.println("Total Harga Kue: " + formatDouble(totalHarga));
        System.out.println("Total Harga Kue Pesanan: " + formatDouble(totalHargaKuePesanan));
        System.out.println("Total Berat Kue Pesanan: " + totalBeratKuePesanan);
        System.out.println("Total Harga Kue Jadi: " + formatDouble(totalHargaKueJadi));
        System.out.println("Total Jumlah Kue Jadi: " + totalJumlahKueJadi);
        System.out.println("Kue Termahal: " + getKueTermahal(kues));
    }

    private static String formatDouble(double value) {
        return String.format("%.2f", value);
    }

    private static Kue getKueTermahal(Kue[] kues) {
        Kue kueTermahal = kues[0];
        for (Kue kue : kues) {
            if (kue.hitungHarga() > kueTermahal.hitungHarga()) {
                kueTermahal = kue;
            }
        }
        return kueTermahal;
    }
}