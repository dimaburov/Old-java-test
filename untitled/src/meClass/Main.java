package meClass;

import myException.ApplicantException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ApplicantException {
        Scanner sc = new Scanner(System.in);

        int size = 0;
        int number = 0;

        System.out.println("Введите кол-во чисел: ");
            try {//проверки
                size = sc.nextInt();
                Array a = new Array(size);
                System.out.println("Введите последовательность четырёхзначных чисел: ");
                for (int i = 0; i < size; i++) {
                    number = sc.nextInt();
                    a.AddMassiv(number, i);
                }
                System.out.println("Введённый массив: ");
                System.out.println(a.toString());
                a.Comparison();
                System.out.println("Полученный массив: ");
                System.out.println(a.toString());
            } catch (ArrayStoreException  e) {
                System.out.println("Недопустимый тип переменной!");
                return;
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Недопустимый индекс массива!");
                return;
            }
            catch (ApplicantException e) {
                System.out.println(e);
                return;
            }
            catch (InputMismatchException e) {
                System.out.println("Неверно задан размер массива!");
                return;
            }
    }
}