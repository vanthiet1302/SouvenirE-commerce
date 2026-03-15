package nlu.fit.web.souvenirecommerce.dao;

import nlu.fit.web.souvenirecommerce.model.Promotion;
import nlu.fit.web.souvenirecommerce.util.JdbiFactory;
import org.jdbi.v3.core.Jdbi;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromotionDAO {
    private Jdbi jdbi;
    public PromotionDAO() throws IOException {
        this.jdbi = JdbiFactory.getJdbi();
    }
    //SQL
    private static final String SELECT_ACTIVE_PROMOTION = """
        SELECT id, product_id, discount_percent, start_date, end_date
        FROM promotions
        WHERE product_id = :productId
          AND (start_date IS NULL OR start_date <= NOW())
          AND (end_date IS NULL OR end_date >= NOW())
        ORDER BY discount_percent DESC
        LIMIT 1
    """;
    private static final String SELECT_ACTIVE_PROMOTIONS_BY_PRODUCTS = """
        SELECT id, product_id, discount_percent, start_date, end_date
        FROM promotions
        WHERE product_id IN (<ids>)
          AND (start_date IS NULL OR start_date <= NOW())
          AND (end_date IS NULL OR end_date >= NOW())
        ORDER BY product_id, discount_percent DESC
    """;
    // method
    public Promotion getActivePromotionByProductId(int productId) {
        return jdbi.withHandle(handle -> handle.createQuery(SELECT_ACTIVE_PROMOTION).bind("productId",productId).mapToBean(Promotion.class).findOne().orElse(null));
    }
    public Map<String, Promotion> getActivePromotionsByProductIds(List<String> productIds) {
        Map<String,Promotion> map = new HashMap<>();
        if (productIds == null || productIds.isEmpty()) {
            return map;
        }
        List<Promotion> promotions = jdbi.withHandle(handle -> handle.createQuery(SELECT_ACTIVE_PROMOTIONS_BY_PRODUCTS).bindList("ids",productIds).mapToBean(Promotion.class).list());
        for (Promotion p : promotions){
            map.putIfAbsent(p.getProductId(),p);
        }
        return map;
    }

}
