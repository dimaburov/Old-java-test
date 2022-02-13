package myClass;

import myException.ApplicantException;

import java.util.Arrays;

public class Array {
    private int[] a;
    private  int size=0; private int[] b;
    public Array(int size) {
        a = new int[size];
        this.size=size;
    }
    public void AddMassiv(int n, int i) throws ApplicantException {
        if(i!=0) {
            a[i] = n;
            if(a[i]>a[i])
                throw new ApplicantException("Неверно введено число в массив!!");
        }
        else a[i] = n;
    }
    public Array() throws ApplicantException {
        this(0);
    }

    public Array(Array copy) {
        this.size = copy.size;
         a= Arrays.copyOf(copy.a, copy.size);
    }
}