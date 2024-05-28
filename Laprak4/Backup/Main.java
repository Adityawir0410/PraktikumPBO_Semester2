package Laprak4.Backup;


public class Main {
    public static void main(String[] args) {
        printHuman(new Manusia("A", "3827", true, true));
        printHuman(new Manusia("B", "8403", false, true));
        printHuman(new Manusia("C", "2503", false, false));
        printMahasiswaFILKOM(new Mahasiswa("235150407111094", 3.0, "Kurniawan Gemink", "82392", true, false));
        printMahasiswaFILKOM(new Mahasiswa("235150507111038", 3.1, "Hidayat Balap", "82340", true, false));
        printMahasiswaFILKOM(new Mahasiswa("235150207111067", 4, "Michel", "23943", false, false));
        printPekerja(new Pekerja(500, 2003, 3, 3, 2, "Slamet Kopling", "5231", true, true));
        printPekerja(new Pekerja(500, 2002, 2, 2, 1, "Windah Oli", "8382", true, false));
        printPekerja(new Pekerja(500, 2001, 1, 1, 0, "Sulastri", "3494", false, false));
        printManager(new Manager("HRD", 10000, 2006, 1, 6, 2, "Adityawirz", "11111", true, true));
    }

    public static void printHuman(Manusia human) {
        System.out.println(human);
    }

    public static void printMahasiswaFILKOM(Mahasiswa mahasiswa) {
        System.out.println(mahasiswa);
    }

    public static void printPekerja(Pekerja pekerja) {
        System.out.println(pekerja);
    }

    public static void printManager(Manager manager) {
        System.out.println(manager);
    }
}
