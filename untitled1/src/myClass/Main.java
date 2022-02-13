package myClass;

import myException.ApplicantException;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ApplicantException {
        Scanner sc = new Scanner(System.in);

        int size = 0;
        int size2 = 0;
        int size3 = size+size2;
        int number = 0;
        System.out.println("Введите кол-во элементов 1-го массива : ");
        size = sc.nextInt();
            Array a = new Array(size);
            System.out.println("Введите элементы массива: ");
            for (int i = 0; i < size; i++) {
                number = sc.nextInt();
                a.AddMassiv(number, i);
            }
        System.out.println("Введите кол-во элементов 2-го массива: ");
        size2 = sc.nextInt();
                Array2 b = new Array2(size2);
                System.out.println("Введите элементы массива: ");
                for (int i = 0; i < size2; i++) {
                    number = sc.nextInt();
                    b.AddMassiv(number, i);
                }
                    try {//проверки
                        if(size<0||size2<0) throw
                                new Exception("Недопустимый элемент");
                    } catch (ArrayStoreException  e) {
                        System.out.println("Недопустимый тип переменной!");
                    }catch (Exception e) {
                        System.out.println("Неверно задан размер массива!");
                    }
                    finally {
                        Array3 c = new Array3(size3);
                         c.Input(a,b);
                    }
    }
}
