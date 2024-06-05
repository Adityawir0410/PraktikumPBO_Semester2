package Coba;

interface kendaraan {
    void berjalan();
}

class mobil implements kendaraan {
    @Override
    public void berjalan (){
        System.out.println("sepeda berjalan");
    }
}

class sepeda implements kendaraan {
    @Override
    public void berjalan(){
        System.out.println("mobil berjalan");
    }
    public static void main(String[] args) {
        kendaraan myMobil = new mobil();
        kendaraan mySepeda = new sepeda();
        myMobil.berjalan();
        mySepeda.berjalan();
    }
}