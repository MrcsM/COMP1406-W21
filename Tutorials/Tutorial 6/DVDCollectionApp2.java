import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DVDCollectionApp2  extends Application {
    private DVDCollection model;

    public DVDCollectionApp2() {
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();

        // Create the labels
        Label label1 = new Label("DVDs");
        label1.relocate(10, 10);
        Label label2 = new Label("Title");
        label2.relocate(10, 202);
        Label label3 = new Label("Year");
        label3.relocate(10, 242);
        Label label4 = new Label("Length");
        label4.relocate(120, 242);

        // Create the TextFields
        TextField tField = new TextField();
        tField.relocate(50, 200);
        tField.setPrefSize(500, 30);
        TextField yField = new TextField();
        yField.relocate(50, 240);
        yField.setPrefSize(55, 30);
        TextField lField = new TextField();
        lField.relocate(180, 240);
        lField.setPrefSize(45, 30);

        // Create the lists
        ListView<DVD>    tList = new ListView<DVD>();
        tList.setItems(FXCollections.observableArrayList(model.getDVDList()));
        tList.relocate(10, 40);
        tList.setPrefSize(540, 150);

        // Create the buttons
        DVDButtonPane buttonPane = new DVDButtonPane();
        buttonPane.relocate(250, 240);

        // Getting the Buttons from DVDButtonPane
        ObservableList<Node> buttons = buttonPane.getChildren();

        // Add button handling
        Button add = (Button) buttons.get(0);
        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String title = tField.getText();
                int year = Integer.parseInt(yField.getText());
                int minutes = Integer.parseInt(lField.getText());

                tList.getItems().add(new DVD(title, year, minutes));
            }
        });

        // Delete button handling
        Button delete = (Button) buttons.get(1);
        delete.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DVD dvd = tList.getSelectionModel().getSelectedItem();
                String title = dvd.getTitle();
                int year = dvd.getYear();
                int minutes = dvd.getDuration();

                for (int i = 0; i < tList.getItems().size(); i++) {
                    if (year == tList.getItems().get(i).getYear() && minutes == tList.getItems().get(i).getDuration() && title == tList.getItems().get(i).getTitle()) {
                        tList.getItems().remove(i);
                        break;
                    }
                }
            }
        });

        // ListView selection
        tList.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                DVD dvd = tList.getSelectionModel().getSelectedItem();
                tField.setText(dvd.getTitle());
                yField.setText("" + dvd.getYear());
                lField.setText("" + dvd.getDuration());
            }
        });

        // Add all the components to the window
        aPane.getChildren().addAll(label1, label2, label3, label4, tField, yField,
                lField, tList, buttonPane);

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane, 560,280));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
