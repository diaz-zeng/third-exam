package com.diaz.thirdexam.exception;

public class IllegalDataException extends Exception {
    @Override
    public String getMessage() {
        return "数据异常，查询失败";
    }
}
