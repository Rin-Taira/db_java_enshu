package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Product;
import service.ProductService;
import util.ParamUtil;

@WebServlet("/search")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 文字化け対策
        request.setCharacterEncoding("UTF-8");

        // ID取得
        String id = request.getParameter("id");

        // 入力値のチェック
        if (ParamUtil.isNullOrEmpty(id)) {
            // メッセージ設定
            request.setAttribute("msg", "product_idを入力してください");

            // 次画面指定
            request.getRequestDispatcher("top.jsp").forward(request, response);
            return;
        }

        ProductService productService = new ProductService();
        Product product = productService.search(id);

        // 表示メッセージの受け渡し
        if (product == null) {
            // メッセージ設定
            request.setAttribute("msg", "対象のデータはありません。");

            // 次画面指定
            request.getRequestDispatcher("top.jsp").forward(request, response);
        } else {
        	
        	request.setAttribute("product", product);

            // 次画面指定
            request.getRequestDispatcher("searchResult.jsp").forward(request, response);
        }
    }

}
