package myClass;

import myException.ApplicantException;

public class Array2 {

       private  int[] b;
       private int size2=0;
       public Array2(int size2) {
           b = new int[size2];
           this.size2=size2;
    }

    public void AddMassiv(int n, int i)   throws ApplicantException {
        if(i!=0) {
            b[i] = n;
            if(b[i]>b[i])
                throw new ApplicantException ("Неверно введено число в массив!!");
        }
        else b[i] = n;
    }
}
