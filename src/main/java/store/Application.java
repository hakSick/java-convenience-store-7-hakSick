package store;

import controller.StoreController;

public class Application {
    public static void main(String[] args) {
        StoreController controller = new StoreController();
        controller.run();
    }
}
