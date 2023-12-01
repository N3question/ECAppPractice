package controller.adminUser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.function.Consumer;

import bean.AdminBeans;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

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
		AdminBeans adminInfo = (AdminBeans) session.getAttribute("adminBeans");
		
		if (adminInfo != null) {
			String view = "/WEB-INF/views/adminCreateItem.jsp";
	        request.getRequestDispatcher(view).forward(request, response);
		} else {
			response.sendRedirect("admin_login");
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		//name属性がpictのファイルをPartオブジェクトとして取得
		Part part = request.getPart("image");
		//ファイル名を取得
		//String filename=part.getSubmittedFileName();//ie対応が不要な場合
		String filename = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		//アップロードするフォルダ
		String path = "/Users/narumi/git/ECAppPractice/ECApp/src/main/webapp/image";
		//実際にファイルが保存されるパス確認
		System.out.println("ファイルの名前："+ filename);
		//書き込み
		part.write(path+File.separator+filename);
		
		request.setAttribute("filename", filename);

		String view = "/WEB-INF/views/adminIndex.jsp";
        request.getRequestDispatcher(view).forward(request, response);
	}
	
	protected void fileUpload(Part part, Consumer<String> function) {
		if ("".equals(part.getSubmittedFileName())) {
			return;
		}
		String filePath = "/image/" + part.getSubmittedFileName();
		try {
			part.write(getServletContext().getRealPath(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		function.accept(filePath);
	}
}
