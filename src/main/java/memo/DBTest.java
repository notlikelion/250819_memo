package memo;

import memo.model.dao.MemoDAO;
import memo.model.dao.MemoJdbcDAO;
import memo.model.dao.UserDAO;
import memo.model.dao.UserJdbcDAO;

public class DBTest {
    public static void main(String[] args) {
        UserDAO userDAO = new UserJdbcDAO();
        MemoDAO memoDAO = new MemoJdbcDAO();
        try {
            userDAO.create("charlie", "Charlie Park");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
