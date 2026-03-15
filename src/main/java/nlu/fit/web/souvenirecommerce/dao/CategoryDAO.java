package nlu.fit.web.souvenirecommerce.dao;

import nlu.fit.web.souvenirecommerce.model.Category;
import nlu.fit.web.souvenirecommerce.util.JdbiFactory;
import org.jdbi.v3.core.Jdbi;

import java.io.IOException;
import java.util.List;

public class CategoryDAO {
    private Jdbi jdbi;

    public CategoryDAO() throws IOException, ClassNotFoundException {
        this.jdbi = JdbiFactory.getJdbi();
    }
    //SQL
    private static final String SELECT_ALL = """
        SELECT id, category_name AS name, image
        FROM categories
        ORDER BY id DESC
    """;
    private static final String SELECT_BY_ID = """
        SELECT id, category_name AS name, image
        FROM categories
        WHERE id = :id
    """;
    private static final String SELECT_TOP_SELLING = """
        SELECT c.id, c.category_name AS name, c.image
        FROM categories c
        JOIN products p ON c.id = p.category_id
        GROUP BY c.id, c.category_name, c.image
        ORDER BY SUM(p.total_sold) DESC LIMIT :limit
    """;
    private static final String SELECT_TOP_SELLING_IDS = """
        SELECT category_id
        FROM products
        GROUP BY category_id
        ORDER BY SUM(total_sold) DESC LIMIT :limit
    """;
    private static final String SELECT_NOTIN = """
        SELECT id, category_name AS name, image
        FROM categories
        WHERE id NOT IN (<ids>)
    """;
    // method
    public List<Category> getAlCategories(){
        return jdbi.withHandle(handle -> handle.createQuery(SELECT_ALL).mapToBean(Category.class).list());
    }
    public Category getCategoryById(int id){
        return jdbi.withHandle(handle -> handle.createQuery(SELECT_BY_ID).bind("id",id).mapToBean(Category.class).findOne().orElse(null));
    }
    public List<Category> getTopSellingCategories(int limit){
        return jdbi.withHandle(handle -> handle.createQuery(SELECT_TOP_SELLING).bind("limit",limit).mapToBean(Category.class).list());
    }
    public List<Integer> getTopSellingCategoriesIds(int limit){
        return jdbi.withHandle(handle -> handle.createQuery(SELECT_TOP_SELLING_IDS).bind("limit",limit).mapTo(Integer.class).list());
    }
    public List<Category> getCategoriesNotIn(List<Integer> usedIds){
        if(usedIds == null || usedIds.isEmpty()){
            return getAlCategories();
        }
        return jdbi.withHandle(handle -> handle.createQuery(SELECT_NOTIN).bindList("ids",usedIds).mapToBean(Category.class).list());
    }


}
