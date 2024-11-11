package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import model.Order;

public class InputView {

    public static List<Order> askOrderList() {
        System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])");
        String input = Console.readLine();

        return Arrays.stream(input.split("\\],\\["))
                .map(item -> item.replace("[", "").replace("]", "").split("-"))
                .filter(parts -> parts.length == 2)
                .map(parts -> new Order(parts[0], Integer.parseInt(parts[1])))
                .toList();
    }
}
