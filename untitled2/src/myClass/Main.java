package myClass;

import myException.ApplicantException;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws ApplicantException {
        Scanner sc = new Scanner(System.in);

        int size=0;
        int size2=0;
        int size3=0;
        int number=0;
        boolean proverka;
        System.out.println("Введите кол-во элементов 1-го массива : ");
        try {//проверки
            size = sc.nextInt();
            Array a = new Array(size);

            System.out.println("Введите элементы массива: ");
            for (int i = 0; i <size; i++) {
                number = sc.nextInt();
                a.addMassiv(number, i);
            }
            proverka = a.check(a);
            if (proverka == false) {
                System.out.println("Числа не упорядочены по возрастанию! ");
                return;
            }

            System.out.println("Введите кол-во элементов 2-го массива: ");
            size2 = sc.nextInt();
            Array b = new Array(size2);
            System.out.println("Введите элементы массива: ");
            for (int i = 0; i < size2; i++) {
                number = sc.nextInt();
                b.addMassiv(number, i);
            }
            proverka = b.check(b);
            if (proverka == false) {
                System.out.println("Числа не упорядочены по возрастанию! ");
                return;
            }
            size3=size+size2;
            Array c = new Array(size3);
            for (int i = 0; i < size; i++) {
                c.addMassiv(a.a[i], i);
            }
            for (int i=0;i<size2;i++){
                c.addMassiv(b.a[i], i+size);
            }
            Arrays.sort(c.a);
            c.inversion(c);
            if(size<0||size2<0) throw
                    new Exception("Недопустимый элемент");
            System.out.println("Массив, упорядоченный по убыванию: ");
            System.out.println(c);
        } catch (ArrayStoreException  e) {
            System.out.println("Недопустимый тип переменной!");
        }catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Выход за границы массива");
        } catch (Exception e) {
            System.out.println("Неверно задан размер массива!");
        }
    }
}
