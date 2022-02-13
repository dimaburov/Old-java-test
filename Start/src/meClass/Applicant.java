package meClass;

public class Applicant {
    private String surname;
    private int totalScore;
    public Applicant(){/**перваночальное присваивание*/
        surname = ("Ivanov");
        totalScore=100;
    }
    public Applicant(String surname,int  totalScore){/**операция присваивания*/
        this.surname=surname;
        this.totalScore=totalScore;
    }
    public Applicant(Applicant ap){
        surname=ap.surname;
        totalScore=ap.totalScore;
    }
    public void set(String surname){
        this.surname= surname;
    }
    public void set(int totalScore){
        this.totalScore= totalScore;
    }

}
