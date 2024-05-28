package Laprak2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] intArr = {5,3,8,1,2};
        double[] doubleArr = {2.5, 1.3, 5.8, 3.1, 4.2};

        Array.sort(intArr);
        System.out.println("Ascending int array : " + Arrays.toString(intArr));

        Array.sort(doubleArr, true);
        System.out.println("Descending double array: " + Arrays.toString(doubleArr));
    }
}

