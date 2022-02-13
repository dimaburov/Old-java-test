package com.company;
import java.util.Arrays;

public class Array {
    int[] a;
    int size;

    public Array(int size) {
        a = new int[size];
    }

    public void AddMassiv(int n, int i) {
        a[i] = n;
    }

    public void Result(){
        System.out.println("Отрицательные числа: ");
        int count = 0;
        for (int i = 0; i < a.length; i++){
            if (a[i] < 0) {
                System.out.print(a[i] + "");
                System.out.print("[" + i + "]" + "; ");
                count++;
            }
        }
        System.out.println();
        System.out.println("\nКол-во отрицательных чисел: " + count);
    }

    @Override
    public String toString(){
        return  Arrays.toString(a);
    }
}