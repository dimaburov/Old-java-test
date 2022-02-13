package sample;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class ViewPeople {
    private People people;
    private GridPane grid;
    Text namePeople;
    Text agePeople;
    Text statusPeople;
    private Label moneyVol;

    private void createPane() {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text nameTitle = new Text("Your name: ");
        nameTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(nameTitle, 0, 0);

        namePeople = new Text(people.getName());
        namePeople.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        namePeople.textProperty().bind(people.nameStringProperty());
        GridPane.setHalignment(namePeople, HPos.CENTER);
        grid.add(namePeople, 1, 0);

        Text ageTitle = new Text("Your ages: ");
        ageTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(ageTitle, 0, 1);

        agePeople = new Text(Integer.toString(people.getAge()));
        agePeople.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        agePeople.textProperty().bind(people.ageProperty().asString());
        GridPane.setHalignment(agePeople, HPos.CENTER);
        grid.add(agePeople, 1, 1);


        Text statusTitle = new Text("Your status: ");
        statusTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(statusTitle, 0, 2);

        statusPeople = new Text(people.whatStatus(people.getAge(),people.getMoney()));
        statusPeople.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        statusPeople.textProperty().bind(people.statusStringProperty());
        GridPane.setHalignment(statusPeople, HPos.CENTER);
        grid.add(statusPeople, 1, 2);


        Text moneyTitle=new Text("Your money: ");
        moneyTitle.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        grid.add(moneyTitle,0,3);

        moneyVol=new Label();
        moneyVol.setFont(Font.font("Tahoma",FontWeight.NORMAL,20));
        moneyVol.textProperty().bind(people.moneyDoubleProperty().asString());
        grid.add(moneyVol,1,3);
    }
    public  GridPane getPane(){
        return  grid;
    }

    public void setPeople (People people) {
        this.people = people;
        namePeople.textProperty().bind(this.people.nameStringProperty());
        agePeople.textProperty().bind(this.people.ageProperty().asString());
    }

    public ViewPeople(People people) {
        this.people = people;
        createPane();
    }
}
