package model;

import java.util.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ModelTest {
    @Test
    void testLoadPromotions() {
        Promotions promotions = new Promotions("", 0, 0, "", "");

        List<Promotions> promotionsList = promotions.loadPromotions();

        Promotions firstPromotion = promotionsList.getFirst();

        Promotions expectedPromotion = new Promotions("탄산2+1", 2, 1, "2024-01-01", "2024-12-31");

        assertEquals(expectedPromotion.toString(), firstPromotion.toString(), "잘못된 파일 불러오기");
    }

    @Test
    void testLoadProducts() {
        Products products = new Products("", 0, 0,  "");

        List<Products> productsList = products.loadProducts();

        Products firstProduct = productsList.getFirst();

        Products expectedProduct = new Products("콜라",1000,10,"탄산2+1");

        assertEquals(expectedProduct.toString(), firstProduct.toString(), "잘못된 파일 불러오기");
    }
}
