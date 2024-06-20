package Coba.MetodeKelas;

// public class Main {
//     static void HelloWorld() {
//         System.out.println("Hello World");
//     }
//     public static void main(String[] args) {
//         HelloWorld();
//     }
// }

// public class Main {
//     static void helloWorld(){
//         System.out.println("Hello World");
//     }

//     public void helloDunia(){
//         System.out.println("Selamat datang dunia");
//     }
//     public static void main(String[] args) {
//         helloWorld();
//         Main dunia = new Main();
//         dunia.helloDunia();
//     }
// }

//INI LATIHAN UNTUK MEMANGGIL METHOD DI DALAM CLASS

public class Main {
    public void mobil(){
        System.out.println("Kendaraan berikut yang melaju kencang");
    }
    public void melaju(int kencang){
        if (kencang > 100) {
            System.out.println("Mobil melaju sangat kencang!");
        } else if (kencang > 60) {
            System.out.println("Mobil melaju dengan kecepatan normal.");
        } else {
            System.out.println("Mobil melaju lambat.");
        }
    }
    public static void main(String[] args) {
        Main kecMobil = new Main();
        kecMobil.mobil();
        kecMobil.melaju(400);   
    }
}