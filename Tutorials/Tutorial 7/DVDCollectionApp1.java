import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.event.*;

public class DVDCollectionApp1  extends Application {

    private DVDCollection model;

    public DVDCollectionApp1() {
        model = DVDCollection.example1();
    }

    public void start(Stage primaryStage) {
        Pane  aPane = new Pane();

        // Create the view
        DVDCollectionAppView1  view = new DVDCollectionAppView1();
        aPane.getChildren().add(view);
        view.update(model, 0);

        view.getButtonPane().getAddButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                String t = javax.swing.JOptionPane.showInputDialog("Please enter a title:");
                String y = javax.swing.JOptionPane.showInputDialog("Please enter a year:");
                String l = javax.swing.JOptionPane.showInputDialog("Please enter a duration (in minutes):");
                model.add(new DVD(t, Integer.parseInt(y), Integer.parseInt(l)));
                view.update(model, 0);
            }
        });

        view.getButtonPane().getDeleteButton().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.remove(view.getTitleList().getSelectionModel().getSelectedItem());
                view.update(model, 0);
            }
        });

        view.getTitleList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.getTitleList().getSelectionModel().select(view.getTitleList().getSelectionModel().getSelectedIndex());
                view.getYearList().getSelectionModel().select(view.getTitleList().getSelectionModel().getSelectedIndex());
                view.getLengthList().getSelectionModel().select(view.getTitleList().getSelectionModel().getSelectedIndex());
            }
        });

        view.getYearList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.getTitleList().getSelectionModel().select(view.getYearList().getSelectionModel().getSelectedIndex());
                view.getYearList().getSelectionModel().select(view.getYearList().getSelectionModel().getSelectedIndex());
                view.getLengthList().getSelectionModel().select(view.getYearList().getSelectionModel().getSelectedIndex());
            }
        });

        view.getLengthList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.getTitleList().getSelectionModel().select(view.getLengthList().getSelectionModel().getSelectedIndex());
                view.getYearList().getSelectionModel().select(view.getLengthList().getSelectionModel().getSelectedIndex());
                view.getLengthList().getSelectionModel().select(view.getLengthList().getSelectionModel().getSelectedIndex());
            }
        });

        primaryStage.setTitle("My DVD Collection");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(aPane));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}