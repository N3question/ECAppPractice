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
import model.SelectAllItemModel;

@WebServlet("/admin_index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AdminUserBeans adminInfo = (AdminUserBeans) session.getAttribute("adminBeans");
		
		if (adminInfo != null) {
			ArrayList<ItemBeans> itemBeans = SelectAllItemModel.selectAll();
			request.setAttribute("itemBeans", itemBeans);
			String view = "/WEB-INF/views/adminIndex.jsp";
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
