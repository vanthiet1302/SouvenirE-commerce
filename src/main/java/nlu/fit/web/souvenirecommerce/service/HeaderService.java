package nlu.fit.web.souvenirecommerce.service;

import nlu.fit.web.souvenirecommerce.dao.CategoryDAO;
import nlu.fit.web.souvenirecommerce.model.Category;

import java.io.IOException;
import java.util.List;

public class HeaderService {
    private final CategoryDAO categoryDAO = new CategoryDAO();

    public HeaderService() throws IOException, ClassNotFoundException {
    }
    public List<Category> getAll(){
        return categoryDAO.getAlCategories();
    }
    public List<Category> getTop(int limit){
        return categoryDAO.getTopSellingCategories(limit);
    }
}
