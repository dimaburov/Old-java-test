package myClass;

import myException.ApplicantException;

import javax.swing.plaf.PanelUI;

public class Triangle {
    private double side1;
    private double side2;
    private double side3;
    public Triangle(double side1,double side2,double side3)throws ApplicantException {
        if(!(side1+side2>side3)||!(side2+side3>side1)||!(side1+side3>side2))
            throw new ApplicantException("Треугольника не существует");
        if((side1<0)||(side2<0)||(side3<0))
            throw new ApplicantException("Треугольника не существует");
        this.side1=side1;
        this.side2=side2;
        this.side3=side3;
    }
    public double areas(){
        double area=0;
        double halfMeter=0.5*(side1+side2+side3);
        //формула Герона
        area=Math.sqrt(( halfMeter*(halfMeter-side1)*(halfMeter-side2)*(halfMeter-side3)));
        return area;
    }
    //равнобедренный
    public int isosceles(){
        if((side1==side2)&&(side1==side3)&&(side2==side3)) return 1;
        return 0;
    }
    //прямоугольный
    public int rectangular(){
        if((side1*side1+side2*side2)==(side3*side3)) return 1;
        if((side2*side2+side3*side3)==(side1*side1)) return 1;
        if((side1*side1+side3*side3)==(side2*side2)) return 1;
        return 0;
    }
    //тупоугольные треугольники
    public int obtuse(){
        if((side1*side1+side2*side2)<(side3*side3)) return 1;
        if((side2*side2+side3*side3)<(side1*side1)) return 1;
        if((side1*side1+side3*side3)<(side2*side2)) return 1;
        return 0;
    }
    //подобные тругольники
    public int similarTriangles(Triangle a){
        double ab=a.side1;
        double ac=a.side2;
        double ad=a.side3;
        double b =side1/ab;
        double  c= side2/ac;
        double  d =side3/ad;
        if((b==c)&&(c==d)&&(b==d))
            return 1;
        return 0;
    }
    @Override
    public String toString(){
        StringBuilder out= new StringBuilder(10);//переделал под  StringBuilder
        out.append(" ");
        out.append(side1);
        out.append(" ");
        out.append(side2);
        out.append(" ");
        out.append(side3);
        return out.toString();
    }
    @Override
    public boolean equals(Object O){//проверяет объекты на равенство
        if(O==null) return false;
        if(this==O) return true;
        if(!(O instanceof Triangle)) return false;//instanceof служит для проверки какому классу пренадлежит объект
        Triangle b=(Triangle) O;
        if(side1!=b.side1) return false;
        if(side2!=b.side2) return false;
        if(side3!=b.side3) return false;
        return true;
    }
    @Override
    public int hashCode(){//индивидуальный код массива(объекта)
        int b=0;
        b=(int )(side1+side2+side3);
        return b;//сумма всех элеменотов+размер
    }
}
