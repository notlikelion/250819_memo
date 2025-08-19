package memo.model.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public record MemoDTO(
        Long memoId, // BIGINT
        Long userId, // MemoDTO PK -> FK
        String title,
        String content,
        LocalDateTime createdAt
) {
    public static MemoDTO fromResultSet(ResultSet rs) throws SQLException {
        return new MemoDTO(
                rs.getLong("memo_id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("content"),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}