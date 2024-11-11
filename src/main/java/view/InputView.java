package view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String askOrderList() {
        System.out.println("구매하실 상품명과 수량을 입력해 주세요. (예: [사이다-2],[감자칩-1])");
        return Console.readLine();
    }

    public String askMembership(){
        System.out.println("\n멤버십 할인을 받으시겠습니까? (Y/N)");
        return Console.readLine();
    }
}
