import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.ArrayList;


public class ElectronicStoreView extends Pane {
    private ElectronicStore model;

    private Label currentCart;

    private Button resetStore;
    private Button addCart;
    private Button removeCart;
    private Button completeSale;

    private TextField salesField;
    private TextField revenueField;
    private TextField $persaleField;

    private ListView<String> stockList;
    private ListView<String> mostPopularList;
    private ListView<String> cartList;

    public ElectronicStoreView(ElectronicStore es) {
        model = es;

        Label summary = new Label("Store Summary:");
        summary.relocate(70, 20);
        Label num_sales = new Label("# Sales:");
        num_sales.relocate(48, 45);
        Label revenue = new Label("Revenue:");
        revenue.relocate(40, 70);
        Label $_per_sale = new Label("$ / Sale:");
        $_per_sale.relocate(46, 95);
        Label popular = new Label("Most Popular Items:");
        popular.relocate(50, 140);
        Label stock = new Label("Store Stock:");
        stock.relocate(300, 20);
        currentCart = new Label("Current Cart: ($0.00)");
        currentCart.relocate(580, 20);

        resetStore = new Button("Reset Store");
        resetStore.setDisable(false);
        resetStore.relocate(25, 335);
        resetStore.setPrefSize(125, 50);

        addCart = new Button("Add to Cart");
        addCart.setDisable(true);
        addCart.relocate(250, 335);
        addCart.setPrefSize(125, 50);

        removeCart = new Button("Remove from Cart");
        removeCart.setDisable(true);
        removeCart.relocate(500, 335);
        removeCart.setPrefSize(125, 50);

        completeSale = new Button("Complete Sale");
        completeSale.setDisable(true);
        completeSale.relocate(630, 335);
        completeSale.setPrefSize(125, 50);

        salesField = new TextField();
        salesField.relocate(90, 42);
        salesField.setPrefSize(90, 25);
        salesField.setText("0");

        revenueField = new TextField();
        revenueField.relocate(90, 67);
        revenueField.setPrefSize(90, 25);
        revenueField.setText(String.format("$%.2f", model.getRevenue()));

        $persaleField = new TextField();
        $persaleField.relocate(90, 92);
        $persaleField.setPrefSize(90, 25);
        $persaleField.setText("N/A");

        stockList = new ListView<String>();
        ObservableList<String> list = FXCollections.observableArrayList(model.getStockString());
        stockList.setItems(list);
        stockList.relocate(200, 38);
        stockList.setPrefSize(270, 280);

        mostPopularList = new ListView<String>();
        ObservableList<String> list1 = FXCollections.observableArrayList(model.getStartingPopular());
        mostPopularList.setItems(list1);
        mostPopularList.relocate(20, 160);
        mostPopularList.setPrefSize(160, 158);

        cartList = new ListView<String>();
        ObservableList<String> list2 = FXCollections.observableArrayList();
        cartList.setItems(list2);
        cartList.relocate(500, 38);
        cartList.setPrefSize(270, 280);

        // Labels
        getChildren().addAll(summary, num_sales, revenue, $_per_sale, popular, stock, currentCart);

        // Buttons
        getChildren().add(resetStore);
        getChildren().add(addCart);
        getChildren().add(removeCart);
        getChildren().add(completeSale);

        // TextFields
        getChildren().add(salesField);
        getChildren().add(revenueField);
        getChildren().add($persaleField);

        // Lists
        getChildren().add(stockList);
        getChildren().add(mostPopularList);
        getChildren().add(cartList);
    }

    public Button getReset() { return resetStore; }
    public Button getAddCart() { return addCart; }
    public Button getRemoveCart() { return removeCart; }
    public Button getCompleteSale() { return completeSale; }

    public ListView<String> getStockList() { return stockList; }
    public ListView<String> getCartList() { return cartList; }

    public void resetStore(ElectronicStore es) {
        this.model = es;
        $persaleField.setText("N/A");
    }

    public void update() {
        stockList.setItems(FXCollections.observableArrayList(model.getStockString()));
        mostPopularList.setItems(FXCollections.observableArrayList(model.getMostPopular()));
        cartList.setItems(FXCollections.observableArrayList(model.getCurCart()));

        salesField.setText(Integer.toString(model.getNumSales()));
        revenueField.setText(String.format("$%.2f", model.getRevenue()));
        if (model.getNumSales() > 0) {
            $persaleField.setText(String.format("$%.2f", model.getRevenue() / model.getNumSales()));
        }
        currentCart.setText("Current Cart: (" + model.getCartMoney() + ")");

        addCart.setDisable(stockList.getSelectionModel().getSelectedIndex() < 0);
        removeCart.setDisable(cartList.getSelectionModel().getSelectedIndex() < 0);
        completeSale.setDisable(cartList.getItems().size() <= 0);
    }
}
