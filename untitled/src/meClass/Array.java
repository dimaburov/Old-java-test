package meClass;


import myException.ApplicantException;

public class Array {
    private int[] a;
   private  int size=0;
    public Array(int size) throws ApplicantException {
        if (size<=0)
            throw new ApplicantException("Неверно задан размер массива");
        a = new int[size];
        this.size=size;
    }

    public void AddMassiv(int n, int i) throws ApplicantException {
        if(n>0) {
            if (n >= 9999 || n <= 999)
                throw new ApplicantException("Неверно введено число в массив!!");
        }
        if(n<0) {
            if (n >= -999 || n <= -9999)
                throw new ApplicantException("Неверно введено число в массив!!");
        }
        if(i<0||i>size) throw new  ArrayIndexOutOfBoundsException("Неверно введён индекс массива!!");
            a[i] = n;
    }
    public void Comparison () {
       int number1=0,number2=0,numberSr1=0,numberSr2=0,fpak=0;
        for (int i = 0; i < size;) {
            if(a[i]<0) {fpak=1;a[i]=a[i]*-1;}
            number1 = Math.floorDiv(a[i], 1000);
            number2 = Math.floorMod(Math.floorDiv(a[i], 100), 10);
            numberSr1 = number1 + number2;
            number1 = Math.floorDiv(Math.floorMod(a[i], 100), 10);
            number2 = Math.floorMod(Math.floorMod(a[i], 100), 10);
            numberSr2 = number1 + number2;
            if(fpak==1){fpak=0;a[i]=a[i]*-1;}
            if (numberSr1 != numberSr2) {
                delete(i);
            }
            else i++;
        }
    }
    public void delete (int n)
    {
      for(int i=n;i<size-1;i++){
          a[i]=a[i+1];
      }
      size--;
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
