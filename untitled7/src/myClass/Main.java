package myClass;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Telegram> collection = new ArrayList<Telegram>();
        String txt;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите текст телеграмы");
        String vid="";
        int fpak=0;int length=0;
        int count =0;
        while(sc.nextLine()!=null) {
            txt = sc.nextLine();
            String words[] = txt.split(" ");
            for(int i=0;i< words.length;i++){
               if(fpak==0) {length=words.length;vid=words[0];fpak=1;}
               else {
                   if (vid != words[0]) {
                       Telegram line = new Telegram(vid, length);
                       collection.add(line);
                       vid = words[0];
                       length = words.length;
                       count++;
                   }
                   else length=length+words.length;
               }
                if(words[i]==".") words[i]="тчк";
                if(words[i]==",") words[i]="зпт";
            }
        }
        for(int i =0 ;i<count;i++){
           System.out.println(collection.get(i).pudscht());
        }
    }
}
