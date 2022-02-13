package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = 0;
        int number = 0;

        System.out.println("Введите кол-во чисел: ");
        if (sc.hasNextInt()) {
            size = sc.nextInt();
        } else
            System.exit(0);

        Array a = new Array(size);

        System.out.println("Введите последовательность чисел: ");
        for (int i = 0; i < size; i++) {
            if (sc.hasNextInt()) {
                number = sc.nextInt();
            } else {
                System.exit(0);
            }
            a.AddMassiv(number, i);
        }

        System.out.println("Введенный массив: ");
        System.out.println(a);

        System.out.println("\n------------------------------------ ");
        a.Result();
    }
}