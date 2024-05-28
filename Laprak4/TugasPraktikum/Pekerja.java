package Laprak4.TugasPraktikum;
public class Pekerja extends Manusia {
    public double gaji, bonus;
    public int jumlahAnak;
    public int tahunMasuk, tahunNow = getCurrentYear();

    public Pekerja(double gaji, int tahun, int bulan, int hari, int anak, String na, String ni, boolean kel, boolean menikah) {
        super(na, ni, kel, menikah);
        this.gaji = gaji;
        this.tahunMasuk = tahun;
        this.jumlahAnak = anak;
    }

    public int getCurrentYear() {
        long millis = System.currentTimeMillis();
        return (int) (millis / (1000L * 60 * 60 * 24 * 365)) + 1970;
    }

    public double getGaji() {
        return hitungGajiTotal();
    }
    
    private double hitungGajiTotal() {
        gaji = gaji + getBonus();
        return gaji;
    }

    public double getBonus() {
        return hitungBonusBerdasarkanTahun();
    }
    
    private double hitungBonusBerdasarkanTahun() {
        int years = tahunNow - tahunMasuk;
        if (years > 0 && years <= 5) {
            bonus += (gaji * 0.05);
        }
        if (years > 5 && years < 10) {
            bonus += (gaji * 0.1);
        }
        if (years >= 10) {
            bonus += (gaji * 0.15);
        }
        return bonus;
    }

    public double getTunjangan() {
        return hitungTunjanganTotal();
    }
    
    private double hitungTunjanganTotal() {
        super.getTunjangan();
        tunjangan += 20 * jumlahAnak;
        return tunjangan;
    }

    @Override
    public double getPendapatan() {
        tambahPendapatan();
        return pendapatan;
    }

    private void tambahPendapatan() {
        pendapatan += getGaji() + getTunjangan();
    }

    public String toString() {
        printDetails();
        String dummy = "\n";
        return dummy;
    }
    
    private void printDetails() {
        super.toString();
        System.out.println("Tahun Masuk   : " + tahunMasuk);
        System.out.println("Jumlah Anak   : " + jumlahAnak);
        System.out.println("Gaji          : " + getGaji());
    }
}
