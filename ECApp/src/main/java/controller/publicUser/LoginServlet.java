package controller.publicUser;

import java.io.IOException;
import java.util.ArrayList;

import bean.ItemBeans;
import bean.PublicUserBeans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.SelectAllItemModel;
import model.SelectPublicUserModel;

@WebServlet("/user_login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/userLogin.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		
		SelectPublicUserModel.select(userName, password, request);
		
		HttpSession session = request.getSession();
		PublicUserBeans sessionUserInfo = (PublicUserBeans)session.getAttribute("PUBeans");
		
		if (sessionUserInfo != null) {
			ArrayList<ItemBeans> itemBeans = SelectAllItemModel.selectAll();
			request.setAttribute("itemBeans", itemBeans);
			String view = "/WEB-INF/views/index.jsp";
	        request.getRequestDispatcher(view).forward(request, response);
		}
		doGet(request, response);
	}

}
