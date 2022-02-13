package sample;

import javafx.beans.property.*;

public class People {
    private StringProperty name;

    public StringProperty nameStringProperty() {
        if (name == null) {
            name = new SimpleStringProperty();
        }
        return name;
    }
    public final void setName(String value) {
        nameStringProperty().set(value);
    }
    public final String getName() {
        return nameStringProperty().get();
    }


    private IntegerProperty age;
    public IntegerProperty ageProperty() {
        if (age == null) {
            age = new SimpleIntegerProperty();
        }
        return age;
    }
    public final void setAge(Integer age) {
        ageProperty().set(age);
    }
    public final Integer getAge() {
        return ageProperty().get();
    }

    private StringProperty status;
    public StringProperty statusStringProperty() {
        if(status==null){
            status=new SimpleStringProperty();
        }
        return status;
    }
    public final void setStatus(String value) {
        statusStringProperty().set(value);
    }

    private DoubleProperty money;
    public DoubleProperty moneyDoubleProperty() {
        if(money==null){
            money=new SimpleDoubleProperty();
        }
        return money;
    }
    public final void setMoney(Double value){moneyDoubleProperty().set(getMoney()+value);}
    public final Double getMoney(){
        return moneyDoubleProperty().get();
    }

    public People (String name , int age,String status, double money){
        setName(name);
        setAge(age);
        setStatus(status);
        setMoney(money);
    }
//0 – 11 – детство, 12 – 19 – юность, 20 – 35 – молодость, 36 и больше– зрелость
public String whatStatus(int year,double money){

    String s="";

    if ((year>=0)&&(year<=11)){ s+="Детство "; }
    if((year>11)&&(year<=19)) { s+= "Юность "; }
    if((year>19)&&(year<=35)){ s+="Молодость "; }
    if(year>35)s+="Зрелость ";

    if((money>0)&&(money<=12000)){ s+="- Банкрот "; }
    if((money>12000)&&(money<=35000)){ s+="- Бедняк "; }
    if((money>35000)&&(money<=100000)){ s+="- Достаток "; }
    if((money>100000)&&(money<=500000)){ s+="- Средний класс "; }
    if((money>500000)&&(money<=100000000)){ s+="- Миллионер "; }
    if((money>100000000)&&(money<=800000000)){ s+="- Мультимиллионер "; }
    if(money>800000000)s+="- Миллиардер ";
    return s;
}
}
