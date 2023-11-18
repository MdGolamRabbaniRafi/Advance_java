import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        String email = request.getParameter("email");
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        try {
            DBUtil.create(fullname,email,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch ( ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        response.sendRedirect("login.jsp");
    }
}
