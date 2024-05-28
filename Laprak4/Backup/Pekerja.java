package Laprak4.Backup;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Pekerja extends Manusia {
    public double gaji, bonus;
    public int jumlahAnak;
    public int tahunMasuk, tahunNow = getCurrentYear();

    public Pekerja(double gaji, int tahun, int bulan, int hari, int anak, String nama, String nik, boolean gender,
            boolean status) {
        super(nama, nik, gender, status);
        this.gaji = gaji;
        this.tahunMasuk = tahun;
        this.jumlahAnak = anak;
    }

    public int getCurrentYear() {
        return LocalDate.now().getYear();
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
        long years = ChronoUnit.YEARS.between(LocalDate.of(tahunMasuk, 1, 1), LocalDate.now());
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
