package controller.publicUser;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import bean.CartBeans;
import bean.ItemBeans;
import bean.PublicUserBeans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.SelectAllItemModel;
import model.SelectAllUserIdModel;

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
		ArrayList<PublicUserBeans> userIdList = SelectAllUserIdModel.selectAll();
		
		
		HttpSession session = request.getSession(true);
		ArrayList<CartBeans> cartList = (ArrayList<CartBeans>)session.getAttribute("cartList");
//		ArrayList<CartBeans> cartList = (ArrayList<CartBeans>)session.getAttribute("cartList");
		
		if (cartList == null) {
			cartList = new ArrayList<CartBeans>();
			CartBeans cartBeans = setInteger(request);
			cartList.add(cartBeans);
		} else {
			CartBeans cartBeans = setInteger(request);
			cartList.add(cartBeans);
		}
		session.setAttribute("cartList", cartList);
		
		String view = "/WEB-INF/views/cart.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}
	
	protected CartBeans setInteger(HttpServletRequest request) {
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		int itemId = Integer.parseInt(request.getParameter("item_id"));
		int userId = Integer.parseInt(request.getParameter("user_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		
		CartBeans cartBeans = new CartBeans(itemId, userId, quantity);
		return cartBeans;
	}
	
	protected void createSession(ArrayList<PublicUserBeans> userIdList, int sessionUserId, HttpServletRequest request, ArrayList<CartBeans> cartList) {
		for (int i = 0; i < userIdList.size(); i++) {
			// 配列から i 番目のユーザ情報を取得
			PublicUserBeans PUBeans = userIdList.get(i);
			// 取得した情報からuserのidをget 
			int userId = PUBeans.getUserId();
			// 文字列に変換
			String str = String.valueOf(userId);
	
			HttpSession session = request.getSession();
	        String user_id = str;
			// 指定したキーのsessionが存在するかを確認
			if (session.getAttribute(user_id) == null) {
				session.setAttribute(user_id, cartList);
			}
		}
	}
}
