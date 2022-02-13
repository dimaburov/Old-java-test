package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.time.LocalDate;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("People name age");
        HBox root = new HBox(10);
        People people = new People(" ",0," ",0.0);
        ViewPeople viewOrg = new ViewPeople(people);
        root.getChildren().add(editBlock(people));
        root.getChildren().add(new Separator(Orientation.VERTICAL));
        root.getChildren().add(viewOrg.getPane());

        Scene scene = new Scene(root, 900, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private VBox editBlock(People people) {
        VBox editPane = new VBox(10);
        editPane.setPadding(new Insets(20));

        Label labelTitle1 = new Label("Enter you name ");
        labelTitle1.setFont(Font.font(20));

        TextField editName = new TextField();
        editName.setFont(Font.font(20));
        editName.setPrefSize(150, 40);

        Label labelTitle2 = new Label("Enter your age");
        labelTitle2.setFont(Font.font(20));

        TextField editAge=new TextField();
        editAge.setFont(Font.font(20));
        editAge.setPrefSize(150,40);

        Label labelTitle3 = new Label("Enter your money");
        labelTitle3.setFont(Font.font(20));

        TextField editMoney=new TextField();
        editMoney.setFont(Font.font(20));
        editMoney.setPrefSize(150,40);

        Button button=new Button("Price");
        button.setFont(Font.font(20));
        button.setOnAction((ActionEvent event)->{
            people.setMoney(Double.parseDouble(editMoney.getText()));
        });

        Button btn = new Button("Edit");
        btn.setFont(Font.font(20));
        btn.setOnAction((ActionEvent event) -> {
            people.setName(editName.getText());
            people.setAge(Integer.parseInt(editAge.getText()));
            people.setStatus(people.whatStatus(people.getAge(),people.getMoney()));
        });
        editPane.getChildren().addAll(labelTitle1, editName, labelTitle2,editAge,labelTitle3,editMoney, btn,button);
        return editPane;
    }


        public static void main(String[] args) {
        launch(args);
    }
}
