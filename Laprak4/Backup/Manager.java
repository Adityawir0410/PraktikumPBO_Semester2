package Laprak4.Backup;

public class Manager extends Pekerja {
    public String departemen;

    public Manager(String departemen, double gaji, int tahun, int bulan, int hari, int anak, String na, String ni, boolean kel, boolean menikah) {
        super(gaji, tahun, bulan, hari, anak, na, ni, kel, menikah);
        this.departemen = departemen;
    }

    public double getTunjangan() {
        super.getTunjangan();
        tunjangan += (gaji * 0.1);
        return tunjangan;
    }

    public String toString() {
        super.toString();
        System.out.println("Departemen    : " + departemen);
        String dummy = "";
        return dummy;
    }
}
