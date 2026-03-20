package nlu.fit.web.souvenirecommerce.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import nlu.fit.web.souvenirecommerce.service.HomeService;

import java.io.IOException;

@WebServlet(urlPatterns = {"/home"})
public class HomeController extends HttpServlet {

    private HomeService homeService;

    @SneakyThrows
    @Override
    public void init() {
        homeService = new HomeService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // data
        request.setAttribute("bannerCategories", homeService.getBannerCategories());
        request.setAttribute("topCategories", homeService.getTopCategoryWithProducts());
        request.setAttribute("extensionCategories", homeService.ExtensionCategories());
        request.setAttribute("topRatedProducts", homeService.topRated());
        request.setAttribute("newestProducts", homeService.newest());


    }

    }
