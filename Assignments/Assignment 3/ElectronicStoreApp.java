import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ElectronicStoreApp extends Application {
    private ElectronicStore model;
    private ElectronicStoreView view;

    public void start(Stage primaryStage) {
        model = ElectronicStore.createStore();
        view = new ElectronicStoreView(model);

        view.getReset().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model = ElectronicStore.createStore();
                view.resetStore(model);
                view.update();
            }
        });
        view.getAddCart().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                int index = view.getStockList().getSelectionModel().getSelectedIndex();
                if (index >= 0) {
                    model.addProductToCart(index);
                    view.update();
                }
            }
        });
        view.getRemoveCart().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                int index = view.getCartList().getSelectionModel().getSelectedIndex();
                if (index >= 0) {
                    model.removeProductCart(index);
                    view.update();
                }
            }
        });
        view.getCompleteSale().setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent actionEvent) {
                model.sellProducts();
                model.incrementNumSales();
                view.getCartList().setItems(FXCollections.observableArrayList());
                view.update();
            }
        });

        view.getStockList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.getAddCart().setDisable(view.getStockList().getSelectionModel().getSelectedIndex() < 0);
            }
        });
        view.getCartList().setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                view.getRemoveCart().setDisable(view.getCartList().getSelectionModel().getSelectedIndex() < 0);
            }
        });

        primaryStage.setTitle("Electronic Store Application - " + model.getName());
        primaryStage.setScene(new Scene(view, 800, 400));
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) { launch(args); }
}
