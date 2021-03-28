import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DVDCollectionApp extends Application {
    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();

        Label label1 = new Label("Title");
        Label label2  = new Label("Year");
        Label label3   = new Label("Length");
        label1.relocate(10,10);
        label2.relocate(220,10);
        label3.relocate(290,10);

        String[]    titles = {"Star Wars", "Java is cool", "Mary Poppins", "The Green Mile"};
        String[]    years = {"1978", "2002", "1968", "1999"};
        String[]    lengths = {"124", "93", "126", "148"};

        ListView<String> tList = new ListView<String>();
        tList.setItems(FXCollections.observableArrayList(titles));
        tList.relocate(10,35);
        tList.setPrefSize(200,150);

        ListView<String> yList = new ListView<String>();
        yList.setItems(FXCollections.observableArrayList(years));
        yList.relocate(220,35);
        yList.setPrefSize(60,150);

        ListView<String> lList = new ListView<String>();
        lList.setItems(FXCollections.observableArrayList(lengths));
        lList.relocate(290,35);
        lList.setPrefSize(60,150);

        Button addButton = new Button("Add");
        addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,100,0); " +
                "-fx-text-fill: rgb(255,255,255);");
        addButton.relocate(10,200);
        addButton.setPrefSize(95,30);

        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(100,0,0); " +
                "-fx-text-fill: rgb(255,255,255);");
        deleteButton.relocate(115,200);
        deleteButton.setPrefSize(95,30);

        Button statsButton = new Button("Stats");
        statsButton.setStyle("-fx-font: 12 arial");
        statsButton.relocate(290,200);
        statsButton.setPrefSize(60,30);

        aPane.getChildren().addAll(label1, label2, label3, tList,
                yList, lList, addButton, deleteButton, statsButton);

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane, 360, 240));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
