import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class DVDButtonPane extends Pane {
    public DVDButtonPane() {
        Button addButton = new Button("Add");
        addButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(0,100,0); " +
                "-fx-text-fill: rgb(255,255,255);");
        addButton.relocate(0,0);
        addButton.setPrefSize(90,30);

        Button deleteButton = new Button("Delete");
        deleteButton.setStyle("-fx-font: 12 arial; -fx-base: rgb(100,0,0); " +
                "-fx-text-fill: rgb(255,255,255);");
        deleteButton.relocate(100,0);
        deleteButton.setPrefSize(90,30);

        Button statsButton = new Button("Stats");
        statsButton.setStyle("-fx-font: 12 arial");
        statsButton.relocate(210,0);
        statsButton.setPrefSize(90,30);

        getChildren().addAll(addButton, deleteButton, statsButton);
    }
}
