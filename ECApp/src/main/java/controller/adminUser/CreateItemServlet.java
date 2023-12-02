package controller.adminUser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

import bean.AdminUserBeans;
import bean.CategoryBeans;
import bean.ItemBeans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import model.InsertItemModel;
import model.SelectAllItemModel;
import model.SelectCategoryModel;

@WebServlet("/admin_create_item")
@MultipartConfig
public class CreateItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CreateItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		AdminUserBeans adminInfo = (AdminUserBeans) session.getAttribute("adminBeans");
		
		if (adminInfo != null) {
			// TODO categoryを呼び出す処理
			ArrayList<CategoryBeans> categories = SelectCategoryModel.selectAll();
			request.setAttribute("categories", categories);
			String view = "/WEB-INF/views/adminCreateItem.jsp";
	        request.getRequestDispatcher(view).forward(request, response);
		} else {
			response.sendRedirect("admin_login");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// FIXME Controller内で一度Beansのコンストラクタを呼び出してsetterを通してから引数を渡す必要
		request.setCharacterEncoding("utf-8");
		String itemName = request.getParameter("item_name");
		String ss = request.getParameter("sales_status");
		boolean salesStatus = Boolean.valueOf(ss);
		
		Part image = request.getPart("image");
		String filename = Paths.get(image.getSubmittedFileName()).getFileName().toString(); // ファイル名を取得
		String path = "/Users/narumi/git/ECAppPractice/ECApp/src/main/webapp/image"; // アップロード先
		image.write(path+File.separator+filename); // 書き込み
		
		try{
			int price = Integer.parseInt(request.getParameter("price"));
			int categoryId = Integer.parseInt(request.getParameter("category"));
			InsertItemModel.insert(itemName, price, filename, categoryId, salesStatus);
			
			ArrayList<ItemBeans> itemBeans = SelectAllItemModel.selectAll();
			request.setAttribute("itemBeans", itemBeans);

			String view = "/WEB-INF/views/adminIndex.jsp";
	        request.getRequestDispatcher(view).forward(request, response);
        }
        catch (NumberFormatException ex){
            ex.printStackTrace();
        }
	}
}
