package ru.itis.inform.dto.response;

import java.util.Objects;

/**
 * 13.07.2017.
 *
 * @author Maxim Romanov
 */
public class QueryResultInfoDto {

    private String code = null;
    private String status = null;

    public QueryResultInfoDto() {
    }

    public QueryResultInfoDto(String code, String status) {
        this.code = code;
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        QueryResultInfoDto that = (QueryResultInfoDto) o;

        return Objects.equals(code, that.code) &&
                Objects.equals(status, that.status);

    }

    @Override
    public int hashCode() {
        return Objects.hash(code, status);
    }

    @Override
    public String toString() {
        return "QueryResultInfoDto{\n" +
                "  code: " + code + "\n" +
                "\"  status: \"" + status + "\n" +
                "\n";
    }
}
