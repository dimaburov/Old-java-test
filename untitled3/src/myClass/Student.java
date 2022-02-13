package myClass;

public class Student {
    private String sex;
    private String name;
    private int yearofbirht;
    public Student(String name,int yearofbirht,String sex){
        this.name = name;
        this.sex = sex;
        this.yearofbirht =yearofbirht;
    }
    public int bornYear(Student a,int newyear){
        int yearsold=newyear-yearofbirht;
        return yearsold;
    }
    public boolean match(Student a,Student b){
        if((a.name==b.name)&&(a.yearofbirht==b.yearofbirht)) return true;
        else return false;
    }
    public void print(Student a){
        System.out.println("Имя "+a.name);
        System.out.println("Пол "+a.sex);
        System.out.println("Год рождения "+a.yearofbirht);
    }
}
