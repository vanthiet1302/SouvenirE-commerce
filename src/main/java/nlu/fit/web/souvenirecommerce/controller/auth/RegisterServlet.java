package nlu.fit.web.souvenirecommerce.controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import nlu.fit.web.souvenirecommerce.service.auth.AuthService;

import java.io.IOException;
import java.time.LocalDate;

@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        boolean isLoggedIn = (session != null && session.getAttribute("user") != null);

        if (!isLoggedIn) {
            req.getRequestDispatcher("/WEB-INF/views/auth/register.jsp").forward(req, resp);
        } else {
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lastName = req.getParameter("lastName");
        String firstName = req.getParameter("firstName");
        String gender= req.getParameter("gender");
        String email = req.getParameter("email");
        String username = req.getParameter("username");
        LocalDate dob = LocalDate.parse(req.getParameter("dateOfBirth"));
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        /// Giả bộ validate hết rồi đi
        AuthService  authService = new AuthService();
        try {
            authService.registerUser(lastName, firstName, gender, email, username, dob, password, 1, 1);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
