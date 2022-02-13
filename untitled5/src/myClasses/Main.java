
package myClasses;

import java.util.Arrays;
import java.util.Scanner;
import myException.ApplicantException;

public class Main {
    public Main() {
    }

    public static void main(String[] args) throws ApplicantException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите кол-во элементов 1-го массива : ");

        try {
            int size = sc.nextInt();
            Array a = new Array(size);
            System.out.println("Введите элементы массива: ");

            int number;
            for (int i = 0; i < size; ++i) {
                number = sc.nextInt();
                a.addMassiv(number, i);
            }

            boolean proverka = a.check();
            if (!proverka) {
                System.out.println("Числа не упорядочены по возрастанию! ");
                return;
            }

            System.out.println("Введите кол-во элементов 2-го массива: ");
            int size2 = sc.nextInt();
            Array b = new Array(size2);
            System.out.println("Введите элементы массива: ");

            for (int i = 0; i < size2; ++i) {
                number = sc.nextInt();
                b.addMassiv(number, i);
            }

            proverka = b.check();
            if (!proverka) {
                System.out.println("Числа не упорядочены по возрастанию! ");
                return;
            }

            int size3 = size + size2;
            Array c = new Array(size3);

            int i;
            for (i = 0; i < size; ++i) {
                c.addMassiv(a.a[i], i);
            }

            for (i = 0; i < size2; ++i) {
                c.addMassiv(b.a[i], i + size);
            }

            Arrays.sort(c.a);
            c.inversion();
            if (size < 0 || size2 < 0) {
                throw new ApplicantException("Недопустимый элемент");
            }

            System.out.println("Массив, упорядоченный по убыванию: ");
            System.out.println(c);
        } catch (ArrayStoreException var11) {
            System.out.println("Недопустимый тип переменной!");
            return;
        } catch (ArrayIndexOutOfBoundsException var12) {
            System.out.println("Выход за границы массива");
            return;
        } catch (ApplicantException e) {
            System.out.println(e);
            return;
        }
    }
    }
