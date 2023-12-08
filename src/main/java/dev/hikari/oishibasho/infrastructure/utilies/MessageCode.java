package dev.hikari.oishibasho.infrastructure.utilies;

import lombok.Getter;

@Getter
public enum MessageCode {
    DUPLICATE (4000, "DUPLICATE", "Loi trung lap"),
    EXIST(4999, "EXIST", "Tai khoan da ton tai"),
    SUCCESS(2000, "SUCCESS", "Thành công"),
    FAIL(4001, "FAIL", "Thất bại"),
    ERROR_BOOK_CREATION(4002, "ERROR_CREATION", "Thêm mới book không thành công"),
    MISSING_CATEGORY_FIELD(4003, "MISSING_CATEGORY_FIELD", "Không được để trống trường category"),
    MISSING_QUANTITY_FIELD(4005, "MISSING_QUANTITY_FIELD", "Không được để trống trường quantity"),
    MISSING_LIBRARIAN_FIELD(4006, "MISSING_LIBRARIAN_FIELD", "Không được để trống trường librarian"),
    MISSING_LIMIT_DATE_FIELD(4007, "MISSING_LIMIT_DATE_FIELD", "Không được để trống trường limit date"),
    MISSING_TITLE_FIELD(4008, "MISSING_TITLE_FIELD", "Không được để trống trường title"),
    NOT_FOUND_ID(4009, "NOT_FOUND_ID", "Không tìm thấy thông tin với id"),
    ERROR_WRITE_EXCEL_FILE(4010, "ERROR_WRITE_EXCEL_FILE", "Lỗi ghi file excel"),
    LACK_OPERATION(1000, "LACK_OPERATION", "Thiếu toán tử"),
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
