package dev.hikari.oishibasho.infrastructure.utilies;

import lombok.Getter;

@Getter
public enum MessageCode {
    DUPLICATE (4000, "DUPLICATE", "Loi trung lap"),
    EXIST(4999, "EXIST", "Tai khoan da ton tai"),
    SUCCESS(2000, "SUCCESS", "Thành công"),
    FAIL(4001, "FAIL", "Thất bại"),
    ERROR(5000, "ERROR", "Lỗi hệ thống!"),
    ID_NOT_FOUND(4003, "ID NOT FOUND", "Không tìm thấy id"),
    EMPTY(4002, "SPECIAL RATING EMPTY", "Người dùng hệ thống chưa comment bài viết này"),
    ;
    private int code;
    private String message;
    private String description;

    MessageCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }
}
