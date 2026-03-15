package nlu.fit.web.souvenirecommerce.dao;

import nlu.fit.web.souvenirecommerce.model.Product;
import nlu.fit.web.souvenirecommerce.util.JdbiFactory;
import org.jdbi.v3.core.Jdbi;

import java.io.IOException;

import java.util.List;

public class ProductDAO {
    // SQL
    private static final String BASE_SELECT = """
            SELECT  p.id, p.category_id, p.name, p.description, p.original_price, p.image_url, p.stock_quantity, p.total_sold,
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
            GROUP BY p.id, p.category_id, p.name, p.description, p.original_price, p.image_url, p.stock_quantity, p.total_sold
            """;
    private Jdbi jdbi;

    public ProductDAO() throws IOException, ClassNotFoundException {
        this.jdbi = JdbiFactory.getJdbi();
    }

    // Home
    // Best selling
    public List<Product> getBestSellingProducts(int limit) {
        String sql = BASE_SELECT + " ORDER BY p.total_sold DESC LIMIT : limit";
        return jdbi.withHandle(handle -> handle.createQuery(sql).bind("limit", limit).mapToBean(Product.class).list());
    }

    // Newest Product
    public List<Product> getNewestProducts(int limit) {
        String sql = BASE_SELECT + " ORDER BY p.id DESC LIMIT : limit";
        return jdbi.withHandle(handle -> handle.createQuery(sql).bind("limit", limit).mapToBean(Product.class).list());
    }

    // Top rated
    public List<Product> getTopRatedProducts(int limit) {
        String sql = BASE_SELECT + " ORDER BY avg_rating DESC, review_count DESC LIMIT : limit";
        return jdbi.withHandle(handle -> handle.createQuery(sql).bind("limit", limit).mapToBean(Product.class).list());

    }

    // Product detail
    public Product getProductById(int id) {
        String sql = "SELECT * FROM (" + BASE_SELECT + ") t WHERE t.id = :id";

        return jdbi.withHandle(handle -> handle.createQuery(sql)
                .bind("id", id)
                .mapToBean(Product.class)
                .findOne()
                .orElse(null));
    }
}
