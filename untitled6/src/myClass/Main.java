package myClass;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Book> collection = new ArrayList<Book>();
        BufferedReader myFile = new BufferedReader(new FileReader("C:\\Users\\MiNotebook\\IdeaProjects\\untitled6\\src\\myClass\\data.txt"));
        String scan =myFile.readLine();
        String firstName;//фамилия автора
        String title;//название
        String genre;//жанр
        int price;//цена
        int count=0;
        while(scan!=null) {
            String[] book = scan.trim().split(" +");
            firstName = book[0];
            title = book[1];
            genre = book[2];
            price = Integer.parseInt(book[3]);
            Book line = new Book(firstName,title,genre,price);
            System.out.println(line);
            collection.add(line);
            scan=myFile.readLine();
            count++;
        }
        System.out.println();
        PrintWriter out = new PrintWriter("C:\\Users\\MiNotebook\\IdeaProjects\\untitled6\\src\\myClass\\rezult.txt");
        genreComparator genress = new genreComparator();
        firstNameComparator name = new firstNameComparator();
        //сортировка по жанру///////////уууууквввку
        Comparator <Book> comp1 = name;
        Collections.sort(collection,comp1);
        for(int i=0;i<count;i++) {
            System.out.printf("%d ", i);
            System.out.println(collection.get(i));
        }
        System.out.println();
        //////сортировка по имени//////
        Comparator <Book> comp = genress;
        Collections.sort(collection,comp);
        for(int i=0;i<count;i++){
            System.out.printf("%d ",i);
            System.out.println(collection.get(i));
            //вывод в файл rezult.txt
            out.printf("%d ",i);
            out.println(collection.get(i));
        }
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер книги которую хотите купить ");
        int number =0,pay=0;
        number=sc.nextInt();
        System.out.println("Сумма для оплаты:");
        pay=sc.nextInt();
        if(collection.get(number).purches(pay)!=-1) {
            System.out.printf("Цена покупки %d \n",collection.get(number).getPrice());
            System.out.printf("Сдача %d \n",collection.get(number).purches(pay));
        }
        else  System.out.println("Денег для покупки не хватает!!");
        //////////////////3 задача///////////////
        Scanner wr = new Scanner(System.in);
        String word ;
        int count1 =0;
        System.out.println("Введите предложение ");
        word = wr.nextLine();
        System.out.println(word);
        String words[] = word.split(" ");
        for(int i =0 ;i<words.length;i++){
            if(words[i].length()==3) count1 ++;
        }
        System.out.printf("Количество трёхбуквенных слов  %d",count1);
        myFile.close();
        out.close();
    }
}
