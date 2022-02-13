package myClass;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите имя, пол и год рождения");
        String name = sc.next();
        String sex = sc.next();
        int yearofbirht = sc.nextInt();
        Student a = new Student(name,yearofbirht,sex);
        a.bornYear(a,2019);

        System.out.println("Введите имя, пол и год рождения");
        String name1 = sc.next();
        String sex1 = sc.next();
        int yearofbirht1 = sc.nextInt();
        Student a1 = new Student(name1,yearofbirht1,sex1);
        a1.bornYear(a1,2019);

        System.out.println("Введите имя, пол и год рождения");
        String name2 = sc.next();
        String sex2 = sc.next();
        int yearofbirht2 = sc.nextInt();
        Student a2 = new Student(name2,yearofbirht2,sex2);
        a2.bornYear(a2,2019);
        a.print(a);
        a1.print(a1);
        a2.print(a2);
       if(sex.compareTo("M")==1)
               if(a.bornYear(a,2019)>=60){
                   a.print(a);
        }
        if(sex.compareTo("F")==1)
            if(a.bornYear(a,2019)>=55){
                a.print(a);
            }
        if(sex1.compareTo("M")==1)
            if(a1.bornYear(a1,2019)>=60){
                a1.print(a1);
            }
        if(sex1.compareTo("F")==1)
            if(a1.bornYear(a1,2019)>=55){
                a1.print(a1);
            }
        if(sex2.compareTo("M")==1)
            if(a2.bornYear(a2,2019)>=60){
                a2.print(a2);
            }
        if(sex2.compareTo("F")==1)
            if(a2.bornYear(a2,2019)>=55){
                a2.print(a2);
            }
    }
}
