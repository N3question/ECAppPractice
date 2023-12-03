package controller.publicUser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

import bean.ItemBeans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.SelectAllItemModel;
import model.SelectItemModel;

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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ArrayList<HashMap<Integer, Integer>> cartList = (ArrayList<HashMap<Integer, Integer>>)session.getAttribute("cartList");
		
		if (cartList == null) {
			cartList = new ArrayList<HashMap<Integer, Integer>>();
			HashMap<Integer, Integer> hashMap = putInteger(request);
			cartList.add(hashMap);
		} else {
			HashMap<Integer, Integer> hashMap = putInteger(request);
			cartList.add(hashMap);
		}
		session.setAttribute("cartList", cartList);
		
		int itemId = Integer.parseInt(request.getParameter("item_id"));
		ItemBeans itemBeans = SelectItemModel.select(itemId);
		request.setAttribute("itemBeans", itemBeans);
		
		String view = "/WEB-INF/views/cart.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}
	
	protected HashMap<Integer, Integer> putInteger(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int itemId = Integer.parseInt(request.getParameter("item_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		hashMap.put(itemId, quantity);
		return hashMap;
	}
}
