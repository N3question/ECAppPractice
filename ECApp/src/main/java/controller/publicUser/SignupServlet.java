package controller.publicUser;

import java.io.IOException;

import bean.PublicUserBeans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.InsertPublicUserModel;

@WebServlet("/user_signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String view = "/WEB-INF/views/userSignup.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("user_name");
		String password = request.getParameter("password");
		
		PublicUserBeans PUBeans = new PublicUserBeans(userName, password);
		String USER_NAME = PUBeans.getUserName();
		String PASS = PUBeans.getPassword();
		
		if (USER_NAME != null && PASS != null) {
			InsertPublicUserModel.insert(PUBeans);
			String view = "/WEB-INF/views/userLogin.jsp";
	        request.getRequestDispatcher(view).forward(request, response);
		}
		doGet(request, response);
	}

}
