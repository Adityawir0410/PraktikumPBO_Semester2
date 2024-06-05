package Coba;
// import java.util.ArrayList;
// import java.util.Scanner;

// class Plant {
//     protected int umur;
//     protected boolean statusHidup;
//     protected int jumlah;

//     public Plant (){
//         this.umur = 0;
//         this.jumlah = 0;
//         this.statusHidup =true;
//     }

// }



// public class CobaLatihan {
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int months = scanner.nextInt();

//     }
// }

import java.util.ArrayList;
import java.util.Scanner;

class Plant {
    protected int age;
    protected boolean alive;
    protected int fruitCount;

    public Plant() {
        this.age = 0;
        this.alive = true;
        this.fruitCount = 0;
    }

    public void grow() {
        if (alive) {
            age++;
        }
    }

    public void treatment() {
        System.out.println("Melakukan perawatan pada tanaman ini.");
    }

    public void printStatus() {
        System.out.println("Umur: " + age + " hari");
        System.out.println("Jumlah buah: " + fruitCount);
        System.out.println("Status: " + (alive ? "Hidup" : "Mati"));
    }
}

class Peach extends Plant {
    public void grow() {
        super.grow();
        if (age > 100 && alive) {
            fruitCount += 5;
        } else if (age > 150) {
            alive = false;
        }
    }
}

class Strawberry extends Plant {
    public void grow() {
        super.grow();
        if (age > 50 && alive) {
            fruitCount += 3;
        } else if (age > 80) {
            alive = false;
        }
    }
}

class Tomato extends Plant {
    public void grow() {
        super.grow();
        if (age > 70 && alive) {
            fruitCount += 10;
        } else if (age > 120) {
            alive = false;
        }
    }
}

public class CobaLatihan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan masa tanam (dalam bulan): ");
        int months = scanner.nextInt();

        int days = months * 30;
        ArrayList<Plant> plants = new ArrayList<>();
        ArrayList<Integer> deadPlantLocations = new ArrayList<>();

        for (int day = 1; day <= days; day++) {
            if (day % 90 == 0) {
                System.out.println("Hari perawatan!");
                for (Plant plant : plants) {
                    if (plant.alive) {
                        plant.treatment();
                    }
                }
            }

            for (int i = 0; i < plants.size(); i++) {
                Plant plant = plants.get(i);
                plant.grow();
                if (!plant.alive) {
                    deadPlantLocations.add(i);
                    System.out.println("Tanaman di lokasi " + i + " telah mati.");
                }
            }
        }

        System.out.println("\nHasil menanam:");
        for (int i = 0; i < plants.size(); i++) {
            if (!deadPlantLocations.contains(i)) {
                System.out.println("\nTanaman di lokasi " + i + ":");
                plants.get(i).printStatus();
            }
        }
    }
}