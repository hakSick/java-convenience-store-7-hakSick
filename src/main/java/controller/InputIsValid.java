package controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import model.Order;
import model.Products;
import java.util.Scanner;

public class InputIsValid {

    private final List<Products> productsList;

    public InputIsValid(List<Products> productsList) {
        this.productsList = productsList;
    }

    public List<Order> validateOrderInput(String input) {
        List<Order> orders = null;
        boolean validInput = false;

        do {
            try {
                orders = processOrderInput(input); // 유효한 입력 처리
                validInput = true; // 입력이 유효하면 반복 종료
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                System.out.print("다시 입력해 주세요: ");
                input = Console.readLine();
            }
        } while (!validInput);

        return orders;
    }

    private List<Order> processOrderInput(String input) {
        validateFormat(input);
        return Arrays.stream(input.split("\\],\\["))
                .map(this::parseOrder)
                .toList();
    }

    private void validateFormat(String input) {
        if (!input.matches("(\\[[^\\]]*-\\d+\\],?)+")) {
            throw new IllegalArgumentException("올바르지 않은 형식으로 입력했습니다. 다시 입력해 주세요.");
        }
    }

    private Order parseOrder(String item) {
        String[] parts = item.replace("[", "").replace("]", "").split("-");
        if (parts.length != 2) {
            throw new IllegalArgumentException("잘못된 입력입니다. 다시 입력해 주세요.");
        }
        String buyname = parts[0];
        int buycount = Integer.parseInt(parts[1]);
        validateStock(buyname, buycount);
        return new Order(buyname, buycount);
    }

    private void validateStock(String buyname, int buycount) {
        Products product = productsList.stream()
                .filter(p -> p.name.equals(buyname))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 상품입니다. 다시 입력해 주세요."));
        if (buycount > Integer.parseInt(product.quantity)) {
            throw new IllegalArgumentException("재고 수량을 초과하여 구매할 수 없습니다. 다시 입력해 주세요.");
        }
    }
}