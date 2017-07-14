package ru.itis.inform.dto.response;

/**
 * Created by Kamil Karimov on 13.07.2017.
 */
public class QueryErrorDto {
    private QueryResultInfoErrorDto meta;

    public QueryErrorDto(QueryResultInfoErrorDto meta) {
        this.meta = meta;
    }

    public QueryResultInfoErrorDto getMeta() {
        return meta;
    }

    public void setMeta(QueryResultInfoErrorDto meta) {
        this.meta = meta;
    }
}
