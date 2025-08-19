package memo.model.dto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public record UserDTO(
        Long userId, // BIGINT
        String username,
        String displayName,
        LocalDateTime createdAt
) {
    public static UserDTO fromResultSet(ResultSet rs) throws SQLException {
        return new UserDTO(
                rs.getLong("user_id"),
                rs.getString("username"),
                rs.getString("display_name"),
                rs.getTimestamp("created_at").toLocalDateTime()
        );
    }
}