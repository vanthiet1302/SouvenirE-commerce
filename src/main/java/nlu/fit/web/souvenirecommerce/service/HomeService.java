package nlu.fit.web.souvenirecommerce.service;

import nlu.fit.web.souvenirecommerce.dao.CategoryDAO;
import nlu.fit.web.souvenirecommerce.dao.HomeDAO;
import nlu.fit.web.souvenirecommerce.dao.ProductDAO;
import nlu.fit.web.souvenirecommerce.dto.CategoryWithProductDTO;
import nlu.fit.web.souvenirecommerce.model.Category;
import nlu.fit.web.souvenirecommerce.model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class HomeService {
    private final HomeDAO homeDAO = new HomeDAO();
    private final ProductDAO productDAO = new ProductDAO();
    private final CategoryDAO categoryDAO = new CategoryDAO();


    private static final int BANNER_LIMIT = 5;
    private static final int TOP_CATEGORY_LIMIT = 5;
    private static final int CATEGORY_PRODUCT_LIMIT = 4;
    private static final int EXTENSION_LIMIT = 6;
    private static final int TOP_RATED_LIMIT = 4;
    private static final int NEWEST_LIMIT = 4;


    public HomeService() throws IOException, ClassNotFoundException {
    }
    // banner
    public List<Category> getBannerCategories(){
        return homeDAO.getBannerCategories(BANNER_LIMIT);
    }
    //home
    public List<CategoryWithProductDTO> getTopCategoryWithProducts(){
        List<Category> Topca = homeDAO.getBannerCategories(TOP_CATEGORY_LIMIT);
        List<CategoryWithProductDTO> result = new ArrayList<>();
        for (Category category : Topca){
            List< Product> products = homeDAO.getTopProductsByCategory(category.getId(),CATEGORY_PRODUCT_LIMIT);
            result.add(new CategoryWithProductDTO(category,products));
        }
        return result;
    }
    public List<Category> ExtensionCategories(){
        List<Integer> usedId = categoryDAO.getTopSellingCategoriesIds(TOP_CATEGORY_LIMIT);
        return homeDAO.getExtensionCategories(usedId ,EXTENSION_LIMIT);
    }
    public List<Product> topRated(){
        return productDAO.getTopRatedProducts(TOP_RATED_LIMIT);
    }
    public List<Product> newest(){
        return productDAO.getNewestProducts(NEWEST_LIMIT);
    }

}
