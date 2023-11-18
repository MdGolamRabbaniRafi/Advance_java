import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        try {
            User user;
            if(DBUtil.searchUser(email,password)!=null)
            {
                user =DBUtil.searchUser(email,password);
                HttpSession session = request.getSession();
                session.setAttribute("email", email);
                session.setAttribute("FullName", user.getFullName());
                response.sendRedirect("welcome.jsp");
            }
            else {
                response.sendRedirect("login.jsp?error=1");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }


    }
}
