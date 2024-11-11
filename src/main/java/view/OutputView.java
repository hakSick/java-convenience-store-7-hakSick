package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Objects;
import model.Order;
import model.Products;

public class OutputView {
    static final String MARK = "- ";

    public static void printWelcomeList(List<Products> productsList) {
        System.out.println("안녕하세요. W편의점입니다\n현재 보유하고 있는 상품입니다.\n");
        for (Products product : productsList) {
            int pricenum = product.price;
            String price = priceChange(pricenum);
            String output = MARK + product.name + " " + price + "원 ";
            output = productCheck(product, output);
            System.out.println(output);
        }
        System.out.println("");
    }

    public static String finalReceipt(List<Order> orders, List<Products> productsList) {
        System.out.println("==============W 편의점================");
        System.out.println("상품명\t\t\t수량\t금액");
        int totalcost = printBuy(orders, productsList);
        System.out.println("=============증\t정===============");
        System.out.println("====================================");
        printResult(orders, totalcost);
        System.out.println("감사합니다. 구매하고 싶은 다른 상품이 있나요? (Y/N)");
        return Console.readLine();
    }

    public static void printResult(List<Order> orders, int totalcost) {
        int totalorder = 0;
        String total = priceChange(totalcost);
        for (Order order : orders) {
            totalorder += order.buycount;
        }
        System.out.println("총구매액\t\t" + totalorder + "\t" + total);
        System.out.println("내실돈\t\t\t "+total+"\n");
    }

    public static int printBuy(List<Order> orders, List<Products> productsList) {
        int totalCost2 = 0;
        for (Order order : orders) {
            Products matchingProduct = productsList.stream()
                    .filter(product -> product.name.equals(order.buyname))
                    .findFirst()
                    .orElse(null);
            int totalCost = order.buycount * matchingProduct.price;
            totalCost2 += order.buycount * matchingProduct.price;
            System.out.println(order.buyname + "\t\t" + order.buycount + "\t" + totalCost);
        }
        return totalCost2;
    }

    public static String priceChange(int pricenum) {
        int mprice = pricenum / 1000;
        int hprice = pricenum % 1000;
        String price = (mprice > 0 ? mprice + "," : "") + String.format("%03d", hprice);
        return price;
    }

    public static String productCheck(Products product, String output) {
        if (product.quantity.equals("재고 없음")) {
            output += "재고 없음";
        }
        if (!product.quantity.equals("재고 없음")) {
            output += product.quantity + "개";
        }
        if (!Objects.equals(product.promotion, "null")) {
            output += " " + product.promotion;
        }
        return output;
    }
}
