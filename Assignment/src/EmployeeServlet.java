import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        HttpSession session = request.getSession();

        if (request.getParameter("addButton") != null) {
            Employee employee = createEmployee(request);
            List<Employee> employeeList = (List<Employee>) session.getAttribute("employeeList");
            if (employeeList == null) {
                employeeList = new ArrayList<>();
            }

            employeeList.add(employee);

            session.setAttribute("employeeList", employeeList);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else if (request.getParameter("detailsButton") != null) {
            List<Employee> employeeList = (List<Employee>) session.getAttribute("employeeList");

            response.getWriter().println("<html><body>");
            response.getWriter().println("<h2>All Employee Details:</h2>");

            if (employeeList != null && !employeeList.isEmpty()) {
                for (Employee employee : employeeList) {
                    displayEmployeeDetails(response, employee);
                    response.getWriter().println("<hr>");
                }
            } else {
                response.getWriter().println("<p>No employees added yet.</p>");
            }

            response.getWriter().println("<a href=\"/Lab_Task_1/index.jsp\">Back</a>");
            response.getWriter().println("</body></html>");
        }
    }

    private Employee createEmployee(HttpServletRequest request) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Date dateOfBirth = null;
        Date joiningDate = null;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            dateOfBirth = dateFormat.parse(request.getParameter("dateOfBirth"));
            joiningDate = dateFormat.parse(request.getParameter("joiningDate"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        String email = request.getParameter("email");
        int employeeType = Integer.parseInt(request.getParameter("employeeType"));

        if (employeeType == 1) {
            return new Officer(id, name, dateOfBirth, email, joiningDate);
        } else if (employeeType == 2) {
            return new Staff(id, name, dateOfBirth, email, joiningDate);
        } else {
            throw new IllegalArgumentException("Invalid employee type. Use 1 for Officer or 2 for Staff.");
        }
    }
    private void displayEmployeeDetails(HttpServletResponse response, Employee employee) throws IOException {
        response.getWriter().println("<h3>Employee Details:</h3>");
        response.getWriter().println("<p> Id : " + employee.getId() + "</p>");
        response.getWriter().println("<p> Name : " + employee.getName() + "</p>");
        response.getWriter().println("<p> Email : " + employee.getEmail() + "</p>");
        response.getWriter().println("<p> DOB : " + employee.getDateOfBirth() + "</p>");
        response.getWriter().println("<p> Joining Date : " + employee.getJoiningDate() + "</p>");

        Leave leave = employee.calculateLeave();
        response.getWriter().println("<h3>Leave Information:</h3>");
        response.getWriter().println("<p>Vacation Leave: " + leave.getVacationLeave() + "</p>");
        response.getWriter().println("<p>Sick Leave: " + leave.getSickLeave() + "</p>");
    }
}
