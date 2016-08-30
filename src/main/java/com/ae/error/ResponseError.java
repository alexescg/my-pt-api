package com.ae.error;

import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Helper class for throwing specialized errors
 *
 * @author alexescg
 * @version 1.0
 * @since 8/29/16
 */
public class ResponseError {

    private final int status;
    private final String message;
    private Throwable cause;

    public ResponseError(Response.Status status, String message) {
        this.status = status.getStatusCode();
        this.message = message;
    }

    public ResponseError(Response.Status status) {
        this(status, status.toString());
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public static ResponseError causedByException(Exception e) {
        Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;
        Throwable cause = e.getCause();

        if (cause instanceof SQLException) {
            String sqlState = ((SQLException) cause).getSQLState();
            if (sqlState.equals(SQLErrorCode.UNIQUE_VIOLATION)) {
                status = Response.Status.CONFLICT;
            }
        }
        return new ResponseError(status, status.toString());
    }

    public Response build() {
        return Response.status(getStatus())
                .entity(this)
                .build();
    }

}

class SQLErrorCode {
    public static final String UNIQUE_VIOLATION = "23505";
}
