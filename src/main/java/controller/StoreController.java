package controller;

import static view.InputView.askOrderList;
import static view.OutputView.finalReceipt;

import java.util.List;
import model.Order;
import model.Products;
import view.OutputView;
import view.OutputView;

public class StoreController {

    private final List<Products> productsList;
    private final InputIsValid inputValidator;

    public StoreController() {
        Products products = new Products("", 0, "", "");
        this.productsList = products.loadProducts();
        this.inputValidator = new InputIsValid(productsList);
    }

    public void run() {
        OutputView.printWelcomeList(productsList);
        String userInput = askOrderList();
        List<Order> orders = inputValidator.validateOrderInput(userInput);
        finalReceipt(orders, productsList);
    }


}
