package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        BorderPane pane = new BorderPane();
        Label lbl = new Label("fxLabel");
        TextField txt = new TextField();
        Button btn = new Button("Submit");
        HBox hb = new HBox(20);
        hb.getChildren().addAll(lbl, txt, btn);
        pane.setTop(hb);
        txt.setOnMouseClicked(event -> {
            txt.setText("why you click me");
            Alert a = new Alert(Alert.AlertType.INFORMATION, "Again why you click me");
            a.show();

        });


        VBox vbox = new VBox(20);
        Label lbl3 = new Label("Please choose one or more ");
        CheckBox cb1 = new CheckBox("Java");
        CheckBox cb2 = new CheckBox("python");
        vbox.getChildren().addAll(lbl3, cb1, cb2);
        pane.setRight(vbox);
        EventHandler<ActionEvent> event = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String str, str2=", you did not select any course";
                str = txt.getText();
                if (cb1.isSelected() && cb2.isSelected())
                    str2 = cb1.getText()+" and "+cb2.getText();
                else if (cb1.isSelected())
                    str2 = cb1.getText();
                 else if (cb2.isSelected())
                    str2 = cb2.getText();
                Alert a = new Alert(Alert.AlertType.WARNING, str + str2);
                a.show();
            }
        };
        btn.setOnAction(event);




        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
