package nlu.fit.web.souvenirecommerce.controller.auth;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import nlu.fit.web.souvenirecommerce.dao.UserDao;
import nlu.fit.web.souvenirecommerce.model.User;

import java.io.IOException;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fullName = request.getParameter("full_name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm_password");

        // KIỂM TRA ĐỊNH DẠNG (VALIDATION)
        String emailRegex = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
        if (email == null || !email.matches(emailRegex)) {
            request.setAttribute("error", "Invalid email format!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        if (phone == null || !phone.matches("\\d{10}")) {
            request.setAttribute("error", "Phone number must be exactly 10 digits!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        if (password == null || password.length() < 8) {
            request.setAttribute("error", "Password must be at least 8 characters!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        if (!password.equals(confirmPassword)) {
            request.setAttribute("error", "Confirmation password does not match!");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
            return;
        }

        UserDao dao = new UserDao();
        boolean isRegistered = dao.register(email, password, fullName, phone);

        if (isRegistered) {
            request.setAttribute("success", "Registration successful! You can now log in.");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        } else {
            request.setAttribute("error", "Registration failed! Email might already be in use.");
            request.getRequestDispatcher("signup.jsp").forward(request, response);
        }
    }
}
