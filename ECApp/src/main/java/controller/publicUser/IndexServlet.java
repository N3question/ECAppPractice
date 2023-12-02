package controller.publicUser;

import java.io.IOException;
import java.util.ArrayList;

import bean.ItemBeans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.SelectAllItemModel;

@WebServlet("/index")
public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public IndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<ItemBeans> itemBeans = SelectAllItemModel.selectAll();
		request.setAttribute("itemBeans", itemBeans);
		String view = "/WEB-INF/views/index.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}
}
