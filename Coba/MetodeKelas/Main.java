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

public class Main {
    public void mobil(){
        System.out.println("Kendaraan berikut yang melaju kencang");
    }
    public void melaju(int kencang){
        System.out.println("kecepatan mobil adalah :" + kencang);
    }
    public static void main(String[] args) {
        Main kecMobil = new Main();
        kecMobil.mobil();
        kecMobil.melaju(400);   
    }
}