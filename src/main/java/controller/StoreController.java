package controller;

import java.util.List;
import model.Products;
import view.OutputView;

public class StoreController {

    private final List<Products> productsList;

    public StoreController() {
        Products products = new Products("", 0, 0, "");
        this.productsList = products.loadProducts();
    }
    public void run() {
        OutputView.printWelcomeList(productsList);
    }
}
