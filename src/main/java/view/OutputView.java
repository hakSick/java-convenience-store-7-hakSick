package view;

import java.util.List;
import java.util.Objects;
import model.Products;

public class OutputView {
    static final String MARK = "- ";

    public static void printWelcomeList(List<Products> productsList) {
        System.out.println("안녕하세요. W편의점입니다\n현재 보유하고 있는 상품입니다.\n");
        for (Products product : productsList) {
            String output = MARK + " " + product.name + " " + product.price + "원 " + product.quantity + "개";
            if (!Objects.equals(product.promotion, "null")) {
                output += " " + product.promotion;
            }
            System.out.println(output);
        }
    }
}
