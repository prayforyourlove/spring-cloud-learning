package com.dzsw.wqh.enumeration;

public enum  ResultEnum {
    SUCCESS("00", "成功"),
    FAIL("01","失败"),
    USER_REPEAT("02","用户已存在");
    private String code;

    private String message;

    ResultEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public static String gainMessage(String code) {
        for (ResultEnum resultEnum:ResultEnum.values()) {
            if (resultEnum.getCode().equals(code)){
                return resultEnum.getMessage();
            }
        }
        return null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
