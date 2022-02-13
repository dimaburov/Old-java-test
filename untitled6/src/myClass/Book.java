package myClass;

public class Book {
        private String firstName;//фамилия автора
        private  String title;//название
        private String genre;//жанр
        private int price;//цена
    public Book(String firstName, String title, String genre, int price){
        this.firstName=firstName;
        this.title=title;
        this.genre=genre;
        this.price=price;
    }
    public String getGenre(){
        return genre;
    }
    public  String getFirstName(){
        return firstName;
    }
    @Override
    public String toString(){
        return firstName+' '+title+' '+genre+' '+price;
    }
    public int purches(int pay){
        int delivery=0;
        delivery=pay-price;
        if(delivery<0) return -1;
        else return delivery;
    }
    public  int getPrice(){
        return price;
    }
}
