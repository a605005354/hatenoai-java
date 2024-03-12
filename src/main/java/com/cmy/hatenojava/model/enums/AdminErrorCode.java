package com.cmy.hatenojava.model.enums;

public enum AdminErrorCode {
    USER_ALREADY_EXISTS(1000, "The username is already taken."),
    EMAIL_ALREADY_IN_USE(1001, "The email is already in use."),
    USER_DOES_NOT_EXIST(1002, "Couldn't find your Email Acount."),
    PASSWORD_NOT_MATCH(1003, "Wrong password. Please try again."),

    // Add more error codes and messages as needed
    ;

    private final Integer code;
    private final String message;

    AdminErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static AdminErrorCode fromCode(String code) {
        for (AdminErrorCode ec : AdminErrorCode.values()) {
            if (ec.getCode().equals(code)) {
                return ec;
            }
        }
        throw new IllegalArgumentException("No matching ErrorCode for [" + code + "]");
    }
}
