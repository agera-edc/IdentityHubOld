package org.eclipse.dataspaceconnector.dtos;

abstract class Status {
    private final int code;
    private final String detail;

    public Status(int code, String detail) {
        this.code = code;
        this.detail = detail;
    }

    public int getCode() {
        return code;
    }

    public String getDetail() {
        return detail;
    }
}
