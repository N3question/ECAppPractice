package controller.adminUser;

import java.io.IOException;
import java.util.ArrayList;

import bean.AdminUserBeans;
import bean.ItemBeans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.SelectAdminUserModel;
import model.SelectAllItemModel;

@WebServlet("/admin_login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/adminLogin.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String adminName = request.getParameter("admin_name");
		String adminPass = request.getParameter("admin_password");
		
		SelectAdminUserModel.select(adminName, adminPass, request);
		
		HttpSession session = request.getSession();
		AdminUserBeans adminInfo = (AdminUserBeans) session.getAttribute("adminBeans"); // getAttributeするときは Object が戻り値
		
		if (adminInfo != null) {
			ArrayList<ItemBeans> itemBeans = SelectAllItemModel.selectAll();
			request.setAttribute("itemBeans", itemBeans);
			String view = "/WEB-INF/views/adminIndex.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		} else {
			response.sendRedirect("admin_login");
		}
	}

}
