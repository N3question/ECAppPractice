package controller.publicUser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/map_remove")
public class MapRemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MapRemoveServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int index_num = Integer.parseInt(request.getParameter("index_num"));
		HttpSession session = request.getSession();
		ArrayList<HashMap<Integer, Integer>> cartList = (ArrayList<HashMap<Integer, Integer>>)session.getAttribute("cartList");
		
		cartList.remove(index_num);
		
		session.setAttribute("cartList", cartList);
		
		String view = "/WEB-INF/views/cart.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}
}
