package controller.adminUser;

import java.io.IOException;

import bean.AdminBeans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/admin_create_user")
public class CreateUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public CreateUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AdminBeans adminInfo = (AdminBeans) session.getAttribute("adminBeans");
		
		if (adminInfo != null) {
			String view = "/WEB-INF/views/adminCreateUser.jsp";
	        request.getRequestDispatcher(view).forward(request, response);
		} else {
			response.sendRedirect("admin_login");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
