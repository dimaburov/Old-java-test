package myClass;

import myException.ApplicantException;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args ) throws Exception {
        try {
            ArrayList<Triangle> collection = new ArrayList<Triangle>();
            double side1;
            double side2;
            double side3;
            BufferedReader myFil= new BufferedReader(new FileReader("C:\\\\Users\\\\MiNotebook\\\\IdeaProjects\\\\Trangel\\\\src\\\\myClass\\\\data.txt"));
                    String in =myFil.readLine();
            int Max = 0;
            //определяем количество строк в файле
            while (in!=null) {
                Max++;
                in=myFil.readLine();
            }
            myFil.close();
            //становимся в начале файла
            BufferedReader myFile = new BufferedReader(new FileReader("C:\\\\Users\\\\MiNotebook\\\\IdeaProjects\\\\Trangel\\\\src\\\\myClass\\\\data.txt"));
            String scan =myFile.readLine();
            while(scan!=null) {
                String[] side = scan.trim().split(" +");
                side1=Double.parseDouble(side[0]);
                side2=Double.parseDouble(side[1]);
                side3=Double.parseDouble(side[2]);
                Triangle line = new Triangle(side1,side2,side3);
                //формируем объект
                System.out.println(line.toString());
                collection.add(line);
                scan=myFile.readLine();
            }
            System.out.println();
          //создаём массив площадей фигур
            areaComparator areass = new areaComparator();
            Comparator<Triangle> comp = areass;
            Collections.sort(collection,comp);
           for(Triangle O:collection)
            System.out.println(O);
            System.out.println("Равнобеденные треугольники: ");
            for (int i = 0; i < Max; i++) {
                if (collection.get(i).isosceles() == 1)
                    System.out.println(collection.get(i).toString());
            }
            System.out.println("Прямоугольные треугольники: ");
            for (int i = 0; i < Max; i++) {
                if (collection.get(i).rectangular() == 1)
                    System.out.println(collection.get(i).toString());
            }
            System.out.println("Тупоугольные треугольники: ");
            for (int i = 0; i < Max; i++) {
                if (collection.get(i).obtuse() == 1)
                    System.out.println(collection.get(i).toString());
            }
            System.out.println("Подобные треугольники: ");
            for (int i = 0; i < Max; i++) {
                for (int j = i + 1; j < Max; j++) {
                    if (collection.get(i).similarTriangles(collection.get(j)) == 1)
                        System.out.println(collection.get(i).toString() + " подобен " + collection.get(j).toString());
                }
            }
            myFile.close();
        }
        catch (ArrayStoreException  e) {
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
