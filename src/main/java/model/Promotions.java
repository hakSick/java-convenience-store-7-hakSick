package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Promotions {
    private static final String FILE_PATH = "src/main/resources/promotions.md";

    private String name;
    private int buy;
    private int get;
    private String startDate;
    private String endDate;

    public Promotions(String name, int buy, int get, String startDate, String endDate) {
        this.name = name;
        this.buy = buy;
        this.get = get;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public List<Promotions> loadPromotions() {
        List<Promotions> promotions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
            String line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                Promotions promotion = new Promotions(values[0], Integer.parseInt(values[1]),
                        Integer.parseInt(values[2]), values[3], values[4]);
                promotions.add(promotion);
            }
        } catch (IOException e) {
            System.err.println("파일 읽기 중 오류 발생: " + e.getMessage());
        }
        return promotions;
    }
}
