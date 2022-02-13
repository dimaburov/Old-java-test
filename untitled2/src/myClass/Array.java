package myClass;

import myException.ApplicantException;

import java.util.Arrays;

public class Array {
    public int[] a;
    private  int size;
    public Array(int size) throws ApplicantException {
        if (size<=0)
            throw new ApplicantException("Неверно задан размер массива!!!!");
        this.a = new int[size];
        this.size=size;
    }
    public void addMassiv (int el, int i)  {
        if(i<0||i>size) throw new  ArrayIndexOutOfBoundsException("Неверно введён индекс массива!!");
        this.a[i] = el;

    }
    public boolean check(Array a) {
            for (int i = 0; i < this.size-1; i++) {
                if (this.a[i] > this.a[i + 1])
                    return false;
            }
        return true;
    }
    public void inversion (Array a) {
        for (int i=0; i<this.size/2;i++) {
            int b=0;
            b=this.a[i];
            this.a[i]=this.a[size-i-1];
            this.a[size-i-1]=b;
        }
    }
    @Override
    public String toString(){//массив поочерёдно записываем через пробел в строку это и называет переопеделение
        StringBuilder out= new StringBuilder(size+10);//переделал под  StringBuilder
        out.append(" ");
        for(int i=0;i<size;i++){
            out.append(a[i]);
            out.append(" ");
        }
        return out.toString();
    }
    @Override
    public boolean equals(Object O){//проверяет объекты на равенство
        if(O==null) return false;
        if(this==O) return true;
        if(!(O instanceof Array)) return false;//instanceof служит для проверки какому классу пренадлежит объект
        Array b=(Array)O;
        if(size!=b.size) return false;
        for(int i=0;i<size;i++) {
            if(b.a[i]!=a[i]) return false;
        }
        return true;
    }
    @Override
    public int hashCode(){//индивидуальный код массива(объекта)
        int b=0;
        for(int i=0;i<size;i++){
            b=b+a[i];
        }
        return b+size;//сумма всех элеменотов+размер
    }

}
