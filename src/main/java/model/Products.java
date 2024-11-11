package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Products {
    private static final String FILE_PATH = "src/main/resources/products.md";

    public String name;
    public int price;
    public int quantity;
    public String promotion;

    public Products(String name, int price, int quantity, String promotion) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.promotion = promotion.trim();
    }

    @Override
    public String toString() {
        return "Products{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", promotion='" + promotion + '\'' +
                '}';
    }

    public List<Products> loadProducts() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            return br.lines().skip(1)
                    .map(line -> line.split(","))
                    .map(values -> new Products(values[0], Integer.parseInt(values[1]), Integer.parseInt(values[2]),
                            values[3])).toList();
        } catch (IOException e) {
            throw new IllegalArgumentException("파일 읽기 중 오류 발생.");
        }
    }
}
