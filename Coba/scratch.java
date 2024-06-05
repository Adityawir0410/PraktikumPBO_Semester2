package Coba;

// import java.util.ArrayList;
// import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class scratch {
    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        set.add("budi");
        set.add("joko");
        set.add("andi");

        System.out.println(set.size());
        System.out.println("seluruh data di dalam HashSet : " + set.size());
        for (String s : set) {
            System.out.println(s);
        }
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            
        }
        


    //     ArrayList<String> daftarMobil = new ArrayList<String>();
    //     daftarMobil.add("Toyota");
    //     daftarMobil.add("Honda");
    //     daftarMobil.add("Ford");

    //     System.out.println("urutan pertama" + daftarMobil.get(1));
    //     System.out.println("urutan pertama :" + daftarMobil.get(0));
    //     daftarMobil.set(1, "BMW");
    //     System.out.println("urutan pertama :" + daftarMobil.get(1));
    //     daftarMobil.remove("Honda");
    //     System.out.println("Jumlah String :" +daftarMobil.size());


    //     for (String mobil : daftarMobil) {
    //         System.out.println(mobil);
    //     }
    // }


    }
}
