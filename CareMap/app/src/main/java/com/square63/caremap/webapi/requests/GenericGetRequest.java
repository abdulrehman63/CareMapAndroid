package com.square63.caremap.webapi.requests;

import java.io.Serializable;

public class GenericGetRequest implements Serializable{
    private int offset = 0;
    private int pageSize = 1;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}