package memo.model.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

// JOIN + 최종적으로 JSP 출력될 결과
public record MemoWithAuthorDTO(
        Long memoId,
        String title,
        String content,
        LocalDateTime memoCreatedAt,
        Long authorId,
        String authorUsername,
        String authorDisplayName
) {
    public static MemoWithAuthorDTO fromResultSet(ResultSet rs) throws SQLException {
        // ??? Map, 저장소 별도로 둬서 새로운 불변 객체 X. 꺼내다 쓰게 하는 경우...
        return new MemoWithAuthorDTO(
                rs.getLong("memo_id"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getTimestamp("created_at").toLocalDateTime(),
                rs.getLong("user_id"),
                rs.getString("username"),
                rs.getString("display_name")
        );
    }
}
