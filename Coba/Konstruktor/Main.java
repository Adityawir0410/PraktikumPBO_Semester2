package Coba.Konstruktor;

// public class Main {
//     int x;

//     public Main (){
//         x = 5;
//     }
//     public static void main(String[] args) {
//         Main namaX = new Main();
//         System.out.println(namaX.x);
//     }
// }

// public class Main {
//     int modelYear;
//     String modelName;

//     public Main (String name, int year){
//         modelName = name;
//         modelYear = year;
//     }
//     public static void main(String[] args) {
//         Main kendaraan = new Main("Mustang",1932);
//         System.out.println(kendaraan.modelName + " " + kendaraan.modelYear);
//     }
// }

// public class Main {
//     int x;

//     public Main(int y) {
//         x = y;
//     }

//     public static void main(String[] args) {
//         Main angka = new Main(5);
//         System.out.println("angka nya adalah " + angka.x);
//     }
// }

public class Main {
    int nomerRumah;
    String alamatRumah;
    

    public Main(int nomer, String alamat){
        nomerRumah = nomer;
        alamatRumah = alamat;
    }
    public void alamatRumah(){
        System.out.println("Alamatnya adalah");
    }


    public static void main(String[] args) {
        Main rumahBahagia = new Main(06, "Jl Sunan Giri");
        System.out.println("alamat rumahnya adalah bernomor " + rumahBahagia.nomerRumah + " " + rumahBahagia.alamatRumah);
    }
}