
package myClasses;

import myException.ApplicantException;

public class Array {
    public int[] a;
    private int size;

    public Array(int size) throws ApplicantException {
        if (size <= 0) {
            throw new ApplicantException("Недопустимый размер массива!");
        } else {
            this.a = new int[size];
            this.size = size;
        }
    }

    public void addMassiv(int el, int i) throws ArrayIndexOutOfBoundsException {
        if (i >= 0 && i <= this.size) {
            this.a[i] = el;
        } else {
            throw new ArrayIndexOutOfBoundsException("Неверно введён индекс массива!!");
        }
    }

    public boolean check() {
        for(int i = 0; i < this.size - 1; ++i) {
            if (this.a[i] > this.a[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public void inversion() {
        for(int i = 0; i < this.size / 2; ++i) {
//            int b = false;
            int b = this.a[i];
            this.a[i] = this.a[this.size - i - 1];
            this.a[this.size - i - 1] = b;
        }

    }
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder(this.size + 10);
        out.append(" ");

        for(int i = 0; i < this.size; ++i) {
            out.append(this.a[i]);
            out.append(" ");
        }

        return out.toString();
    }
    @Override
    public boolean equals(Object O) {
        if (O == null) {
            return false;
        } else if (this == O) {
            return true;
        } else if (!(O instanceof Array)) {
            return false;
        } else {
            Array b = (Array)O;
            if (this.size != b.size) {
                return false;
            } else {
                for(int i = 0; i < this.size; ++i) {
                    if (b.a[i] != this.a[i]) {
                        return false;
                    }
                }

                return true;
            }
        }
    }
    @Override
    public int hashCode() {
        int b = 0;

        for(int i = 0; i < this.size; ++i) {
            b += this.a[i];
        }
        return b + this.size;
    }
}
