package memo.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import memo.model.dao.MemoDAO;
import memo.model.dao.MemoJdbcDAO;

import java.io.IOException;

@WebServlet(urlPatterns = {"/memos", "/memos/new"})
public class MemoServlet extends HttpServlet {
    private MemoDAO memoDAO; // static? Servlet 매번 새롭게 그 때 그 때...
    // 생성자?


    // 생명주기 init - ... - destroy
    @Override
    public void init() throws ServletException {
        this.memoDAO = new MemoJdbcDAO(); // 이후 이 과정이 모두 추상화 예정
    }

    // 인터넷 접속
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1) /memos
        // 2) /memos/new
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8"); // 인코딩 처리 (폰트 안 깨지게)

        String servletPath = req.getServletPath(); // 요청 주소
        if (servletPath.equals("/memos/new")) { // == 하면 안됩니다
            // 작성 (create)
            return;
        }
        // 목록
    }
}
