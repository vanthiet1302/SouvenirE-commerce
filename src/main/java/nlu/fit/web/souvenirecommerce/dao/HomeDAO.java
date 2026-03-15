package nlu.fit.web.souvenirecommerce.dao;

import nlu.fit.web.souvenirecommerce.model.Category;
import nlu.fit.web.souvenirecommerce.model.Product;
import nlu.fit.web.souvenirecommerce.util.JdbiFactory;
import org.jdbi.v3.core.Jdbi;

import java.io.IOException;
import java.util.List;

public class HomeDAO {
    private final Jdbi jdbi;

    public HomeDAO() throws IOException {
        this.jdbi = JdbiFactory.getJdbi();
    }
    // SQL
    private static final String SELECT_BANNER_CATEGORIES = """
        SELECT c.id, c.category_name AS name, c.image
        FROM categories c
        JOIN products p ON c.id = p.category_id
        GROUP BY c.id, c.category_name, c.image
        ORDER BY SUM(p.total_sold) DESC
        LIMIT :limit
    """;
    private static final String SELECT_TOP_CATEGORY_PRODUCTS = """
        SELECT p.id, p.category_id, p.name, p.description, p.original_price, p.image_url, p.stock_quantity, p.total_sold,
               COALESCE(ROUND(AVG(r.rating), 1), 0) AS avg_rating,
               COUNT(r.id) AS review_count,
            CASE
                WHEN MAX(pr.discount_percent) IS NOT NULL
                THEN ROUND(p.original_price * (100 - MAX(pr.discount_percent)) / 100, 2)
                ELSE NULL
            END AS sale_price
        FROM products p
        LEFT JOIN reviews r ON p.id = r.product_id
        LEFT JOIN promotions pr ON p.id = pr.product_id
             AND (pr.start_date IS NULL OR pr.start_date <= NOW())
             AND (pr.end_date IS NULL OR pr.end_date >= NOW())
        WHERE p.category_id = :categoryId
        GROUP BY p.id, p.category_id, p.name, p.description, p.original_price, p.image_url, p.stock_quantity, p.total_sold
        ORDER BY p.total_sold DESC
        LIMIT :limit
    """;
    private static final String SELECT_ALL = """
        SELECT id, category_name AS name, image
        FROM categories
        LIMIT :limit
    """;

    private static final String SELECT_EXTENSION_CATEGORIES = """
        SELECT id, category_name AS name, image
        FROM categories
        WHERE id NOT IN (<ids>)
        LIMIT :limit
    """;
    // method
    public List<Category> getBannerCategories(int limit){
        return jdbi.withHandle(handle -> handle.createQuery(SELECT_BANNER_CATEGORIES).bind("limit",limit).mapToBean(Category.class).list());
    }
    public List<Product> getTopProductsByCategory(int categoryId, int limit){
        return jdbi.withHandle(handle -> handle.createQuery(SELECT_TOP_CATEGORY_PRODUCTS).bind("categoryId",categoryId).bind("limit",limit).mapToBean(Product.class).list());
    }
    public List<Category> getExtensionCategories(List<Integer> usedIds, int limit) {
        if (usedIds == null || usedIds.isEmpty()) {
            return jdbi.withHandle(handle -> handle.createQuery(SELECT_ALL).bind("limit",limit).mapToBean(Category.class).list());
        }
        return jdbi.withHandle(handle -> handle.createQuery(SELECT_EXTENSION_CATEGORIES).bindList("ids",usedIds).bind("limit",limit).mapToBean(Category.class).list());
    }


}
